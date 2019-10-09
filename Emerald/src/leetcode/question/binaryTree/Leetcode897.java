package leetcode.question.binaryTree;

public class Leetcode897 {
	
	public class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		private TreeNode(int x) { val = x; }
		 }

	//if want generate a new tree and return the head
	//should have two pointer: head and iteration node !!!
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(0);
        cur = node;
        inorder(root);
        return node.right;
    }
    
    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
