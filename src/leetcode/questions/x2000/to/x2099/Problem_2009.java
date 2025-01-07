package leetcode.questions.x2000.to.x2099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
public class Problem_2009 {

	public static int minOperations(int[] nums) {
        //first sort the array
		//o(nlogN)
		Arrays.sort(nums);
		if(nums.length==1) return 0;
		
//		List<Integer> duplicates = new ArrayList<>();
//		Map<Integer, Integer> count = new HashMap<>();
//		
//		for(int i:nums) {
//			count.put(i, count.getOrDefault(i, 0)+1);
//			if(count.get(i) > 1)duplicates.add(i);
//		}
//		if(nums[nums.length-1]-nums[0] == nums.length-1) {
//			//here last and first value are valid
//			//only duplicates, so we can just return the size
//			return duplicates.size();
//		}
		
		int min= Integer.MAX_VALUE;
		//start from 0, check how many changes will be needed
		for (int i=0; i<nums.length;i++) {
			int l=i-1, r=i+1;
			int lCount=0, rCount=0;
			int lIndex=1,rIndex=1;
			while(l>=0) {
				if(nums[l] != nums[i]-lIndex) {
					lCount++;
				}
				l--; lIndex--;
			}
			while(r < nums.length) {
				if(nums[r] != nums[i]+rIndex) {
					rCount++;
				}
				r++; rIndex++;
			}
			min=Math.min(min, rCount+lCount);
		}
		
		return min;
    }
}
