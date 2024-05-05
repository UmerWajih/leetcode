package leetcode.questions;

public class Problem_5 {
	//https://leetcode.com/problems/longest-palindromic-substring/description/
	//compare first and last
	//if it doenst match then iterate last one to tone behind, reset start pointer
	// once j > i that is is asubstring save it
	// update start pointer by 1. go again
	
	public static String longestPalindrome(String s) {
        if(s.length() ==1) return s;
        String substring = s.charAt(0)+"", temp=null;
        int i =0 , j = s.length()-1, start =0, startIndex=-1, endIndex=-1, end=0;
        while (i<j || start<s.length()-1) {
        	if(j<=start || j<=i) {
        		start++; i=start; j=s.length()-1; end=0;
        		if(s.charAt(start)=='s') {
        			System.out.println("umer");
        		}
        		if(temp !=null && substring.length() < temp.length()) {
	        		substring=s.substring(startIndex, endIndex+1);
	        	}
        		startIndex=-1; endIndex=-1;
        	}
        	if(s.charAt(i)== s.charAt(j)) {
        		if(startIndex == -1 && endIndex==-1) {
        			startIndex=i; endIndex=j;
        			temp = s.substring(startIndex, endIndex+1);
        		} 
        		i++;j--;
        		if(i>j && temp!=null && substring.length() < temp.length()) {substring=temp;}
        		continue;
        	}
        	i=start;
        	j=s.length()-(1+end++);
        	
        	temp=null;startIndex=-1; endIndex=-1;
        }
        return substring;
    }
	
}
