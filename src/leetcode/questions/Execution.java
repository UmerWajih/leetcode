package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Execution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1 ,  new ListNode(2, null ) );
	
		
		ListNode list = Problem_25.reverseKGroup(l1,2);
		System.out.println(list.val);
	}

}
