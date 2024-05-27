package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-break-ii/
public class Problem_140 {
	
    public static List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> list = new ArrayList<>();
    	recursive (s, wordDict,  list, new String());
    	return list;
    }
    
    
    public static void recursive (String s, List<String> wordDict, List<String> list, String str) {
    	
    	if(s.length()==0) {
    		list.add(str.substring(0, str.length() - 1));
    		return;
    	}
    	
    	for (int i=0; i< wordDict.size(); i++) {
    		if(wordDict.get(i).charAt(0) == s.charAt(0)) { //s matches
    			boolean matches=true;
    			for(int j=0; j<wordDict.get(i).length() ; j++) {
    				if(wordDict.get(i).length() > s.length() || wordDict.get(i).charAt(j) != s.charAt(j)) {
    					matches=false;break;
    				} //sand matches
    			}
    			if(matches) {
    				recursive (s.substring(wordDict.get(i).length()), wordDict,  list, str+ wordDict.get(i)+" "); 
    			}
    		}
    	}
    }
}
