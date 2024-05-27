package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Execution {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		System.out.println(Problem_21.mergeTwoLists(list1,list2
		));
	}

}
