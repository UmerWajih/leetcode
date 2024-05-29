package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_55 {

	//https://leetcode.com/problems/jump-game/description/
	 public static boolean canJump(int[] nums) {
	        return recursive(nums,0, new HashMap<>());
	 }
	 public static boolean recursive(int[] nums,int index, Map<Integer, Boolean> map) {
		 	if(map.containsKey(index))return false;
		 
		 	map.put(index, true);
		 	
	        if(index >= nums.length-1) return true;
	        
	        if(nums[index] == 0) return false;
	        
	        int i=0;
	        boolean valid=false;
	        while (!valid && i < nums[index]-1) {
	        	valid=recursive(nums, index+nums[index]-i,map ) ;
	        	i++;
	        }
	        if (valid) { 
	        	return true;
	        }
	        return recursive(nums, index+1,map);
	 }
}
