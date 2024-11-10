package leetcode.questions.x800.to.x899;

//https://leetcode.com/problems/shifting-letters/
public class Problem_848 {
	
	public static String shiftingLetters(String s, int[] shifts) {
        //s = "abc", shifts = [3,5,9]
		
		char [] arr = s.toCharArray();
		
		//anpther thing we can do is add up all the shifts
		for(int i=shifts.length-2; i>=0;i--) {
			shifts[i] = (shifts[i+1]+shifts[i])%26; 
		}
		
		for (int j=0;j<arr.length;j++) {
			arr[j]= (char) (((arr[j] - 'a' + shifts[j])%26)+'a');
		}
		
		
		
		
		return new String(arr);
    }
}
