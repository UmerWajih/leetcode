package leetcode.questions.x1400.to.x1499;

import leetcode.questions.Common.ListNode;

public class Problem_1474 {

	//https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
	public static ListNode deleteNodes(ListNode head, int m, int n) {
        //we need a need to m -> in front. mar m'th node next as null
		
		int i=0,j=0;
		ListNode node = head, prev =node;
		while(node.next !=null) {
			while(i<m) {
				prev=node;
				if(node.next==null) {
					prev.next=null;
					break;
				} 
				node=node.next;
				i++;
			}
			
			
			
			while(j<n) {
				if(node.next ==null) {
					prev.next=null;
					break;
				}
				node=node.next;
				j++;
			}
			if(m==i && j==n)prev.next=node;
			i=0; j=0;
		}
				
		return head;
    }
}
