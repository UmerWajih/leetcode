package leetcode.questions.x1400.to.x1499;

import java.util.TreeSet;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class Problem_1438 {

	//sort and run sliding window
	public static int longestSubarray(int[] nums, int limit) {
		//we need to keep track of maximum and minumum value within the window
		
		int start=0, end =0;
		int max=0;
		
		int minValue = Integer.MAX_VALUE, maxValue= 0;
		TreeSet<Integer> set = new TreeSet<>();
		while(end < nums.length) {
			minValue = Math.min(minValue, Math.min(nums[end] , nums[start]));
			maxValue= Math.max(maxValue, Math.max(nums[end] , nums[start]));
			
			set.add(nums[start]); set.add(nums[end]); 
			if(Math.abs(maxValue - minValue ) <= limit) {
				end++;
			}else {
				max=Math.max(end-start, max);
				
				if(set.first() == nums[start]) {
					set.remove(set.first());
					minValue= set.first();
				}
				if(set.last() == nums[start]) {
					set.remove(set.last());
					maxValue= set.last();
				}
				start++;
			}
		}
		
		max=Math.max(end-start, max);
		return max;		
    }
}
