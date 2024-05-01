package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Problem_2 {

	//https://leetcode.com/problems/add-two-numbers/description/
	
	//without recursion
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode retNode = null, node = new ListNode();

		while (l1 != null || l2 != null || carry != 0) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

			if (sum > 9) {
				node.val = sum % 10;
				carry = 1;
			} else {
				node.val = sum;
				carry = 0;
			}
			if (retNode == null) {
				retNode = node;
			}
			if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || (carry != 0)) {
				node.next = new ListNode();
				node = node.next;
			}
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		return retNode;
	}
	
	// with recursion
	public static ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2) {
		ListNode node = new ListNode();
		recursiveFunction(l1, l2, 0, node);
		return node;
	}

	public static void recursiveFunction(ListNode l1, ListNode l2, int carry, ListNode node) {
		int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
		if (sum > 9) {
			node.val = sum % 10;
			carry = 1;
		} else {
			node.val = sum;
			carry = 0;
		}
		if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || (carry != 0)) {
			node.next = new ListNode();
			recursiveFunction(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry, node.next);
		}

	}
}
