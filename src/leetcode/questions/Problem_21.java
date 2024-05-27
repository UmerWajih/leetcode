package leetcode.questions;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class Problem_21 {
	//1,2,4
	//1,3,4
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode node =null, returnNode =null;
		if(list1==null) return list2;
		if(list2==null) return list1;
		
		while(list1 != null || list2 != null) {
			if(list1!=null && (list2 ==null || list1.val < list2.val)) {
				if(node==null) {
					if(returnNode == null) returnNode=node;
					node=new ListNode(list1.val);
				}
				else {
					node.next= new ListNode(list1.val);
					if(returnNode == null) returnNode=node;
					node = node.next;
				}
				
				
				list1 = list1.next;
			}else {
				if(node==null) {
					if(returnNode == null) returnNode=node;
					node= new ListNode(list2.val);
				}
				else {
					node.next= new ListNode(list2.val);
					if(returnNode == null) returnNode=node;
					node = node.next;
				}
				list2 = list2.next;
			}
		}
		return returnNode;
    }
	
	//Recursive
	public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if(list1==null && list2!=null) return list2;
		 if(list1!=null && list2==null) return list1;
		 if(list1==null && list2==null) return null;
		 
		 if(list1.val < list2.val) {
			 list1.next=mergeTwoLists(list1.next,  list2);
			 return list1;
		 }else {
			 list2.next= mergeTwoLists(list1,  list2.next);
			 return list2;
		 }
    }
}
