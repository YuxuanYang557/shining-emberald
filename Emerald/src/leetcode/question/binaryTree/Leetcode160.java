package leetcode.question.binaryTree;

import leetcode.question.binaryTree.Leetcode142.ListNode;

public class Leetcode160 {
	
	//still two methods for the question
	//the one is go through one of the list and put the node in a Set, loop through second to see whether return false 
	//the second one, is below one, more efficient

	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	      val = x;
	      next = null;
	      }
	  }
	 
	 public ListNode getIntersectNode(ListNode headA, ListNode headB) {
		 if(headA == null || headB == null) return null;
		 
		 ListNode a = headA;
		 ListNode b = headB;
		 
		//if a & b have different len, then we will stop the loop after second iteration
		 while(a != b) {
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			 a = a == null? headB : a.next;
			 b = b == null? headA : b.next;
		 }
		 
		 return a;
	 }
}
