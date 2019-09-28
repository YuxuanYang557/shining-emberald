package leetcode.question.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
	
	 public class TreeNode {
		     private int val;
		     private TreeNode left;
		     private TreeNode right;
		     private TreeNode(int x) { val = x; }
		  }
	 
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> orderlist = new ArrayList<>();
		 Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		 if(root == null) return orderlist;
		 q.offer(root);
		 while(!q.isEmpty()) {
			 int size = q.size();
			 List<Integer> sublist = new ArrayList<>();
			 for(int i = 0; i< size; i++) {
				 TreeNode node = q.poll();
				 sublist.add(node.val);
				 
				 if(node.left != null) q.offer(node.left);
				 if(node.right != null) q.offer(node.right);
			 }
			 orderlist.add(sublist);
		 }
		 return orderlist;
	 }
}
