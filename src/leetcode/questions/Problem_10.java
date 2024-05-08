package leetcode.questions;

public class Problem_10 {
	//https://leetcode.com/problems/regular-expression-matching/description/
	public static boolean  isMatch(String s, String p) {
        return recurcise( s,  p, 0, 0) ;
    }

	public static boolean recurcise(String s, String p, int i, int j) {
		if(i >= s.length() && j >= p.length()) {
			return true;
		}
		if(j>= p.length()) return false;
		
		boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
		
		if (j+1 < p.length() && p.charAt(j+1) == '*') {
			return (match && recurcise( s, p, i+1, j)) || recurcise( s, p, i, j+2);
		}
		if(match) return recurcise( s, p, i+1, j+1);
		
		return false;
		
	}
	
	
	
}
