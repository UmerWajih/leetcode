package leetcode.questions.x201.to.x299;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Problem_237 {

	public void deleteNode(ListNode node) {
		while(node.next!=null) {
			node.val= node.next.val;
			ListNode prev = node;
			node= node.next;
			if(node.next ==null) {
				prev.next=null;
				break;
			}
		}
		
    }
}
