package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Problem_25 {

	//https://leetcode.com/problems/reverse-nodes-in-k-group/
	public static ListNode reverseKGroup(ListNode head, int k) {
        return recursive(head , k);
    }
	
	//if k * .next !=null reverse values
	private static ListNode recursive(ListNode head , int k) {
		ListNode test = head;
		int i=0;
		
		// check if it goes out of bounds
		// if yes we will not reverse the nodes
		// if no nodes need reversing
		while (i < k) {
			if(test == null ) break;
			test = test.next;
			i++;
		}
		
		if(test !=null ) {
			//assign list as next if reversed list
			i=0;
			ListNode current = head, previous = recursive(test , k), next =null;
			// we need to reverse the nodes
			//1,2,3
			
			// next= current.next  = 2
			// current.next  = previous = list recvd
			// previous = current = 1
			// current = next = 2
			while (i < k) {
				next = current.next; //
				current.next = previous; //
				previous = current; // 
				current = next; //
				i++;
			}
			
			return previous;
			
		}else {return head;}
	}
}
