package leetcode.questions.x2000.to.x2099;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
public class Problem_2009 {

	public static int minOperations(int[] nums) {
        //first sort the array
		//o(nlogN)
		Arrays.sort(nums);
		if(nums.length==1) return 0;
		Deque<Integer> window = new LinkedList<>();
		int max=0;
		for(int i : nums) {
			while(!window.isEmpty() && i - window.peekFirst() >= nums.length) {
				//remove from window
				window.poll();
			}
			
			if(window.isEmpty() || window.peekLast() != i) {
				window.offer(i);
			}
			max= Math.max(max, window.size());
			
		}
		return nums.length-max;
		//
    }
}
