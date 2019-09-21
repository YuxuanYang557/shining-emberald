package part4;

public class HeapSort extends HeapUtili{
	
	public void sort(Comparable[] a) {
		int l = a.length;
		for(int k= l/2; k >= 1 ; k--) {
			sink(a, k, l);
		}
		while(l>1) {
			exch(a, 1, l--);
			sink(a,1 ,l);
			
		}
	}
}
