package leetcode.questions.x201.to.x299;

import java.util.Stack;

import leetcode.questions.Common.ListNode;

public class Problem_234 {
	//https://leetcode.com/problems/palindrome-linked-list/
	//find the middle node/
	//store value of node in stack
	
	
	public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast=head;
        //1,2,2,1
		while(fast !=null) {
			stack.push(slow.val); //1
			slow=slow.next; //2
			if(fast.next!=null && fast.next.next==null) break; //even nodes
			if(fast.next == null) {
				stack.pop(); //odd nodes
				break;
			}
			fast=fast.next.next; //2
			
			//check needed for fast.next -> odd/even nodes
		}
		
		//slow is now at the middle
		
		while(slow!=null) {
			if(slow.val != stack.pop()) return false;
			slow=slow.next;
		}
		return true;
    }
}
