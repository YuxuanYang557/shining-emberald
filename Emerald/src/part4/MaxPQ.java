package part4;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	private HeapUtili hpu = new HeapUtili();
	
	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max];
	}
	
	public boolean isEmpty() { return n == 0;}
	public int size() { return n;}
	
	public void insert(Key key) {
		pq[++n] = key;
		hpu.swim(pq, n);
	}
	
	public Key deleteMax() {
		Key max = pq[1];
		pq[1] = pq[n];
		pq[n] = null;
		hpu.sink(pq, 1, n);
		return max;
	}

		
	
}
