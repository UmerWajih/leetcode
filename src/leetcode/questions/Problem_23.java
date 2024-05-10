package leetcode.questions;

import leetcode.questions.Common.ListNode;

public class Problem_23 {

	//https://leetcode.com/problems/merge-k-sorted-lists/description/
	public static ListNode mergeKLists(ListNode[] lists) {
		return mergeByDividingList(lists, 0, lists.length-1);
    }
	
	//apple merge sort
	private static ListNode mergeByDividingList(ListNode[] lists, int start, int end) {
		
		//when only one list in the array just return that
		if(start == end) {return lists[start];}
		
		//if is start and end are at difference of 1 merge them
		if(start + 1 == end) {
			return merge(lists[start], lists[end]);
		}
		
		// separate lists by mid value
		int mid = start + (end - start) / 2;
		ListNode left=null, right=null;
		if(mid != start && mid != end) {
			left = mergeByDividingList( lists, start, mid);
			right = mergeByDividingList( lists, mid+1, end);
		}
		
		
		//once we have 2 lists merge them
		return merge(left, right);
	}
	
	
	//merge two lists
	private static ListNode merge(ListNode node1, ListNode node2) {
		
		if(node1 == null) return node2;
		if(node2 == null) return node1;
		
		ListNode returnNode = null, node =null;
		while (node1 !=null && node2 !=null) {
			if(node1.val < node2.val) {
				if(returnNode == null) {
					returnNode = new ListNode(node1.val);
					node = returnNode;
				}else {
					node.next=new ListNode(node1.val);
					node = node.next;
				}
				node1 = node1.next;
			}else {
				if(returnNode == null) {
					returnNode = new ListNode(node2.val);
					node = returnNode;
				}else {
					node.next=new ListNode(node2.val);
					node = node.next;
				}
				node2 = node2.next;
			}
			if(node1==null) { node.next = node2; break;}
			if(node2==null) { node.next = node1; break;}
		}
		return returnNode;
	}
	
}
