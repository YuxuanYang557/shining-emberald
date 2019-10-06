package leetcode.question.dynamicProgramming;

import java.util.Arrays;

public class Leetcode279 {

	public int numSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i<= n; i++) {
			int min = dp[i];
			int j = 1;
			while(i - j*j >=0) {
				min = Math.min(min, dp[i - j*j] +1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}
}
