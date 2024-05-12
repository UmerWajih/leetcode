package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_15 {

	//https://leetcode.com/problems/3sum/description/
	public static List<List<Integer>> threeSum(int[] nums) {
        int i=0, j=i+1, k=nums.length-1;
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        while (i < j && j < nums.length-1) {
        	if(i !=0 && nums[i] == nums[i-1]) {
        		i++;j=i+1; k=nums.length-1;
        		continue;
        	}
        	while (j<k) {
        		int sum = nums[i] + nums[j] + nums[k];
        		if(sum == 0) {
        			output.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			
        			while(j+1 < nums.length-1 && nums[j] == nums[j+1]) {
        				j++;
        			}  
        			while(k-1 > j && nums[k] == nums[k-1]) {
        				k--;
        			}  
        			j++;k--;
        		}
        		if(sum > 0) k--;
        		if(sum < 0) j++;
        	}
        	i++;j=i+1; k=nums.length-1;
        }
        
        return output;
    }
}
