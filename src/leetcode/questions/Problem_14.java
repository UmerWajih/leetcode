package leetcode.questions;

public class Problem_14 {

	// https://leetcode.com/problems/longest-common-prefix/description/
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)return strs[0];
		if (strs[0].length() == 0)return strs[0];
		return recurcsive(strs, 0, 0, "", strs[0].charAt(0));
	}
	
	//iterate over indexes
	// if index = size append to string
	// if character index > string size retrun
	// if character doesnt match return
	
	//["flower","flow","flight"]
	private static String recurcsive(String[] strs, int arrayIndex, 
			int prefixIndex, String prefix, char c) {
	       
		if(arrayIndex == strs.length) {
			if(prefixIndex+1 >= strs[0].length()) return prefix+=strs[0].charAt(prefixIndex);
			
			return recurcsive(strs, 0, 
					 prefixIndex+1,  prefix+=strs[0].charAt(prefixIndex), 
					 strs[0].charAt(prefixIndex+1) );
		}
		if(prefixIndex >= strs[arrayIndex].length()) {
			return prefix;
		}
		if(strs[arrayIndex].charAt(prefixIndex) != c) {
			return prefix;
		}
		
		return recurcsive(strs, arrayIndex+1, 
				 prefixIndex,  prefix, c );
    }
}
