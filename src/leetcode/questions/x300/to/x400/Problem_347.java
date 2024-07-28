package leetcode.questions.x300.to.x400;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem_347 {
	//https://leetcode.com/problems/top-k-frequent-elements/
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		for (int i =0; i< nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		int [] output = new int[k];
		PriorityQueue<Entry<Integer, Integer>> q = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
		q.addAll(map.entrySet());
		
		for(int i=0; i<k;i++) {
			output[i]= q.poll().getKey();
		}
		return output;
    }
}
