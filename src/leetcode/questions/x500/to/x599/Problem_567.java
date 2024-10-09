package leetcode.questions.x500.to.x599;

import java.util.Arrays;

//https://leetcode.com/problems/permutation-in-string/description/
public class Problem_567 {

	public static boolean checkInclusion(String s1, String s2) {
        //create a map of s1
		int[] map = new int[26];
		//map will have occurance of each character in s1
		for(char c: s1.toCharArray()) {
			map[c-'a'] = map[c-'a']+1;
		}
		int len = s1.length();
		
		char[]c = s2.toCharArray();
		
		for(int i=0; i< c.length; i++) {
			// i+len == c.len it means permutation is not available so break
			if (i+len > c.length) break;
			if(map[c[i]-'a'] != 0) {
				//create a substring temp
				char[] temp = s2.substring(i, i+len).toCharArray();
				//create copy of c
				int [] copy = Arrays.copyOf(map, map.length);
				boolean found = true;
				for(char t : temp) {
					if(copy[t-'a'] >0) {
						copy[t-'a']-=1;
					}else {
						found = false;
						break;
					}
				}
				
				if (found) return true;
				
			}
			
		}
		return false;
	}
		
		
}
