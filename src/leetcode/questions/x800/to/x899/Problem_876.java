package leetcode.questions.x800.to.x899;

import leetcode.questions.Common.ListNode;

public class Problem_876 {
	
	//https://leetcode.com/problems/middle-of-the-linked-list/
	public ListNode middleNode(ListNode head) {
		//1,2,3,4,5,6
        if(head.next == null) return head;
        if(head.next.next == null) return head.next;
        ListNode slow = head.next; //2
        ListNode fast = head.next.next; //3
        boolean isEven=false;
        while(fast !=null) {
        	head = slow; //2
        	slow = slow.next; //3
        	if(fast.next !=null && fast.next.next ==null)isEven=true;
        	fast = fast.next !=null && fast.next.next !=null ? fast = fast.next.next : null; //5
        	
        }
        return isEven ? head.next : head;
    }
}
