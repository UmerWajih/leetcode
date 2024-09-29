package leetcode.questions.x1600.to.x1699;


//https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
public class Problem_1684 {

	//we'll do this through bit mask
	public int countConsistentStrings(String allowed, String[] words) {
        int mask=0;
        for(char c: allowed.toCharArray()) {
        	mask |= (1 << c - 'a');
        }
        int count=words.length;
        for(String a: words) {
        	for(char c :a.toCharArray()) {
        		if((mask & (1 << c - 'a')) == 0) {
        			count --;
        			break;
        		}
        	}
        }
        
        return count;
    }
}
