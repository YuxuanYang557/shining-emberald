package part3;

public class MergeSort {
	private Comparable[] aux;
	
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) <0;
	}
	private void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void TopDownsort(Comparable[] a) {
		aux = new Comparable[a.length-1];
		TopDownsort(a, 0, a.length-1);
	}
	public void TopDownsort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int mid = lo + (lo+hi)/2;
		TopDownsort(a, lo, mid-1);
		TopDownsort(a, mid, hi);
		merge(a, lo, mid, hi);
		
	}
	
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		int k = lo;
		
		for(int m = lo; m< hi; m++) {
			aux[m] = a[m];
		}
		for(int n = lo; n< hi; n++) {
			if(i > mid) a[k++] = aux[j++];
			if(j > hi)  a[k++] = aux[i++];
			if(less(aux[j],aux[i])) a[k++] = a[j++];
			else						a[k++] = a[i++];
		}
	}
	
	public void bottomUpSort(Comparable[] b) {
		for(int sz =1; sz < b.length; sz= sz+sz) {
			for(int lo =0; lo+sz< b.length; lo+= sz+sz) {
				merge(b, lo, lo+sz-1, Math.min(lo+sz+sz-1, b.length-1));
			}
		}
	}
}
