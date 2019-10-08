package leetcode.question.binaryTree;

public class Leetcode142 {
	
	 class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	//use slow and fast pointer to detect a cycle
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				//when the fast point meet the slow pointer, start a new pointer at head
				ListNode s2 = head;
				while(slow != s2) {
					s2 = s2.next;
					slow = slow.next;
				}
				//when the two slow pointer meet, that point will be the entrence of the cycle
				return slow;
			}
		}
		return null;
	}
}
