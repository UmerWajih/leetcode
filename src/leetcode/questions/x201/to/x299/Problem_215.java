package leetcode.questions.x201.to.x299;

import java.util.PriorityQueue;

public class Problem_215 {
//https://leetcode.com/problems/kth-largest-element-in-an-array
	
	// nums = [3,2,1,5,6,4], k = 2
public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		//set heap size to k
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
        }
		//2,3
		
		//5,6
		
		for(int i =k ; i< nums.length ; i++) {
			if(nums[i] > heap.peek()) {
				heap.remove();
				heap.add(nums[i]);
			}
		}
		return heap.peek();
    }
}
