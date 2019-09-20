package part1;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int n;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null;}
	public int size() { return n;}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new stackIterator();
	}
	private class stackIterator implements Iterator<Item>{
		private Node node = first;

		@Override
		public boolean hasNext() {
			return node.next != null ;
		}

		@Override
		public Item next() {
			Item item = node.next.item;
			node = node.next;
			return item;
		}
		
	}
	
}
