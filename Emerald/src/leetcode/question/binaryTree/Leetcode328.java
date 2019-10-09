package leetcode.question.binaryTree;

//odd even linked list
public class Leetcode328 {

	  public class ListNode {
	      private int val;
	      private ListNode next;
	      private ListNode(int x) { val = x; }
	
	public ListNode oddEvenList(ListNode head) {
	    if(head == null) return null;
	    ListNode odd = head;
	    ListNode even = head.next;
	    //a extra pointer to mark the head of the even linked list.
	    ListNode evenHead = even;
	    while(even != null && even.next != null){
	    		//iter through the odd nodes
	        odd.next = even.next;
	        odd = odd.next;
	        //iter through the even nodes
	        even.next = odd.next;
	        even = even.next;
	    }
	    odd.next = evenHead;
	    return head;
	    }
	  }
	 }
