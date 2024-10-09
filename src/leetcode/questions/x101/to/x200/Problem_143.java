package leetcode.questions.x101.to.x200;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/reorder-list/description/
public class Problem_143 {

	public static void reorderList(ListNode head) {
		//what we can do is create 2 lists
		//create 2 pointers
		//go to half length of the list
		//reverse the second half
		//add the second half one by one
		
		ListNode slow=head, fast=head, x = slow;
		while(fast !=null && fast.next !=null) {
			x = slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		//here slow will be middle point
		ListNode old= fast == null ? x : slow;
		fast=fast == null ? slow : slow.next;
		
		old.next=null;
		//reverse the list
		
		//3,4,5
		while(fast != null) {
			ListNode t=fast;
			fast=fast.next;
			t.next=old;
			old=t;
		}
		ListNode start=head;
		while(old !=null && start!=null) {
			ListNode temp = start.next;
			start.next=old;
			//set backwards value
			old = old.next;
			start.next.next=temp;
			start=temp;
		}
    }
}
