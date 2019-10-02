package leetcode.question.binaryTree;

import java.util.Stack;

public class Leetcode101 {

	  public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }	
	//method1 recursive
	public boolean isSymmetric1(TreeNode root) {
		return root == null || isSymmetric1(root.left, root.right);
	}
	public boolean isSymmetric1(TreeNode left, TreeNode right) {
		if(right == null || left == null) {
			return right == left;
		}
		if(right.val != left.val) return false;
		return isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
	}

	//method2 non-recursive
	public boolean isSymmetric2(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> st = new Stack<>();
		st.push(root.left);
		st.push(root.right);
		while(!st.isEmpty()) {
			TreeNode t1 = st.pop(), t2 =st.pop();
			if(t1 == null && t2 == null) continue;
			if(t1 == null || t2 == null || t1.val != t2.val) return false;
			st.push(t1.left);
			st.push(t2.right);
			st.push(t1.right);
			st.push(t2.left);
		}
		return true;
	}
	
}
