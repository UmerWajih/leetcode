package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/first-missing-positive/
public class Problem_41 {
	
	public static int firstMissingPositive(int[] nums) {
		int miss=1;
		Set<Integer> set = new HashSet<>();
		
		for(int i : nums) {
			if(i<= 0) continue;
			if(i==miss) {
				miss++;
				while(set.contains(miss)) {
					miss++;
				}
			}
			set.add(i);
		}
		return miss;
    }
}
