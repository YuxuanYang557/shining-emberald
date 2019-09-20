package part3;

public class EleSort {
	
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) <0;
	}
	private void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void selectionSort(Comparable[] a) {
		for(int i = 0; i< a.length; i++) {
			for(int j = i; j< a.length; j++) {
				if(less(a[j],a[i])) exch(a,i, j);
			}
		}
	}
	
	public void insertionSort(Comparable[] b) {
		for(int i = 1; i<b.length; i++) {
			for(int j =i -1; j > 0 && less(b[j],b[j-1]); j--) {
				exch(b, j, j-1);
			}
		}
	}
}
