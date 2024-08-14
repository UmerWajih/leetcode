package leetcode.questions.x1200.to.x1299;

import java.util.Stack;

public class Problem_1249 {
	//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
	
	//create a stack
	//for every ) pop out (
	//if ( is not presetnt mark ) as empty
	//in the end all left over ( are marked as empty
	
	public static String minRemoveToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		StringBuilder builder = new StringBuilder();
		
		char[] arr =s.toCharArray();
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==')') {
				if(stack.isEmpty()) {
					continue;
				}else {
					stack.pop();
					index.pop();
				}
			} 
			if(arr[i]=='(') {
				stack.add('(');
				index.add(builder.length());
			}
			builder.append(arr[i]);
		}
		while(!index.isEmpty()) {
			builder.deleteCharAt(index.pop());
		}
		return builder.toString();
    }
}
