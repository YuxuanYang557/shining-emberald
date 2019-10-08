package leetcode.question.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Backtrack2 {

	public List<List<String>> patition(String s){
		List<List<String>> res = new ArrayList<>();
		List<String> sub = new ArrayList<>();
		backtrack(s, 0, res, sub);
		return res;
	}
	
	private void backtrack(String s, int pos, List<List<String>> res, List<String> sub) {
		if(pos == s.length()) res.add(new ArrayList<String>(sub));
		else {
		for(int i = 0; i< s.length(); i++) {
			if(isPal(s, pos, i)) {
				sub.add(s.substring(pos, i+1));
				backtrack(s, i+1, res, sub);
				sub.remove(sub.size() -1);
			}
		}
		}
	}
	
	private boolean isPal(String s, int start, int end) {
		while(start < end) if(s.charAt(start++) != s.charAt(end--)) return false;
		return true;
	}
}
