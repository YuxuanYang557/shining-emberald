package part5;

import java.util.Enumeration;

public class BinarySearch<Key extends Comparable<Key>, Value> {
	
	private Key[] keys;
	private Value[] values;
	private int n;
	private Enumeration<String> em;
	
	
	public BinarySearch(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Comparable[capacity];
		n = 0;
		
	}
	
	public boolean isEmpty() { return n == 0;}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i > n && key.compareTo(keys[i]) == 0) return values[i];
		else return null;
	}
	
	public void put(Key key, Value value) {
		int i = rank(key);
		if(i > n && key.compareTo(keys[i]) == 0) values[i] = value;
		else {
			for(int j = n; j >= i; j--) {
				keys[j+1] = keys[j];
				values[j+1] = values[j];
			}
			keys[i] = key;
			values[i] = value;
			n++;
		}
	}
		
	public int rank(Key key) {
		int lo = 0;
		int hi = n-1;
		while(lo <= hi) {
			int mid = lo + (lo + hi)/2;
			int cmd = key.compareTo(keys[mid]);
			if(cmd > 0) lo = mid+1;
			else if(cmd < 0) hi = mid-1;
			else return mid;
		}
		return lo;
	}
	
	public Key min() { return keys[0];}
	
	public Key max() { return keys[n];}
	
	public Key select(int k) { return keys[k];}
	
	public void delete(Key key) {
		int i = rank(key);
		if(key.compareTo(keys[i]) == 0) {
			for(int j =i ; j< n; j++) {
				keys[j] = keys[j+1]; values[j] = values[j+1]; 
			}
			n--;
		}
	}
	
	
	
}
