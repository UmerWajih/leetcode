package leetcode.questions.x101.to.x200;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class Problem_151 {
	//easiest solution is to do string split on ' ' then add words  together in reverse
	//another will be to use stacks and queues it will be too space ineffecient
	
	public String reverseWords(String s) {
		int i =0, j=s.length()-1;
		char [] c = s.toCharArray();
		
		//reverse the entire string
		while(i<=j) {
			char temp = c[i];
			c[i]= c[j];
			c[j] = temp;
			j--; i++;
			
		}
		
		//fix each word individually
		i= 0; 
		for(int k =0; k<= s.length(); k++) {
			if(k == s.length() || c[k] == ' ') {
				j=k-1; 
				while(i<=j) {
					if(c[i] ==' ') {
						i++; continue;
					}
					char temp = c[i];
					c[i]= c[j];
					c[j] = temp;
					j--; i++;
				}
				i=k;
			}
		}
		
		
		//remove spaces
		char [] output  = new char[c.length];
		i=0;
		boolean addChar=false;
		for(int k =0; k< s.length(); k++) {
			if(c[k] != ' ') {
				addChar = true;
			}
			if(addChar) {
				output[i]=c[k];
				i++;
			}
			if(c[k] == ' ') {
				addChar = false;
			}
		}
		
		if(output[i-1] == ' ' ) {
			i--;
		}
		
		return String.valueOf(Arrays.copyOfRange(output, 0, i));
    }
}
