package cs146F21.vu.project1;

/**
 *
 * @param <T> SinglyList is a generic singly list of elements of type <T>
 */
public class SinglyList<T> {
	// The top node, initially null
	private Node<T> head;
	// Count the size of SinglyList
	private int size;

	public SinglyList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Add a node at begin of the list.
	 * 
	 * @param item the type of data to be inserted.
	 */
	public void insertItem(T item) {
		long startTime = System.nanoTime();
		if (!foundItem(item)) {
			Node<T> temp = new Node<T>(item);
			if (isEmpty() == false) {
				temp.setNext(head);
			}
			head = temp;
			size++;
		}
		long estimateTime = System.nanoTime() - startTime;
		System.out.println("\t\tEstimate insert time run: " + estimateTime + "ns");
	}

	/**
	 * Go through the List, found item return true, false if not founded.
	 * 
	 * @param item
	 * @return true if Item founded, otherwise false.
	 */
	public boolean foundItem(T item) {
		Node<T> current = head;
		while (current != null) {
			if (current.getData() == item) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		return false;
	}

	/**
	 * Reset a List, size = 0, head = null;
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Remove a specific in a list.
	 * 
	 * @param item
	 * @return true, if item was founded and remove.
	 */
	public boolean removeItem(T item) {
		long startTime = System.nanoTime();
		if (foundItem(item)) {
			// Check if the first node is contain item, if yes remove it and size --;
			if (head.getData() == item) {
				head = head.getNext();
				size--;
				long estimateTime = System.nanoTime() - startTime;
				System.out.println(
						"\t\tEstimate removeItem time run in case of the first node is contain item: " + estimateTime);
			} else {
				// Set the temp value = head;
				Node<T> current = head;
				// call recursive function to have storage all the value before go through.
				removeItemHelper(item, current);
			}
			long estimateTime = System.nanoTime() - startTime;
			System.out.println("\t\tEstimate removeItem time run: " + estimateTime + "ns");
			return true;

		} else
			System.out.println("\t\tItem not found");
		return false;
	}

	/**
	 * list {1,2,3,4,5 remove{3} 1 != 3 =>list{2,3,4,5}, 2 != 3 =>list{3,4,5} 3 was
	 * found ==> add all element after 3 to the new list. newList = {4,5}. Recursive
	 * function: newList.insert{2} ==> newList = {2,4,5} , newList.insert(1) =
	 * {1,2,4,5}.
	 * 
	 * @param item item need to be remove.
	 * @param temp store temp Node.
	 */
	private void removeItemHelper(T item, Node<T> temp) {
		if (temp.getData() != item) {
			size--;
			removeItemHelper(item, temp.getNext());
			insertItem(temp.getData());
		} else {
			clear();
			head = temp.getNext();
		}
	}

	/**
	 * Remove all elements have on both list, then add the element from other list
	 * to current list.
	 * 
	 * @param other get another List.t
	 * @return return the newList as result
	 */
	public SinglyList<T> unionTo(SinglyList<T> other) {
		long startTime = System.nanoTime();
		Node<T> current = other.head;
		SinglyList<T> unionResult = new SinglyList<T>();
		unionResult.head = head;
		unionResult.size = getSize();
		while (current != null) {
			if (!foundItem((T) current.getData())) {
				unionResult.insertItem((T) current.getData());
			}
			current = current.getNext();
		}
		long estimateTime = System.nanoTime() - startTime;
		System.out.println("\t\tEstimate unionTo time run: " + estimateTime + "ns");

		return unionResult;
	}

	/**
	 * Found all value contain in both List, then insert that value to a newList,
	 * then return.
	 * 
	 * @param other get another List.
	 * @return return the newList as result
	 */
	public SinglyList<T> intersectionTo(SinglyList<T> other) {
		long startTime = System.nanoTime();
		SinglyList<T> intersectionResult = new SinglyList<T>();
		Node<T> current = (getSize() >= other.getSize()) ? head : other.head;
		while (current != null) {
			if (foundItem(current.getData()) && other.foundItem(current.getData())) {
				intersectionResult.insertItem(current.getData());
			}
			current = current.getNext();
		}
		long estimateTime = System.nanoTime() - startTime;
		System.out.println("\t\tEstimate intersectionTo time run: " + estimateTime + "ns");
		return intersectionResult;
	}

	/**
	 * Check in an list is empty or not
	 * 
	 * @return true, false.
	 */
	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	/**
	 * Get Size of a List.
	 * 
	 * @return size of a List type integer.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return Node object
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * prin out the value
	 */
	@Override
	public String toString() {
		String result = "[";
		Node<T> current = head;
		while (current != null) {
			result += current.getData();
			if (current.getNext() != null) {
				result += ", ";
			}
			current = current.getNext();
		}
		return result + "]";
	}
}
