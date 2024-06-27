package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_30 {
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> output = new ArrayList<Integer>();
		
		//we'll now have count of every word
		Map<String, Integer> wordCount = new HashMap<>();
		int totalWords=0;
		for(int i=0; i< words.length ; i++) {
			wordCount.put(words[i], wordCount.getOrDefault(words[i], 0)+1);
			totalWords++;
		}
		
		int wordSize = words[0].length();
		
		int i=0, startingPoint=0;
		
		int wordsFound=0;
		Map<String, Integer> copy = new HashMap<>();
		while(i<s.length()) {
			
			
			if(wordCount.containsKey(s.substring(i, i+wordSize))) {
				copy.put(s.substring(i, i+wordSize), copy.getOrDefault(s.substring(i, i+wordSize),0)+1);
				wordsFound++;
			}
			//create a window to keep track of words
			//in case of words exceeding, push starting words forward till the count is no longer exceeding
			if(!wordCount.containsKey(s.substring(i, i+wordSize)) || copy.get(s.substring(i, i+wordSize)) > wordCount.get(s.substring(i, i+wordSize))) {
				copy.clear();
				startingPoint+=wordSize;
				i=startingPoint;
				wordsFound=0;
				continue;
			}
			i+=wordSize;
			//incase of match just remove the first word move forward rather than going all the way back
			//incase of mismatch then reset the counter
			if(wordsFound==totalWords) {
				output.add(startingPoint);
				copy.clear();
				startingPoint+=wordSize;
				i=startingPoint;
				wordsFound=0;
			}
			
		}
		
		
		return output;
    }

	
	
	
}
