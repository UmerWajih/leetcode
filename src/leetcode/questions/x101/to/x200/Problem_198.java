package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.Map;

public class Problem_198 {

	//https://leetcode.com/problems/house-robber
	
	 private static int recursive (int[]nums , int index, int sum, Map<Integer, Integer> map, int maxSum) {
			if(index < 0 ) return maxSum;
			if(map.containsKey(index)) {
				return Math.max(sum+  map.get(index), maxSum);
			}
			int old =sum;
			sum+=nums[index];
			int maxLoot=0;
			int pointer =2;
			while(index+pointer < nums.length) {
				maxLoot = Math.max(recursive (nums , index+pointer,  sum, map, maxSum), maxLoot);
				pointer++;
				
			}
			sum = maxLoot == 0 ? sum : maxLoot;
			map.put(index, sum-old);
			
			maxSum = Math.max(sum, maxSum);
			return recursive (nums ,  index-1, 0,  map, maxSum);
			
		}
		public static int rob(int[] nums) {
	        return recursive (nums ,   nums.length-1, 0,  new HashMap<>(), 0);
	    }
}
