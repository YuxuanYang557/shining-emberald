package leetcode.question.Other;

public class Leetcode204 {

	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for(int i = 2; i< n; i++) {
			if(!notPrime[i]) count++;
			for(int j = 1; j*i< n; j++ ) {
				notPrime[j*2] = true; 
			}
		}
		return count;
	}
}
