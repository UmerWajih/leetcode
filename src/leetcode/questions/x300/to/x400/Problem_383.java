package leetcode.questions.x300.to.x400;

import java.util.HashMap;
import java.util.Map;

public class Problem_383 {

	//https://leetcode.com/problems/ransom-note
	
	//store count of each character in magzine
	public boolean canConstruct(String ransomNote, String magazine) {
    
		Map<Character, Integer> count = new HashMap<>();
		// map stores count of each character in magazine
		for(int i=0; i< magazine.length(); i++) {
			count.put(magazine.charAt(i), count.getOrDefault(magazine.charAt(i), 0)+1);
		}
		for(int i=0; i< ransomNote.length(); i++) {
			//character not present in magazine
			if(!count.containsKey(ransomNote.charAt(i))) return false;
			//more occurances in ransom note than in magazine
			if(count.get(ransomNote.charAt(i))-1 < 0) return false;
			
			
			// reduce occurances
			count.put(ransomNote.charAt(i),count.get(ransomNote.charAt(i))-1);
		}
		
		
		return true;
    }
}
