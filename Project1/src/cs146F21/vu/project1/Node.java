package cs146F21.vu.project1;

/**
 * Inner class Node with attribute next of Type Node and data of generic type
 */
public class Node<T> {
	private Node<T> next;
	private T data;

	public Node(T data) {
		this.next = null;
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

}