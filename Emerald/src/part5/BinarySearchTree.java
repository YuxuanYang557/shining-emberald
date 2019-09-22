package part5;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	TreeNode root;
	
	private class TreeNode{
		Key key;
		Value value;
		TreeNode left; 
		TreeNode right;
		int n;
		public TreeNode(Key key, Value value, int n) {
			this.key = key;
			this.value = value;
			this.n = n;
		}
	}
	
	public int size() {
		return size(root);
	}
	public int size(TreeNode root) {
		if(root == null) return 0;
		else return root.n;
	}
	
	public Value get(Key key) {
		return get(root, key);	
	}
	public Value get(TreeNode x, Key key) {
		if(x == null) return null;
		int cmd = key.compareTo(x.key);
		if(cmd > 0) return get(x.right, key);
		else if(cmd < 0) return get(x.left,key);
		else return x.value;
	}
	
	public void put(Key key, Value value) {
		put(root, key, value);
	}
	public TreeNode put(TreeNode x, Key k, Value val) {
		if(x == null) return new TreeNode(k, val, 1);
		int cmd = k.compareTo(x.key);
		if(cmd > 0) return x.right = put(x.right, k, val);
		else if(cmd < 0) return x.left = put(x.left,k, val);
		else x.value = val;
		x.n= x.left.n + x.right.n;
		return x;
	}
	
	public Key min() {
		return min(root);
	}
	public Key min(TreeNode x) {
		if(x.left == null) return x.key;
		return min(x.left);
	}
	
	public Key floor(Key key) {
		 if(floor(root, key)== null)return null;
		 else return floor(root, key).key;
	}
	public TreeNode floor(TreeNode x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
			TreeNode t = floor(x.right, key);
			if(t != null) return t;
			else return x;
	}
	
	public void deleteMin() {
		deleteMin(root);
	}
	public TreeNode deleteMin(TreeNode x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.n = x.left.n + x.right.n;
		return x;
	}
	
	public void delete(Key key) {
		delete(root, key);
	}
	public TreeNode delete(TreeNode x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0) x.left = delete(x.right, key);
		else if(cmp < 0) x.right = delete(x.left, key);
		else {
			if(x.left == null) return x.right;
			if(x.right == null) return x.left;
			TreeNode t = x;
			x = (BinarySearchTree<Key, Value>.TreeNode) min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = x.right.n + x.left.n;
		return x;
	}
	
	
}
