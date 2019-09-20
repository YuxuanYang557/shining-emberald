package part3;

public class QuickSort {
	
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) <0;
	}
	private void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void sort(Comparable[] a, int lo, int hi){
		if(lo <= hi) return;
		int j = partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public int partition(Comparable[] a, int lo, int hi) {
		int k = lo;
		int i = lo+1;
		int j = hi;
		while(true) {
			while(less(a[i++], a[k])) if(i == hi) break;
			while(less(a[k], a[j++])) if(j == lo) break;
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,k,j);
		return j;
	}
}
