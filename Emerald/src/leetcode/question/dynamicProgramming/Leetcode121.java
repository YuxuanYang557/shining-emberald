package leetcode.question.dynamicProgramming;

public class Leetcode121 {

	//best time to buy and sell stock
	public int maxProfit(int[] prices) {
		int curmax = 0;
		int max = 0;
		for(int i = 1; i< prices.length; i++) {
			curmax = Math.max(0, curmax += prices[i] - prices[i-1]);
			max = Math.max(max, curmax);
		}
		return max;
	}
}
