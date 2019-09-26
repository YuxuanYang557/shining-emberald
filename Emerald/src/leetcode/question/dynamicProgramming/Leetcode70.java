package leetcode.question.dynamicProgramming;

public class Leetcode70 {

	//climbing stairs
	public int climbStairs(int n) {
		if(n<0) return 0;
		return 1+ climbStairs(n-1) + climbStairs(n-2);
	}
}
