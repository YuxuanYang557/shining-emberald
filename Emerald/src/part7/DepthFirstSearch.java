package part7;

public class DepthFirstSearch {
	private boolean[] marked;
	private int[] edge;
	private final int s;
	
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		edge = new int[G.V()];
		this.s = s;
		dfs(G, v);
	}
	
	private void dfs(Graph G, int v) {
		
		marked[v] = true;
		
		for(int w : G.adj(v)) {
			
			if(!marked[w]) {
				edge[w] = v;
				dfs(G,w);
			}
		}
	}
}
