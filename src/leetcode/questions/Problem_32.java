package leetcode.questions;

import java.util.Stack;

public class Problem_32 {

	//https://leetcode.com/problems/longest-valid-parentheses/
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int longestValue=0;
		
		//doing this so longest value adds 1 to i
		stack.push(-1);
		for(int i=0; i<s.length();i++) {
			// if stacks top is ( and not -1 then pop
			// stack .size needs to first or second param due to chance of peek being -1
			if(stack.size()>1 && s.charAt(i) == ')' && s.charAt(stack.peek())== '(' ) {
				stack.pop();
				
				longestValue = Math.max(longestValue, i - stack.peek());
			}else {
				//just add 
				//invalid ) will increment the index in stack which will help with calculation
				stack.push(i);
			}
		
		}
		return longestValue;
    }
}
