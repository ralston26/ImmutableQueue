package jp.co.worksap.global;


public class HelperQueue<E> {
	private HelperQueue<E> element;
	private E value;
	public HelperQueue<E> getElement() {
		return element;
	}
	public void setElement(HelperQueue<E> element) {
		this.element = element;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	
}