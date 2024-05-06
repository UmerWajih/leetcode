package leetcode.questions;

public class Problem_9 {
	//https://leetcode.com/problems/palindrome-number/description/
	
	// if x is less than 0 no need to check, it false
	// convert to charArray
	//open 2 pointer from either end
	//if a character miss matches break
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
        char [] a = (x+"").toCharArray();
        int i=0, j=a.length-1;
        while (i < j) {
        	if(a[i] != a[j]) {
        		return false;
        	}
        	i++;j--;
        }
        return true;
    }

}
