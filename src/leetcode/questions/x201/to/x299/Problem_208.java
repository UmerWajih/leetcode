package leetcode.questions.x201.to.x299;

import java.util.HashSet;
import java.util.Set;

public class Problem_208 {
	//https://leetcode.com/problems/implement-trie-prefix-tree
	class Trie {

	    Set<String> set;
	    public Trie() {
	        set = new HashSet<>();
	    }
	    
	    public void insert(String word) {
	        set.add(word);
	    }
	    
	    public boolean search(String word) {
	        if(set.contains(word)) return true;
	        else return false;
	    }
	    
	    public boolean startsWith(String prefix) {
	        for(String str: set){
	            if(str.startsWith(prefix)) return true;
	        }
	        return false;
	    }
	}
}
