package leetcode.question.binaryTree;

import java.util.HashSet;
import java.util.Set;

public class Leetcode817 {

	 public class ListNode {
		 private int val;
		 private ListNode next;
		 private ListNode(int x) { val = x; }
		 }
	 
	 public int numComponents(ListNode head, int[] G) {
		 Set<Integer> setG = new HashSet<>();
		 for(int i : G) setG.add(i);
			 int count = 0;
			 while(head != null) {
				 if(setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) count++;
				 head = head.next;
			 }
			 return count;
		 }
	 }

