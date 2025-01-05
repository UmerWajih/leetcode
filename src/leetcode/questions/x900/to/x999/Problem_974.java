package leetcode.questions.x900.to.x999;

import java.util.HashMap;
import java.util.Map;

public class Problem_974 {

	public static int subarraysDivByK(int[] nums, int k) {
		
		//Map will store remianders of sum upto the index
		//if remainder exist increment that remainder count
		//reason, array between 2 sum which have same remainder is divisible by k
		Map<Integer, Integer> map = new HashMap<>();
		int sum=0;
		for(int i=0; i<nums.length; i++) {
			int remainder = (((sum+=nums[i])%k)+k)%k;
			if(!map.containsKey(remainder)) {
				map.put(remainder, 1);
			}else {
				map.put(remainder, map.get(remainder)+1);
			}
		}
		//this we copied, its mathematical formula
		int result = map.getOrDefault(0, 0);
		for (int frequency : map.values())
		    result += frequency * (frequency - 1) / 2;
		return result;
    }
}
