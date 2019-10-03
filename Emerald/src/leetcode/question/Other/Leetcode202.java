package leetcode.question.Other;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {

	//method1 using Set to detect whether exist a loop
	public boolean isHappy(int n) {
		Set<Integer> inLoop = new HashSet<>();
		int sum;
		int remain;
		while(inLoop.add(n)) {
			sum =0;
			while(n > 0) {
				remain = n%10;
				sum += remain * remain;
				n /= 10;
			}
			if(sum == 1) return true;
			else 	n = sum;
		}
		return false;
	}
	
	//method2 use two pointer to find loop
	//one is fast, one is slow
	//if loop exist, the two pointer will finally met and slow == fast
	public boolean isHappy2(int n) {
		int slow, fast;
		slow = fast = n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
		}while(slow != fast);
		if(slow == 1) return true;
		else return false;
	}
	
	public int digitSquareSum(int n) {
		int sum = 0,remain = 0;
		while(n > 0) {
			remain = n%10;
			sum += remain * remain;
			n /= 10;
		}
		return sum;
	}
}
