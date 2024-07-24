package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Problem_22 {

	//https://leetcode.com/problems/generate-parentheses/
	private static void recursive(int n, List<String> res, int left,int right, String str) {
		if(left+right == n*2) {
			res.add(str);
			System.out.println(str);
		}
		if(left < n) {
			recursive( n, res, left+1, right, str+"(");
		}
		if(right < left) {
			recursive( n, res, left, right+1, str+")");
		}
		
	}
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recursive(n, res, 0, 0, "");
        return res;
    }
	
}
