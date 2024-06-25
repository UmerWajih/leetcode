package leetcode.questions.x300.to.x400;

public class Problem_392 {

	//https://leetcode.com/problems/is-subsequence
	public static boolean isSubsequence(String s, String t) {
		int i= 0, j =s.length()-1;
		
		int str1= 0, str2= t.length()-1;
		
		while(i <= j && str1 <= str2) {
			if(i!=j && str1==str2)return false;
			if (t.charAt(str1) == s.charAt(i)) i++;
			if (t.charAt(str2) == s.charAt(j)) j--;
			
			str1++; str2--;
		}
		
		if (i > j) return true;
		else return false;
		
    }
}
