package leetcode.question.binaryTree;
//copy List with random pointer
public class Leetcode138 {

	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};
	
	 public Node copyRandomList(Node head) {
	        Node next = head;
	        Node iter = head;
	        while(iter != null){
	            next = iter.next;
	            iter.next = new Node(iter.val,null,null);
	            iter.next.next = next;
	            iter = next;
	        }
	        
	        iter = head;
	        while(iter != null){
	            if(iter.random != null)
	                iter.next.random = iter.random.next;
	            iter = iter.next.next;
	        }
	        
	        //extract a link list need three pointer
	        //1. point to the copyhead
	        //2. point to the copyiter
	        //3. point to the original 
	        Node copylist = new Node(0,null,null);
	        Node copyiter = copylist;
	        iter = head;
	        //generate the link from copy
	        //cut the original and copy
	        //move to the next
	        while(iter != null){
	            copyiter.next = iter.next;
	            copyiter = copyiter.next;
	            iter.next = copyiter.next;
	            iter = copyiter.next;
	        }
	        return copylist.next;
	    }   
	
}
