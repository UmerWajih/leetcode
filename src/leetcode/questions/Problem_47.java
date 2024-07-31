package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_47 {

	//https://leetcode.com/problems/permutations-ii/
	//[1,2,3]
	
	//1,11,11
	//1,2,11
	//1,2,3 -> this will be added
	//1,2,11
	//1,11,11
	//1,11,2
	
	private static void recursive(int[] nums, Integer[] arr, int index, Set<List<Integer>> set) {
		if (index == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(arr[i]);

			}
			set.add(list);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (arr[i] == 11) {
				arr[i] = nums[index];
				recursive(nums, arr, index + 1, set);
				arr[i] = 11;
			}
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Integer[] arr = new Integer[nums.length];
		Arrays.fill(arr, 11);
		Set<List<Integer>> set = new HashSet<>();
		recursive(nums, arr, 0, set);
		return new ArrayList<>(set);
	}
}
