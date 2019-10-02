package leetcode.question.binaryTree;

import java.util.Stack;

public class Leetcode98 {
	  public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> st = new Stack<>();
		TreeNode prev = null;
		while(!st.isEmpty() && root != null) {
			while(root != null){
			st.add(root);
			root = root.left;
			}
			root = st.pop();
			if(prev != null && root.val <= prev.val) return false;
			prev = root;
			root = root.right;
		}
		return true;
	}
}
