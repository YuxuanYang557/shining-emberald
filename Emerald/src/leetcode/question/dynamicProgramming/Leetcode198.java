package leetcode.question.dynamicProgramming;

import java.util.Arrays;

public class Leetcode198 {
	//stpe1 top-down recursive method
	//house robber
	public int houseRobber(int[] nums) {
		int l = nums.length-1;
		return robMax(nums, l);
	}	
	private int robMax(int[] nums, int l) {
		if(l < 0) return 0;
		return Math.max(robMax(nums, l-2)+nums[l], robMax(nums, l-1));
	}
	
	//step2 recursive + top-down memo
	int[] memo;
	public int houseRobber2(int[] nums) {
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		int l = nums.length-1;
		return robMax2(nums, l);
	}
	private int robMax2(int[] nums, int l) {
		if(l < 0) return 0;
		if(memo[l] >0) return memo[l];
		int result = Math.max(robMax2(nums, l-2) + nums[l], robMax2(nums, l-1));
		memo[l] = result;
		return result;
	}
	
	//step3 turn the recursive to iterative + memo(bottom-up)
	public int HouseRobber3(int[] nums) {
		int[] memo = new int[nums.length +1];
		memo[0] = 0;
		memo[1] = nums[0];
		for(int i = 1; i<nums.length; i++) {
			int val = nums[i];
			memo[i+1] = Math.max(memo[i-1] + val, memo[i]);
		}
		return memo[nums.length];
	}
	
	//step4 turn memo into two pointer and using iterative
	public int HouseRobber4(int[] nums) {
		int prev1 =0;
		int prev2 =0;
		for(int i = 1; i< nums.length; i++) {
			int temp = prev1;
			prev1 = Math.max(prev2 + nums[i], prev1);
			prev2 = temp;
		}
		return prev1;	
	}
	
	
	
}
