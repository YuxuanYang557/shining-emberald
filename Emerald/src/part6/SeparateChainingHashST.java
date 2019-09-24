package part6;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
	
	private int size = 16;
	private Node[] hashtable =(Node[]) new Object[size];
	
	public class Node{
		Key key;
		Value value;
		Node next;
		public Node(Key key, Value value, Node next){
			this.value = value;
			this.key = key;
			this.next = next;
		}
	}
	
	private int hash(Key key) {
		return ((key.hashCode() & 0x7fffffff) % size);
	}
	
	public void push(Key key, Value val) {
		int i = hash(key);
		if(hashtable[i] == null) hashtable[i] = new Node(key, val, null);
		else{
			for(Node x = hashtable[i]; x != null; x= x.next) {
				if(x.key == key) x.value= val;
			}
			hashtable[i] = new Node(key, val, hashtable[i]);
		}	
	}
	
	public Value get(Key key) {
		int i = hash(key);
		if(hashtable[i] == null) return null;
		else{
			for(Node x = hashtable[i]; x != null; x= x.next) {
				if(x.key == key) return x.value;
			}
			return null;
		}	
	}
	
	
}
