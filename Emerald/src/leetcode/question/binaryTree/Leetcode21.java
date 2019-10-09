package leetcode.question.binaryTree;

//merge two sorted list
public class Leetcode21 {
	public class ListNode {
			     private int val;
			     private ListNode next;
			     private ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	
		  if(l1 == null) return l2;
		  if(l2 == null) return l1;
		  if(l1.val < l2.val) {
			  l1.next = mergeTwoLists(l1.next, l2);
			  return l1;
		  }
		  else{
			  l2.next = mergeTwoLists(l1, l2.next);
			  return l2;
		  }
	}
}
