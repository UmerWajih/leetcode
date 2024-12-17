package leetcode.questions.x2600.to.x2699;

import leetcode.questions.Common.ListNode;

public class Problem_2674 {

	public ListNode[] splitCircularLinkedList(ListNode list) {
		ListNode slow = list, fast = list, t = list, tS = list;
		boolean start = true;
		while (start || (fast != list && fast.next != list)) {
			tS = slow;
			slow = slow.next; // 1
			t = fast.next; // 6
			fast = fast.next.next; // 1

			start = false;
		}
		// break the cycle
		ListNode a = null;
		if (fast.next != list) {
			fast = t;
			slow = tS;
		}
		fast.next = slow.next;
		a = slow.next;

		slow.next = list;
		ListNode[] l = new ListNode[2];

		l[1] = a;
		l[0] = list;
		return l;
	}
}
