package leetcode.questions;

public class Problem_8 {

	//start from the beginning
	//if char equal space continue
	// create a int multiply by 10 and add char int value
	// keep track of negative vals
	
	public static int myAtoi(String s) {
		char[] c = s.toCharArray();
		boolean isNegative=false, isIntFound = false, isPositive=false;
		int k=0;
		for (int i=0 ; i< c.length ;i++) {
			if(c[i] == ' ' && !isIntFound && !isNegative && !isPositive) {
				continue;
			}
			if(c[i] == '-' && !isIntFound && !isNegative && !isPositive) {
				isNegative=true;
				continue;
			}
			//we need to add + flag solely for this area
			if(c[i] == '+' && !isIntFound && !isPositive && !isNegative) {
				isPositive=true;
				continue;
			}
			
			
			//break if character is not int
			if(c[i] < 48 || c[i] >57) {
				break;
			}
			
			if(c[i] >= 48 && c[i] <=57) {
				if((k > Integer.MAX_VALUE/10 && !isNegative) || 
						(k == Integer.MAX_VALUE/10 && !isNegative && Integer.valueOf(String.valueOf(c[i])) >= 7)
						) return Integer.MAX_VALUE;
				if((k > Integer.MAX_VALUE/10 && isNegative) || 
						(k == Integer.MAX_VALUE/10 && isNegative && Integer.valueOf(String.valueOf(c[i])) >= 8)
						) return Integer.MIN_VALUE;
				k = (k*10) + Integer.valueOf(String.valueOf(c[i]));
				if(!isIntFound)isIntFound=true;
			}else if(isIntFound) {
				break;
			}
		}
		
        return isNegative ? k*-1 : k;
    }
}
