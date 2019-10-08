package leetcode.question.array;

public class Leetcode189 {
	
	//method1 rotate the element in place
	//1.reverse the whole array
	//2.reverse the left K part
	//3.reverse the right K part
	public void rotate(int[] nums, int k) {
		rotateNums(nums, 0, nums.length -1);
		rotateNums(nums, 0, k);
		rotateNums(nums, k , nums.length-1);
	}
	
	public void rotateNums(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start ++;
			end ++;
		}
	}
	
	//method2 generate another copy of array and get part of it;
	public void rotate2(int[] nums, int k) {
		k = k%nums.length;
		int[] nums2 = new int[nums.length *2];
		for(int i = 0; i< nums.length; i++) {
			nums2[i] = nums[i];
			nums2[i+nums.length] = nums[i];
		}
		for(int j = 0; j< nums.length; j++) {
			nums[j] = nums2[nums.length -k +j];
		}
	}

}
