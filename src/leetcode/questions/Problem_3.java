package leetcode.questions;

public class Problem_3 {

	//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
	
	//without recursion
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
		int i=0;
		String substring = "", maxSubstring="";
		while(i < s.length()) {
			if(!substring.contains(Character.toString(s.charAt(i)))) {
	        	substring+=Character.toString(s.charAt(i));
	        }else {
	        	if(substring.length() > maxSubstring.length()) {
	            	maxSubstring = substring;
	            	substring = "";
	            	i = i - (maxSubstring.length()-1);
	            	continue;
	            }else {
	            	i = i - (substring.length()-1);
	            	substring = "";
	            	continue;
	            }
	        	
	        } 
			i++;
		}
		return (substring.length() > maxSubstring.length() )? substring.length() : maxSubstring.length();
    }
	
	
	//Recursion: Test Case 986 will cause stack overflow error so cant use this
	public static int lengthOfLongestSubstringRec(String s) {
		if(s.length() == 0) return 0;
		return recursiveFunction(s, "","",  0);
    }
	public static int recursiveFunction(String s, String substring,String maxSubstring,  int index) {
        if(index == s.length()) {
        	return (substring.length() > maxSubstring.length() )? substring.length() : maxSubstring.length();
        } 
        
		if(!substring.contains(Character.toString(s.charAt(index)))) {
        	substring+=Character.toString(s.charAt(index));
        }else {
        	if(substring.length() > maxSubstring.length()) {
            	maxSubstring = substring;
            	return recursiveFunction (s,"",maxSubstring,index - (maxSubstring.length()));
            }else {
            	return recursiveFunction (s,"",maxSubstring,index - (substring.length()-1));
            }
        	
        } 

    	return recursiveFunction (s,substring,maxSubstring,index+1);
    }
	
}
