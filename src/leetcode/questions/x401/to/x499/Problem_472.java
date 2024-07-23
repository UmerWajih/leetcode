package leetcode.questions.x401.to.x499;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_472 {
//https://leetcode.com/problems/concatenated-words/
	
	//words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
	//taks index i
	//if len > continue
	//if word is same then continue
	//if we get a substring call word break again, if we get true then add the word to the list
	
	//
	private static void recursive(String[] words, int index, boolean isSubstring, Set<String> list, String str) {
		if(index == words.length) return ;
		
		for(String word : words) {
			if(word.equals("t"))System.out.println(0);
			if(word.length() > str.length())continue;
			if(word.equals(str)) {
				if (!isSubstring)continue;
				else {
					list.add(words[index]);
					return;
				}
			}
			if(str.substring(0,word.length()).equals(word)) {
				recursive(words,  index, true,  list,str.substring(word.length())) ;
			}
			
		}
		
		if(isSubstring) {
			return;
		}
		recursive(words, index+1, false, list, index+1 == words.length ? null: words[index+1]);
	}
		
	
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String>list = new HashSet<String>();
        recursive(words, 0, false, list, words[0] );
        return new ArrayList<>(list);
    }
}
