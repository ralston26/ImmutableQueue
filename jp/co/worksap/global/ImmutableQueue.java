package jp.co.worksap.global;
import jp.co.worksap.global.HelperQueue;
import java.util.NoSuchElementException;
/**
* The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
* @param <E>
*/
public class ImmutableQueue<E> {
 /**
 * requires default constructor.
 */
	HelperQueue<E> begin;
	HelperQueue<E> end;
	private int queueLength;
	
 public ImmutableQueue() {
 // modify this constructor if necessary, but do not remove default constructor
	 begin=end=null;
	 queueLength=0;
 
 }
 // add other constructors if necessary
 private ImmutableQueue(HelperQueue<E> begin, HelperQueue<E> end,int queueLength){
		this.begin=begin;
		this.end=end;
		this.queueLength=queueLength;
	}
 /**
 * Returns the queue that adds an item into the tail of this queue without modifying this queue.
 * <pre>
 * e.g.
 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
 * this method returns a new queue (2, 1, 2, 2, 6, 4)
 * and this object still represents the queue (2, 1, 2, 2, 6) .
 * </pre>
 * If the element e is null, throws IllegalArgumentException.
 * @param e
 * @return
 * @throws IllegalArgumentException
 */
 public ImmutableQueue<E> enqueue(E e) {
	 if (e == null)		{
			throw new IllegalArgumentException();
		}
	 	HelperQueue<E> begin = this.begin;
		HelperQueue<E> end = new HelperQueue<E>();
		end.setElement(this.end);
		end.setValue(e);
		if (size() == 0){
			begin=end;
		}
		return new ImmutableQueue<E>(begin, end, queueLength+1);
 }
 /**
 * Returns the queue that removes the object at the head of this queue without modifying this queue.
 * <pre>
 * e.g.
 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
 * this method returns a new queue (1, 3, 3, 5, 1)
 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
 * </pre>
 * If this queue is empty, throws java.util.NoSuchElementException.
 * @return
 * @throws java.util.NoSuchElementException
 */
 public ImmutableQueue<E> dequeue() {
	 if (size() == 0)		{
			throw new NoSuchElementException();
		}
		if (size() == 1){
			return new ImmutableQueue<E>(null, null, queueLength-1);
		}
		HelperQueue<E> begin = this.end;
		HelperQueue<E> end = this.end;
		while (begin.getElement() != this.begin)
		{
			begin = begin.getElement();
		}	
		return new ImmutableQueue<E>(begin, end, queueLength-1);
 }

 /**
 * Looks at the object which is the head of this queue without removing it from the queue.
 * <pre>
 * e.g.
 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
 * </pre>
 * If the queue is empty, throws java.util.NoSuchElementException.
 * @return
 * @throws java.util.NoSuchElementException
 */
 public E peek() {
	 if (size() == 0){
			throw new NoSuchElementException();
		}
		return this.begin.getValue();
 }

 /**
 * Returns the number of objects in this queue.
 * @return
 */
 public int size() {
	 return queueLength;
 }
}