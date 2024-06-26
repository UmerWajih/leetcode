package leetcode.questions.x201.to.x299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem_205 {

	//https://leetcode.com/problems/isomorphic-strings
	
	// add character to map e => a
	// a is now used to a will be added to set
	// if character e is in map && t value == map .value then fine
	// if map doesnt contain e and set has t value then false
	public static boolean isIsomorphic(String s, String t) {
		Set<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
       
        
        //You can use array for faster approach
//        int [] arr = new int[26];
//        int [][] comb = new int[26][2];
        
        for (int i=0; i< s.length() ; i++) {
        	
			/*
			 * if(comb[s.charAt(i)-'a'][0] == s.charAt(i) && comb[s.charAt(i)-'a'][1] !=
			 * t.charAt(i)) return false; if(comb[s.charAt(i)-'a'][0] != s.charAt(i) &&
			 * arr[t.charAt(i)-'a'] != 1) return false; arr[t.charAt(i)-'a'] = 1;
			 * comb[s.charAt(i)-'a'][0]=s.charAt(i); comb[s.charAt(i)-'a'][1]=t.charAt(i);
			 */
        	
        	
        	if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) return false;
        	if(!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i))) return false;
        	set.add(t.charAt(i));
        	map.put(s.charAt(i), t.charAt(i));
        }
        
        return true;
    }
}
