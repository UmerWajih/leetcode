package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/jump-game-ii/?envType=problem-list-v2&envId=dynamic-programming
public class Problem_45 {

	//all test cases are valid
	
	//our rec function will take in nums arr, current size, min size, index
	private static int rec(int[] nums, int cur, int min, int index, Map<Integer,Integer>map) {
		//if index reaches the end return min value
		if(index >= nums.length-1) return Math.min(min, cur);
		
		
		//we now need storage of min jumps from index
		if(map.containsKey(index)) return Math.min(min, cur+map.get(index));
		
		//here index will always be < nums.len -1
		//if we cant jump forward, return the current min
		//if cur >=min alse return mins
		if(nums[index] == 0 || cur >=min) return min;
		int old=min;
		//here try for all possiblse solutions
		for(int i= nums[index]; i>0; i--) {
			min = rec(nums, cur+1, min, index+i,map);
		}
		map.put(index, min==Integer.MAX_VALUE ? Integer.MAX_VALUE : min-cur);
		//here return min
		return min;
	}
	
	public static int jump(int[] nums) {
		 	return rec(nums,0, Integer.MAX_VALUE, 0, new HashMap<>());
	}
}
