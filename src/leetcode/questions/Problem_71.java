package leetcode.questions;

import java.util.Stack;

public class Problem_71 {

	//https://leetcode.com/problems/simplify-path
	//in case of . and '' do nothing
	// in case of .. pop another element
	// /home/user/Documents/../Pictures
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for(String s : path.split("/")) {
			if(s.equals("") || s.equals(".")) continue;
			if(s.equals("..")) {
				if(stack.isEmpty()) continue;
				stack.pop(); 
				continue;
			}
			stack.add(s);
		}
		String output="";
		for(String s : stack) {
			output=output+"/"+s;
		}
		return output.equals("") ? "/" : output;
        
    }
}
