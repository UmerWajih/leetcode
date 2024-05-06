package leetcode.questions;

import java.util.Arrays;

public class Problem_7 {

	//https://leetcode.com/problems/reverse-integer/description/
	
	
	// initial approach :
	// check if negative : if so multiply by -1 do this again at the end
	// start from the middle keep swapping till i=0 && j = array len
	
	public static int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0; // needed as our isNegative check will then throw an error
		boolean isNegative = x < 0;
        if(isNegative) x*=-1;
        if(x >= 0 && x <=9) { return isNegative ? x*-1 : x;}
       
        
        char[] c = String.valueOf(x).toCharArray();
        boolean isEven = c.length%2==0;
        int j =c.length/2, i = isEven ? (c.length/2)-1 : c.length/2;
        
        
        while (i>=0 && j < c.length) {
        	char temp = c[i];
        	c[i] = c[j];
        	c[j] = temp;
        	i--; j++;
            if(c.length == 2) break;
        }
        int t = Integer.parseInt(c[c.length-1]+"");
        c[c.length-1]='0';
        int reversed =  Integer.parseInt(new String(Arrays.copyOf(c, c.length-1)));
        if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && t > 7)) return 0;
        if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && t < -8)) return 0;
        
        return isNegative ? (((reversed*10)+t) * -1) : (reversed*10)+t;
        
        
    }
}
