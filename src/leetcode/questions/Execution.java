package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Execution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1 ,  new ListNode(4, new ListNode(5,null) ) );
		ListNode l2 = new ListNode(1 ,  new ListNode(3, new ListNode(4,null) ) );
		ListNode l3 = new ListNode(2 ,  new ListNode(6, null ) );
		
		ListNode list = Problem_23.mergeKLists(new ListNode [] {l1,l2,l3});
		System.out.println(list.val);
	}

}
