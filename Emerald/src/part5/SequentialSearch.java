package part5;

public class SequentialSearch<Key, Value> {

	private Node first;
	
	private class Node{
		Key key; 
		Value value;
		Node next;
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public Value get(Key k) {
		for(Node x = first; x != null; x = x.next) {
			if(x.key.equals(k)) return x.value;
		}
		return null;
	}
	
	public void put(Key key, Value value) {
		for(Node x =first; x != null; x= x.next) {
			if(x.key.equals(key)) {
				x.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
	}
}
