package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_76 {
	
	//https://leetcode.com/problems/minimum-window-substring
	public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
		
		//keeps track of all of the characters and their count, how many time we will be looking for character
		Map<Character, Integer> count = new HashMap<>();
		for(int i=0; i<t.length() ;i++) {
			count.put(t.charAt(i), count.containsKey(s.charAt(i))? count.get(s.charAt(i))+1 :1);
		}
		int minimumLen = Integer.MAX_VALUE;
		String minumimSubstring = "";
		int startingPoint = -1;
		Map<Character, Integer> store = new HashMap<>();
		outerloop: for(int i=0; i< s.length() ;i++) {
			if(count.containsKey(s.charAt(i))) {
				store.put(s.charAt(i), store.containsKey(s.charAt(i))? store.get(s.charAt(i))+1 :1);
				
				if(startingPoint == -1) startingPoint = i;
				
				for(Character c : count.keySet()) {
					if(!store.containsKey(c) || store.get(c) < count.get(c)) continue outerloop;
				}
				if(i+1-startingPoint < minimumLen) {
					if(i+1 < s.length())minumimSubstring = s.substring(startingPoint ,  i+1);
					else minumimSubstring = s.substring(startingPoint );
					
					minimumLen=i+1-startingPoint;
				}
				//now we need to keep moving forward till we have a new starting point
				int increment =1;
				while(startingPoint+increment < s.length() && !count.containsKey(s.charAt(startingPoint+increment))) {
					increment++;
				}
				store.put(s.charAt(startingPoint), store.get(s.charAt(startingPoint))-1);
				store.put(s.charAt(i), store.get(s.charAt(i))-1);
				i--;
				startingPoint+=increment;
				
				
			}
			
		}
		return minumimSubstring;
    }
}
