package part1;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int n;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null;}
	public int size() { return n;}
	
	public void push(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if(isEmpty()) first = last;
		else			  oldlast.next = last;
		n++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last =null;
		n--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new queueIterator();
	}
	public class queueIterator implements Iterator<Item>{
		private Node node = first;
		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public Item next() {
			Item item =  node.next.item;
			node = node.next;
			return item;			
			
		}
		
	}
}
