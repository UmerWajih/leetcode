package leetcode.questions.x500.to.x599;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/
public class Problem_525 {
	//0,1,1,0,1,1,1,0
	public static int findMaxLength(int[] nums) {
		//0,1
        int sum=0, maxLen=0;
		Map<Integer, Integer> map  = new HashMap<>();
		map.put(0, -1);
		for(int i=0; i<nums.length;i++) {
			if(nums[i]==0) {
				sum--;
			}else {
				sum++;
			}
			
			if(map.containsKey(sum)) {
				maxLen= Math.max(maxLen,i-map.get(sum) ) ;
			}else {
				map.put(sum, i);
			}
			
		}
		return maxLen;
    }
}
