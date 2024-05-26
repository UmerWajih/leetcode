package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_40 {
	//https://leetcode.com/problems/combination-sum-ii/
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ouptut = new ArrayList<>();
        recursive( candidates,  target, 0, 
        		ouptut, new ArrayList<>());
        return ouptut;
    }
	public static void recursive(int[] candidates, int target, int index, 
			List<List<Integer>> ouptut, List<Integer> list) {
		if(index == candidates.length) return;
		if(candidates[index] > target) return;
		
		list.add(candidates[index]); 
		int sum = list.stream()
				  .mapToInt(Integer::intValue)
				  .sum();
		if(sum == target) {
			ouptut.add(new ArrayList<>(list));
			list.remove(list.size()-1);
			return;
		}
		if(sum < target) {
			recursive(candidates,  target,  index+1,  ouptut, list);
		}else {
			list.remove(list.size()-1);
			return;
		}
		list.remove(list.size()-1);
		while (index + 1 < candidates.length && candidates[index] == candidates[index + 1])
			index += 1;
		recursive(candidates,  target,  index+1,  ouptut, list);
	}
}
