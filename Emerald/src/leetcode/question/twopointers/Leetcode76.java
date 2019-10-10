package leetcode.question.twopointers;

import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
	
	public String minWindow(String s ,String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, 0);
		}
		for(char c : t.toCharArray()) {
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else return "";
		}
		
		int start = 0, end = 0, minstart = 0, minlen = Integer.MAX_VALUE, count = t.length();
		while(end < s.length()) {
			char c1 = s.charAt(end);
			if(map.containsKey(c1))
				count--;
			map.put(c1, map.get(c1) -1);
			end++;
			
			while(count == 0) {
				if(minlen > end - start) {
					minlen = end - start;
					minstart = start;
				}
				 char c2 = s.charAt(start);
				 map.put(c2, map.get(c2)+1);
				 if(map.get(c2) > 0)
					 count++;
				 start++;
			}
		}
		return minlen == Integer.MAX_VALUE ? "": s.substring(minstart, minstart+start);
	}
}
