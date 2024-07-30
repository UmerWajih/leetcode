package leetcode.questions.x201.to.x299;

import java.util.HashMap;
import java.util.Map;

public class Problem_242 {
	//https://leetcode.com/problems/valid-anagram
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return  false;
        Map<Character, Integer>map = new HashMap<>();

        char[]arr= s.toCharArray();
        for(char c: arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        arr= t.toCharArray();
        for(char c: arr){
            if(!map.containsKey(c))return false;
            map.put(c,map.get(c)-1);
            if(map.get(c) == 0)map.remove(c);
        }

        return map.isEmpty();

    }
}
