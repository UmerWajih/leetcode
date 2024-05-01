package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Execution {

	public static void main(String[] args) {
		//Question 2
		ListNode l1 = new ListNode(9 , 
				new ListNode(9, 
				new ListNode(9,
						new ListNode(9 , 
								new ListNode(9, 
						new ListNode(9,
								new ListNode(9,
										null)))))));
		ListNode l2 = new ListNode(9 , 
				new ListNode(9, 
						new ListNode(9,
								new ListNode(9,null))));
		
		Problem_2.addTwoNumbersRecursion(l1, l2);
	}

}
