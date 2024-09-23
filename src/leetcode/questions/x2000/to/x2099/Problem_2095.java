package leetcode.questions.x2000.to.x2099;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class Problem_2095 {
	//use fast and slow pointer
	public ListNode deleteMiddle(ListNode head) {
		if(head.next == null) return null;
		
	
		ListNode slow= head, fast=head.next, prev=head;
		while(fast!=null) {
			prev=slow; //2
			slow=slow.next;  //3
			if(fast.next==null) break;
			fast=fast.next.next;  //4
		}
		prev.next= slow.next;
		return head;
		
    }
}
