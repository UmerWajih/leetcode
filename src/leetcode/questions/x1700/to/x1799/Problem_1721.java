package leetcode.questions.x1700.to.x1799;

import leetcode.questions.Common.ListNode;

public class Problem_1721 {

	//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
	public ListNode swapNodes(ListNode head, int k) {
        ListNode fast =head;
        for (int i=0; i< k-1; i++){
            fast = fast.next;
        }
        ListNode node1 = fast;
        System.out.println(node1.val);
        ListNode slow = head;
        while(fast.next !=null){
            fast= fast.next;
            slow = slow.next;
        }
        
        System.out.println(slow.val);
        int t = slow.val;
        slow.val= node1.val;
        node1.val=t;
        return head;
    }
}
