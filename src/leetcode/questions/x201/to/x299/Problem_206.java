package leetcode.questions.x201.to.x299;

import leetcode.questions.Common.ListNode;

public class Problem_206 {
	//https://leetcode.com/problems/reverse-linked-list\
	// head = [1,2,3,4,5]
	public static ListNode reverseList(ListNode head) {
		if(head == null ) return null;
		if(head.next == null ) return head;
		ListNode  prev =null, temp=null;
		while(head !=null) {
			if(prev == null) {
				 prev = head; //1
				 head = head.next;
				 prev.next=null;
				 continue;
			}
			temp = head.next;
			head.next = prev; //2,1
			prev = head; //2,1
			head = temp;
		}
		return prev;
    }
}
