package leetcode.questions.x300.to.x400;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/odd-even-linked-list/
public class Problem_328 {

	public ListNode oddEvenList(ListNode head) {
		 if (head == null) return null;
		ListNode odd = head, even= head.next, t= head.next;
		while (odd !=null && odd.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next= odd.next;
			even= even.next;
		}
		odd.next= t;
		return head;
    }
	//1,2,3,4,5
}
