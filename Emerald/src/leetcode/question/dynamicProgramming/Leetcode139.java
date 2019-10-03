package leetcode.question.dynamicProgramming;

import java.util.List;

public class Leetcode139 {
	
	//
	public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] bp = new boolean[l+1];
        bp[0] = true;
        for(int i =1; i<= l; i++){
            for(int j = 0; j<i; j++){
                if(wordDict.contains(s.substring(j,i)) && bp[j]) {
                    bp[i] = true;
                    break;
                }
            }
        }
        return bp[l];
    }
}
