package leetcode.question.binaryTree;

public class Leetcode328 {

	  public class ListNode {
	      private int val;
	      private ListNode next;
	      private ListNode(int x) { val = x; }
	
	public ListNode oddEvenList(ListNode head) {
	    if(head == null) return null;
	    ListNode odd = head;
	    ListNode even = head.next;
	    ListNode evenHead = even;
	    while(even != null && even.next != null){
	        odd.next = even.next;
	        odd = odd.next;
	        even.next = odd.next;
	        even = even.next;
	    }
	    odd.next = evenHead;
	    return head;
	    }
	  }
	 }
