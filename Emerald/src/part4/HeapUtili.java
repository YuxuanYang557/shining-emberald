package part4;

public class HeapUtili {
	
	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) <0;
	}
	public void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void sink(Comparable[] a, int m, int length) {
		while(2*m <= length) {
			int i =2*m;
			if(i < length && less(i, i+1)) i++;
			if(!less(m, i)) break;
			m = i;
		}
	}
	
	public void swim(Comparable[] b, int n) {
		while(n > 1 && less(n/2, n)) {
			exch(b, n/2, n);
		}
	}
}
