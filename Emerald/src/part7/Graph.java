package part7;

public class Graph {
	private final int V;
	private final int E;
	private Bag<Integer>[] adj;
	
	public Graph(int v) {
		this.V = V;
		adj =(Bag<Integer>[]) new Object[V];
		for(int v =0, v<V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	public int V() {return V;}
	public int E() {return E;}
	
	public void addEdge(int v , int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public int Iterable<Integer> adj(int v){
		return adj[v];
	}
}
