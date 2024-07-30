package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_373 {

	//https://leetcode.com/problems/find-k-pairs-with-smallest-sums
	//[1,2,4,5,6]
	//[3,5,7,9]
	
	//need to add check if i+1 > j then set i to j 
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		PriorityQueue<Map.Entry<List<int[]> , Integer>> q 
			= new PriorityQueue <>( (a,b) -> (a.getValue()- b.getValue()));
		
		PriorityQueue<Integer> sum = new PriorityQueue <>((a,b) -> (b-a));
		
		Map <List<int[]> , Integer> map = new HashMap<>();
		for(int i=0;i<nums1.length; i++) {
			for(int j=0;j<nums2.length; j++) {
				
				if(sum.size() < k) {
					map.put( Arrays.asList(new int [] {i, nums1[i]},new int [] {j, nums2[j]}), nums1[i]+nums2[j]);
					sum.offer(nums1[i]+nums2[j]);
				}else {
					int p= sum.peek();
					if (sum.peek() > nums1[i]+nums2[j]) {
						sum.poll();
						map.put( Arrays.asList(new int [] {i, nums1[i]},new int [] {j, nums2[j]}), nums1[i]+nums2[j]);
						sum.offer(nums1[i]+nums2[j]);
					}else {
						break;
					}
				}
				
				
			}
		}
		
		q.addAll(map.entrySet());
		
		for(int i =0; i< k ; i++) {
			List<int[]> l = q.poll().getKey();
			
			list.add(Arrays.asList(l.get(0)[1],l.get(1)[1]));
		}
		return list;
    }
}
