package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_39 {
	//https://leetcode.com/problems/combination-sum
	
	private  List<List<Integer>>  output = new ArrayList<>();
	private  int getSumForCombinationSum(List<Integer> temp, int val) {
		Integer sum = 0;
		for (Integer t : temp) {
			sum += t;
		}
		return sum + val;
	}
	public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recCombinationSum(candidates,  target, 0, new ArrayList<Integer>(), 0);
		return output;
    }
	
	private  void recCombinationSum(int[] candidates, int target, int index, List<Integer> temp, int arrIndex) {
		if(index == candidates.length)return;
		
		int sum = getSumForCombinationSum(temp, candidates[index]);
		
		if(sum == target) {
			temp.add(candidates[index]);
			output.add(new ArrayList<>(temp));
			temp.remove(arrIndex);
			return;
		}
		
		if(sum < target) {
			temp.add(candidates[index]);
			recCombinationSum(candidates,  target, index, temp, arrIndex+1);
			temp.remove(arrIndex);
			recCombinationSum(candidates,  target, index+1, temp, arrIndex);
		}
	}
}