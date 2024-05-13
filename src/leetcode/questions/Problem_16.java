package leetcode.questions;

import java.util.Arrays;

public class Problem_16 {

	//https://leetcode.com/problems/3sum-closest/
	
	//Sort the array
	//set target to integer max
	//if sum  < diff update diff
	// ignore duplicates for time purpose
	// d k--
	public static int threeSumClosest(int[] nums, int target) {
        
		int i=0, j=i+1, k=nums.length-1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE ;
        int sumFinal = Integer.MAX_VALUE ;
		while (i < j && j < nums.length-1) {
        	while (j < k) {
        		int sum = nums[i] + nums[j] + nums[k];
        		//find diff between sum and target
            	int abs = Math.abs(sum -  target );
            	
            	// if sum and target equal then return sum
            	if(abs==0) {return sum;}
            	
            	
            	
            	if(sum > target) {
            		// to avoid repititons
                	while(k-1 > j && nums[k] == nums[k-1]) {
        				k--;
        			} 
                	k--;
            	}else {
            		// to avoid repititons
            		while(j+1 < nums.length-1 && nums[j] == nums[j+1]) {
        				j++;
        			} 
            		j++;
            	}
            	//if abs value is less than previous diff save this
            	if(abs<= diff) {
            		diff = abs;
    				sumFinal = sum;
            	}
        	}
        	
        	i++; j=i+1;k=nums.length-1;
        }
		return sumFinal;
    }
}
