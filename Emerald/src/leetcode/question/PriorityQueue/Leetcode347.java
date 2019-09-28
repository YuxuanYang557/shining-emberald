package leetcode.question.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode347 {

	public List<Integer> topFrequent(int[] nums, int k){
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> numMap = new HashMap<>();
		for(int num : nums) {
			if(!numMap.containsKey(num)) numMap.put(num, 1);
			else		numMap.put(num, numMap.get(num) +1);
		}
		
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((s1,s2) ->
		s2.getValue() - s1.getValue());
		for(Map.Entry<Integer, Integer> set: numMap.entrySet()) {
			pq.offer(set);
			if(pq.size() >k) pq.poll();
		}
		
		while(k > 0) {
		res.add(pq.poll().getValue());
		k--;
		}
		return res;
	}
}
