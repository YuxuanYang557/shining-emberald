package leetcode.question.binaryTree;

import java.util.HashSet;
import java.util.Set;

//Linked list component
public class Leetcode817 {

	 public class ListNode {
		 private int val;
		 private ListNode next;
		 private ListNode(int x) { val = x; }
		 }
	 
	 public int numComponents(ListNode head, int[] G) {
		 //put all the numbers value into the set
		 Set<Integer> setG = new HashSet<>();
		 for(int i : G) setG.add(i);
			 int count = 0;
			 while(head != null) {
				 //two node(current and previous one) 
				 //if current one in the set and the previous is not, mean they are not connected, count++
				 if(setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) count++;
				 head = head.next;
			 }
			 return count;
		 }
	 }

