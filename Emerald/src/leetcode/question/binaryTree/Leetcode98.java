package leetcode.question.binaryTree;

import java.util.Stack;

//validate binary search tree
public class Leetcode98 {
	  public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	//use stack to inorder traverse a tree
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> st = new Stack<>();
		TreeNode prev = null;
		while(!st.isEmpty() && root != null) {
			//1.always go to the left most and put every node in stack
			while(root != null){
			st.add(root); //add 5, 4, 3, 2, 1
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
