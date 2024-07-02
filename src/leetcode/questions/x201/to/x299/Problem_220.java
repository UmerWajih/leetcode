package leetcode.questions.x201.to.x299;

import java.util.HashSet;
import java.util.Set;

public class Problem_220 {

	//https://leetcode.com/problems/contains-duplicate-iii/
	
	// real challenge here is the updation of i and j
	// we need to match all possible pairs
	// first start by reducing j
	// if j == i -> reset j -> increment i
	// keep s a set to store int values of j, no need to compute duplicates
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		int i=0, j = nums.length-1;
		Set<Integer> set = new HashSet<>(), setI = new HashSet<>();
		while (i!=nums.length) {

			//TODO: we also need to make some changes regarding i and j to one ridiculous test case
			//we also have to make sure j-i is <= index diff, no need to check
			if(j-i > indexDiff)j--;
			//if matches return true
			if( i!=j && Math.abs(i-j) <= indexDiff && Math.abs(nums[i]-nums[j]) <= valueDiff) {
				return true;
			}
			set.add(nums[j]);
			j--;
			//doing this because we have already computed for that value pair with i
			//we also need to check if j and i value to increase speed
			//if num at j > i we want j+1 < j
			//if num at i > j we want j+1 > j
			while (j > i && (set.contains(nums[j]) || 
					(nums[j-1] > nums[i] && nums[j-1] > nums[j]) || 
					(nums[i] > nums[j-1] && nums[j-1] < nums[j])
					))  j--;
			if(j<=i) {
				j = nums.length-1;
				i++;
				while (i<nums.length && setI.contains(nums[i])) i++;
				set.clear();
			}
			
		}
		return false;
    }
}
