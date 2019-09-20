package part2;

public class BinarySearch {
	
	public int rank(int key, int[] nums) {
		int lo = 0;
		int hi = nums.length;
		int mid = lo + (lo +hi)/2;
		while(lo<=hi) {
			if(key > nums[mid]) lo = mid+1;
			else if(key < nums[mid]) hi = mid-1;
			else		return mid;
		}
		return -1;
	}
}
