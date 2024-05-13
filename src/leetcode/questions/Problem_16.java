package leetcode.questions;

import java.util.Arrays;

public class Problem_16 {

	//https://leetcode.com/problems/3sum-closest/
	public static int threeSumClosest(int[] nums, int target) {
        
		int i=0, j=i+1, k=nums.length-1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE ;
        int sumFinal = Integer.MAX_VALUE ;
		while (i < j && j < nums.length-1) {
        	while (j < k) {
        		int sum = nums[i] + nums[j] + nums[k];
            	int abs = Math.abs(sum -  target );
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
