package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_139 {

	//https://leetcode.com/problems/word-break
	//First: Store all possible matches from index 0
	//then run a match from each occurance
	//if any one completes it return true
	//if first one fails try second onve
	//if all fail then return false
	
	//since we are having time exceeding issue
	//keep a map: if index returns a false from all possible checks store false for it
	private static boolean recursive(String s, List<String> list, int index, Map<Integer, Boolean> map) {
		if (index == s.length()) return true;
		if(map.containsKey(index) ) return false;
		for(int i=0 ; i<list.size() ;i++) {
			String word = index + list.get(i).length() >= s.length() ?
					s.substring(index) :  s.substring(index,index + list.get(i).length());
			if(word.equals(list.get(i))) {
				if( recursive( s, list,   index+ list.get(i).length(), map)) return true;
				map.put(index+ list.get(i).length(), false);
			}
		}
		return false;
	
	}
	
	public static boolean wordBreak(String s, List<String> list) {
		if(recursive(s, list, 0, new HashMap<>())) return true;
		return false;
    }
}
