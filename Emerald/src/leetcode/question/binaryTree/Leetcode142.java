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

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				ListNode s2 = head;
				while(slow != s2) {
					s2 = s2.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
