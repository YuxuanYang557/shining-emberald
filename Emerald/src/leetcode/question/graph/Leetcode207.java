package leetcode.question.graph;

import java.util.ArrayList;
import java.util.List;

public class Leetcode207 {

	boolean[] marked;
	boolean[] onstack;
	boolean isCycle;
	List<Integer>[] adj;
	public boolean canFinish(int numCourses, int[][] pre) {
		int length = pre.length;
		adj = new List[length];
		for(int i = 0; i< numCourses; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<length; i++) {
			adj[pre[i][1]].add(pre[i][0]);
		}
		
		marked = new boolean[numCourses];
		onstack = new boolean[numCourses];
		isCycle = false;
		for(int i = 0; i< numCourses; i++) {
			if(!marked[i]) dfs(i);
			if(isCycle) return false;
		}
		return  true;
	}
	
	private void dfs(int v) {
		onstack[v] = true;
		marked[v] = true;
		for(int w : adj[v]) {
			if(isCycle) return;
			if(!marked[w]) dfs(w);
			if(onstack[w]) isCycle = true;
		}
		onstack[v] = true;
	}
}
