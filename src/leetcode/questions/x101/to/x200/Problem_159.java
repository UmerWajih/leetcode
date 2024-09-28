package leetcode.questions.x101.to.x200;


//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
public class Problem_159 {
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		//initilazte max len
		int max=0;
		
		//create an array of size 2
		int[]arr= new int[2];
		
		//we need start index
		int start=0;
		
		
		for(int i=0; i<s.length(); i++) {
			//we need to initialize arr
			if(arr[0]==0) {
				arr[0]=s.charAt(i);
				continue;
			}
			if(arr[1]==0 && arr[0]== s.charAt(i)) {
				continue;
			}
			if(arr[1]==0 && arr[0]!= s.charAt(i)) {
				arr[1]=s.charAt(i);
				continue;
			}
			
			//if repeating character then continue
			if(arr[0]==s.charAt(i) || arr[1]==s.charAt(i)) {
				continue;
			}
			
			//here we have a different character
			//"abaccc"
			char old =' ';
			if(arr[0]==s.charAt(start)) {
				old= (char)arr[0];
				arr[0]=s.charAt(i);				
			}else if(arr[1]==s.charAt(start)) {
				old= (char)arr[1];
				arr[1]=s.charAt(i);				
			}
			int index= i;
			while(s.charAt(index)!=old) {
				index--;
			}
			max=Math.max(max, i-start) ;
			if(index+1 == i) {
				arr[0]=s.charAt(i);
				arr[1]=old;
				start=index;
				while(old == s.charAt(start)) {
					start--;
				}
				if(start!=index) start+=1;
			}else {
				start = index+1;
			}
			
			
			
		}
		
		
		return Math.max(max, s.length()-start);
	}
	
}
