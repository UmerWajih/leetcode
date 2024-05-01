package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_1 {

	//https://leetcode.com/problems/two-sum/
	public static int[] twoSum(int[] nums, int target) {
        int i =0 , j = nums.length-1;
        int [] output = new int [2];  
        while (j > 0) {
	        while(i < j) {
	        	if(nums[i] + nums[j] == target) {
	        		output[0]=i;
	        		output[1]=j;
	        		break;
	        	}
	        	i++;
	        }
	        i=0;
	        j--;
        }
        return output;
    }
	
	public static int[] twoSumHashTable(int[] nums, int target) {
        int j = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int k = 0; k< j; k++) {
        	map.put(nums[k], k);
        }
        
        int [] output = new int [2];  
        
        
       for (int k = 0; k< j; k++) {
    	   int diff =target - nums[k];
    	   if(map.containsKey(diff) && map.get(diff)!=k){
    		   	output[0]=k;
	       		output[1]=map.get(diff);
	       		break;
    	   }
       }
        return output;
    }

}
