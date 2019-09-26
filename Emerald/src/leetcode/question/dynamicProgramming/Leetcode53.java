package LeetcodeDP;

public class Leetcode53 {

	//Maximum Subarray
	//contiguous subarray which has the largest sum and return its sum.
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			max = Math.max((nums[i] > 0? nums[i]:0) +dp[i-1], max);
		}
		return max;
	}
}
