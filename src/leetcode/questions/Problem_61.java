package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Problem_61 {
	//https://leetcode.com/problems/rotate-list
	public ListNode rotateRight(ListNode head, int k) {
		 if(head == null)return null;
	        if(k==0) return head;
	        ListNode fast = head;
			for (int i=0; i<k ;i++) {
	            if(fast.next==null)fast=head;
				else fast=fast.next;
			}
			//now fast will beat k position
	       
			ListNode slow = head; 
			while(fast.next!=null) {
				slow=slow.next;
				fast=fast.next;
			}
	        if(slow.next == null) return head;
	        ListNode old =slow.next;
			slow.next=null;
			fast.next=head;
			return old;
	}
}
