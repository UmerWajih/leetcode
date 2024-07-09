package leetcode.questions.x2700.to.x2799;

import java.util.List;

public class Problem_2781 {
	//we need start index 
	//we need another index
	
	//https://leetcode.com/problems/length-of-the-longest-valid-substring/
	
	//word = "leetcode", forbidden = ["de","le","e"]
	private static int recursive(String word, List<String> forbidden, int index, int num, int maxSize) {
		if (index == word.length() || num > word.length()) return maxSize;
		String substring = num == word.length() ? word.substring(index) : word.substring(index, num);
		
		//this lookup needs to be improved
		for(String s : forbidden) {
			if(s.length() > substring.length()) continue;
			//if this is true it means forbidden char has been found so increment the index
			String str  = substring.substring(num - s.length() - index);
			if(str.equals(s)) {
				int newIndex = num - s.length()+1;
				return recursive(word,  forbidden,newIndex ,  newIndex+1,  maxSize);
			}
		}
		//if we are here it means substring is valid
		maxSize = Math.max(substring.length(), maxSize);
		return recursive(word, forbidden,  index,  num+1,  maxSize);
	}
	
	
	public static int longestValidSubstring(String word, List<String> forbidden) {
        return recursive(word, forbidden, 0, 1, 0);
    }
}
