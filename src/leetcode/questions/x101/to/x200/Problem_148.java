package leetcode.questions.x101.to.x200;

import leetcode.questions.Common.ListNode;

public class Problem_148 {
	//https://leetcode.com/problems/sort-list
	
	//Approach 1:
	// Create a recursive function
	// sort on each iteration
	// you will have 3 parameters: currentNode, startNode, count of nodes sorted
	// place current node where you find the right spot
	// worst case scenario you will be going through the same list multiple times
	// this is selection or insertion sort dont remember
	
	//Approach 2:
	// Use Merge Sort
	// use 2 pointers
	// one is fast, one is slow
	// find mid point and sort first and middle
	// then move up now sort 4 nodes
	// then sort eight nodes .......

	//4,2,1,3
	private static ListNode recursive(ListNode head) {
		if(head == null || head.next == null) {return head;}
		
		ListNode slow = head; 
		ListNode fast = head; 
		ListNode temp = null;
		//here slow will become
		while (fast !=null && fast.next !=null) {
			temp = slow; //2
			slow = slow.next;  //1
			fast = fast.next.next; //null
		}
		//temp next will be null to break it into 2
		//4,2
		//1,3
		temp.next=null;
		
		
		ListNode left = recursive(head);
		ListNode right = recursive(slow); 
		return merge(left, right);
	}
	
	//
	private static ListNode merge(ListNode left, ListNode right) {
		if(right == null && left == null) return null;
		if(right == null) return left;
		if(left == null) return right;
		ListNode startingNode=new ListNode(0);
		ListNode node = startingNode;
		
		while (left !=null || right !=null) {
			if(left == null ) {
				node.next=right;
				break;
			}
			if(right == null ) {
				node.next=left;
				break;
			}
			if(right.val > left.val) {
				node.next=left;
				left = left.next;
				
			}else {
				node.next=right;
				right = right.next;
			}
			node = node.next;
		}
		
		return startingNode.next;
				
	}
	
	public static ListNode sortList(ListNode head) {
		if(head == null) return null;
		if(head.next ==null) return head;
        return recursive(head);
    }
}
