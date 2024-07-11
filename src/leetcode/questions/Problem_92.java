package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Problem_92 {
	//https://leetcode.com/problems/reverse-linked-list-ii
	
	//2,3,4
	//if prev is null
	//remove 2.next
	//2.next, 2
	//3.next= 2
	//keep doing this till we reach right
	
	
	private static ListNode recursive(ListNode current, ListNode prev, ListNode start,int right, int count) {
		if(count == right+1) {
			if(current!=null)start.next=current;
			return prev;
		}
		ListNode node=  current.next;
		if(prev == null) {
			current.next=null;
			start=current;
		}else {
			current.next = prev;
		}
		return recursive( node,  current, start, right,  count+1);
	}
	
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		//if(right == 1) return head;
        ListNode leftNode = head, leftPrev=head, temp = head;
		int i=1;
		while(i<left) {
			leftPrev=leftNode;
			leftNode= temp.next;
			temp = temp.next;
			i++;
		}
		if(i==1) {
			//whole list is being reversed here
			return recursive( leftNode,null, null,right, left);
		}
		leftPrev.next= recursive( leftNode,null, null,right, left);
		return head;
    }
	
	


}
