package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_224 {

	//https://leetcode.com/problems/basic-calculator
	private static int computeOutput(List<Integer> numbers, List<Character> operands) {
		int output = numbers.get(0);
		for (int i = 0; i < operands.size(); i++) {
			switch (operands.get(i)) {
				case '+': {
					output += numbers.get(i + 1);
					break;
				}
				case '-': {
					output -= numbers.get(i + 1);
					break;
				}
			}
		}
		return output;
	}
	
	//
	private static List<Integer> recursive(String s, int index) {
		String n="";
		List<Integer> numbers = new ArrayList<>(); //1
		List<Character> operands = new ArrayList<>(); //+
 		while(index <= s.length()) {
 			if(index == s.length() ) {
 				if(!n.equals(""))numbers.add(Integer.parseInt(n));
 				break;
 			}
			if(s.charAt(index) == '(') {
				List<Integer> temp = recursive(s, index+1);
				numbers.add(n.equals("-") ?  temp.get(0) * -1 : temp.get(0));
				n="";
				index=temp.get(1)+1;
				continue;
			}
			if(s.charAt(index) == ')') {
				if(! n.equals(""))numbers.add(Integer.parseInt(n));
				return Arrays.asList(computeOutput( numbers, operands), index) ;
			}
			
			//1- (-2+1)
			//n!=""
			//-(2+1)-2
			
			if(s.charAt(index) ==  '-' && numbers.isEmpty() && n.equals("")){
				n+=s.charAt(index);
				index++; continue;
			}
			
			
			if(s.charAt(index) ==  '+' || s.charAt(index) ==  '-' ) {
				if(!n.equals("")) {
					numbers.add(Integer.parseInt(n));
					n="";
				}  
				operands.add(s.charAt(index));
				index++;
				continue;
			}
			if(s.charAt(index) ==  ' ') {
				index++; continue;
			}
			n+=s.charAt(index);
			index++;
		}
 		
		return Arrays.asList(computeOutput( numbers, operands));
		
	}
	
	public static int calculate(String s) {
        return recursive(s, 0).get(0);
    }
}
