package leetcode.questions.x101.to.x200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_127 {
	//https://leetcode.com/problems/word-ladder/
	//create sets on each level to improve performance
	
	private static int recursive (String beginWord, String endWord, List<String> wordList, 
			int minLen, Set<String> set) {
		if(minLen < set.size()) return minLen; //no need to check forward
		
		if(getDiff(beginWord , endWord) ==1) {
			return Math.min(minLen, set.size()+1);
		}
		
		for(int i=0; i<wordList.size(); i++ ) {
			if(set.contains(wordList.get(i))) continue;
			if(getDiff(beginWord , wordList.get(i)) ==1 ) {
				set.add(wordList.get(i));
				minLen = recursive (wordList.get(i),  endWord, wordList, 
						 minLen,set);
				set.remove(wordList.get(i));
			}
		}
		
		return minLen;
	}
	
	private static int getDiff(String a , String b) {
		int len = a.length();
		int diff =0;
		for(int i =0; i< len; i++) {
			if(a.charAt(i)!=b.charAt(i))diff++;
		}
		return diff;
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
		Set <String> set = new HashSet<>();
		set.add(beginWord);
        int min= recursive ( beginWord,  endWord,  wordList, 
    			Integer.MAX_VALUE, set);
       	return min == Integer.MAX_VALUE ? 0 : min;
    }
}
