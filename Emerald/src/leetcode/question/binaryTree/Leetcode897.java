package leetcode.question.binaryTree;

public class Leetcode897 {
	
	public class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		private TreeNode(int x) { val = x; }
		 }

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
