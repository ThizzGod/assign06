package assign06;

public class Node<E> {
	E value;
	Node<E> nextNode;
	
	public Node(E value) {
		this.value = value;
		this.nextNode = null;
	}
}
