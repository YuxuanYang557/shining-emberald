package part7;

import part1.Queue;

public class BreathFirstSearch {
	private boolean[] marked;
	private int[] edge;
	private final int s;
	
	public BreathFirstSearch(Graph G, int s) {
		marked = new boolean[G.v()];
		edge = new int[G.v()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		q.push(s);
		marked[s] =true;
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for(int w : G.adj(v)) {
				edge[w] = v;
				marked[w] = true;
				q.push(w);
			}
		}

	}
}
