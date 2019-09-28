package leetcode.question.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode973 {
	
	public int[][] KClosest(int[][] points, int k){
		int[][] res = new int[k][2];
		Queue<int[]> minpq = new PriorityQueue<>((p1,p2) -> 
		p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] - p1[1]);
		
		for(int[] point : points) {
			minpq.offer(point);
			if(minpq.size() > k) {
				minpq.poll();
			}
		}
		while(k > 0) {
			res[--k] = minpq.poll();
		}
		return res;
	}
}
