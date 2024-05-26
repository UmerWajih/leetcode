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
	//if index == candidates .len return
	//if sum == target add
	//if index > 0 and previos value is same then just move forward
	//if candidates[index] > target return
	// keep going till the sum is less than target
	
	//candidates = [1,1,2,5,6,7,10], target = 8
	// 1 < 8
	// 1+1 < 8
	// 1+1+2< 8
	// 1+1+2+5 < 8 // false
	// 1+1+5 < 8
	// 1+1+5+6< 8 false
	// 1+1+6 == 8 ADD 
	// 1+2 < 8
	// 1+2+7 == 8 ADD
	// 1+5 < 8 
	// 1+5+6 < 8 false
	// 1+6 < 8
	// 1+6+7 <8 false
	// 1+ 7 == 8
	// 1 is same as 1 before so to avoid duplicates move forwARD
	// 2
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
		// this would mean we are moving onto next index
		while (index + 1 < candidates.length && candidates[index] == candidates[index + 1])
			index += 1;
		recursive(candidates,  target,  index+1,  ouptut, list);
	}
	
	
	
	
//	public static void recursive(int[] candidates, int target, int index, 
//			List<List<Integer>> ouptut, List<Integer> list) {
//		
//		if(index == candidates.length) return;
//		if(candidates[index] > target) return;
//		
//		int sum = list.stream()
//		  .mapToInt(Integer::intValue)
//		  .sum();
//		if(sum == target) {
//			ouptut.add(new ArrayList<>(list));
//			return;
//		}
//		if(sum > target) {
//			list.remove(list.size()-1);
//			return;
//		}
//		list.add(candidates[index]); 
//		recursive(candidates,  target,  index+1,  ouptut, list);
//		
//		int i=1;
//		
//		while(index+i < candidates.length) {
//			if(sum + candidates[index+i] <= target) {
//				recursive(candidates,  target,  index+i,  ouptut, list);
//				i++;
//			}else {
//				list.remove(list.size()-1);
//				break;
//			} 
//		}
//	}
}
