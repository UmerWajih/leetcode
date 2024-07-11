package leetcode.questions;

public class Problem_29 {

	//https://leetcode.com/problems/divide-two-integers/
	
	public static int divide(int dividend, int divisor) {
     
		 // Special case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to positive
        // need long here due the fact there are too many test cases will dividend as Integer.Min_Value
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor); 

        int result = 0;
        
        // Loop until the dividend is greater than or equal to the divisor
        while (dividendAbs >= divisorAbs) {
            long temp = divisorAbs;
            int multiple = 1;
            // Shift the divisor left until it's greater than the dividend
            while (dividendAbs >= (temp << 1)) {
                temp <<= 1;  //temp would be 6 -> one shift to left
                multiple <<= 1; //mulitple would be 2 -> one shift
            }
            // Subtract the largest shifted divisor from the dividend
            dividendAbs -= temp;//dividend would now be 4
            // Add the multiple to the result
            result += multiple; //result would now be 2 //on second iteration multpile would be added again
        }

        // Apply the sign to the result
        return negative ? -result : result;
    }
}
