package leetcode.questions.x401.to.x499;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/next-greater-element-i/description/
public class Problem_496 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//since all values are unique
		//hashmap is the way
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums2.length ;i++) {
			int v= i+1;
			while(v < nums2.length) {
				if(nums2[v] > nums2[i]) {
					map.put(nums2[i], nums2[v]);
					break;
				} 
				else v++;
			}
		}
		
		int [] ouutput = new int[nums1.length];
		for(int i=0; i<nums1.length ;i++) {
			if(map.containsKey(nums1[i])) {
				ouutput[i] = map.get(nums1[i]);
			}else {
				ouutput[i] =-1;
			}
		}
		return ouutput;
    }
}
