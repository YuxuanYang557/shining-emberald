package part6;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public class Node{
		Key key;
		Value value;
		Node left; 
		Node right;
		int N;
		boolean color;
		public Node(Key key, Value value, int N, Boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}
	}
	
	public boolean isRED(Node node) {
		if(node == null) return false;
		return node.color == RED;
	}
	
	public Node rotateLeft(Node node) {
		Node r = node.right;
		node.right = r.left;
		r.left = node;
		r.color = node.color;
		node.color = RED;
		node.N = r.N;
		r.N = 1+ r.left.N + r.right.N;
		return r;
	}
	
	public Node rotateRight(Node node) {
		Node l = node.left;
		node.left = l.right;
		l.right = node;
		l.color = node.color;
		node.color = RED;
		node.N = l.N;
		l.N = 1 + l.left.N + l.right.N;
		return l;
	}
	
	public void flipColor(Node node) {
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
	}
	
	public Node put(Node root, Key key, Value value) {
		if(root == null) return new Node(key, value, 1, RED);
		int cmp = key.compareTo(root.key);
		if(cmp > 0) root.right = put(root.right, key, value);
		else if(cmp < 0) root.left = put(root.left, key, value);
		else  root.value = value;
		
		if(!isRED(root.left) && isRED(root.right)) root = rotateLeft(root);
		if(isRED(root.left) && isRED(root.left.left)) root = rotateRight(root);
		if(isRED(root.left) && isRED(root.right)) flipColor(root);
		root.N = root.left.N + root.right.N +1;
		return root;
	}
	
	
	
	
}
