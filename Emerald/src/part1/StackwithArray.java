package part1;
import java.util.Iterator;

public class StackwithArray<Item> implements Iterable<Item> {
	private Item[] stack = (Item[]) new Object[1];
	private int n;
	
	public boolean isEmpty() { return n == 0;}
	public int size() { return n;}
	
	private void resize(int num) {
		Item[] newArray = (Item[]) new Object[num];
		for(int i = 0; i< stack.length; i++) {
			newArray[i] = stack[i];
		}
		stack = newArray;
	}
	
	public void push(Item item) {
		stack[n++] = item;
		if(n == stack.length) resize(2*stack.length);
	}
	
	public Item push() {
		Item item = stack[n--];
		stack[n] = null;
		if(n == stack.length/4) resize(stack.length/2);
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		int i = n;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return stack[--i];
		}
		
	}
}
