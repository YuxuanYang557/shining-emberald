package debug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class debug2 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		levelOrder(root);
	}
	
	  public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> orderList = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0 ; i< q.size(); i++){
                
                TreeNode n = q.poll();
                list.add(n.val);
                if(n.left != null){ q.add(n.left);}
                if(n.right != null){ q.add(n.right);}
            }
            orderList.add(list);
        }
        
        return orderList;
    }
}
