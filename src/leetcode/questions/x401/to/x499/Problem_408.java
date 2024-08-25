package leetcode.questions.x401.to.x499;

//https://leetcode.com/problems/valid-word-abbreviation/description/
public class Problem_408 {
	//since there cant be leading 0
	//get len
	//append len to word index and contniue
	
	public static boolean validWordAbbreviation(String word, String abbr) {
		char[] arr = abbr.toCharArray();
		int wordIndex=0;
		int val =0;
		
		for(int i=0; i< arr.length ;i++) {
			if(Math.abs(arr[i] - '0') <=9 && (val != 0 || Math.abs(arr[i] - '0') >0)) {
				val= (val*10) + Math.abs(arr[i] - '0');
				continue;
			}
			wordIndex += val;
            if(wordIndex >= word.length() ) return false;
			val=0;
			if(arr[i] == word.charAt(wordIndex)) {
				wordIndex++;
				continue;
			}
			return false;
		
		}
		return wordIndex+val == word.length();
    
    }
}
