package leetcode.questions.x201.to.x299;

public class Problem_209 {

	//https://leetcode.com/problems/minimum-size-subarray-sum
	
	//set min len to max int vaule => when we find a match it will be set to that
	//we have to find a sub array => no breaks in array
	// add sum > once we cross the target line, start removing first element to see if it has an impact
	// once sum goes down the target increment nums
	public static int minSubArrayLen(int target, int[] nums) {
		int minLen=Integer.MAX_VALUE, left=0, sum=0;
		
		for(int i=0; i<nums.length;i++) {
			sum+=nums[i];
			
			while (sum >= target) {
				sum-=nums[left];
				minLen = Math.min(minLen, i - left + 1);
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
		
   }

	
	/*
	 * // solution if we are only dealing with equal to target // not needed here
	 * public static int minSubArrayLen2(int target, int[] nums) { int min=
	 * recursive( target, nums, 0, Integer.MAX_VALUE, 0, new Stack<Integer> (), 0,
	 * 0); return min == Integer.MAX_VALUE ? 0 : min; }
	 * 
	 * // we need start pointer => when this reached end of array end // we need
	 * second pointer => when this reaches end of array increment start pointer //
	 * we need third index to move over => when this reaches end of array increment
	 * second pointer public static int recursive(int target, int[] nums, int
	 * startIndex, int minimumSize, int sum, Stack<Integer> stack, int secondIndex,
	 * int thirdIndex) { if (startIndex == nums.length) return minimumSize; if
	 * (secondIndex == nums.length) { return recursive( target, nums, startIndex+1,
	 * minimumSize, 0, new Stack<Integer>(), startIndex+1, startIndex+1); } if
	 * (thirdIndex == nums.length) { Stack<Integer> newStack = new Stack<Integer>();
	 * newStack.add(nums[startIndex]);
	 * 
	 * return recursive( target, nums, startIndex, minimumSize, nums[startIndex],
	 * newStack, secondIndex+1, secondIndex+1); }
	 * 
	 * sum = nums[thirdIndex] + sum;
	 * 
	 * if(sum == target && minimumSize > stack.size()+1) { minimumSize =
	 * stack.size()+1; if(minimumSize == 1) return minimumSize; }
	 * 
	 * if(sum < target) { stack.add(nums[thirdIndex]); } if(sum > target) { sum =
	 * sum - nums[thirdIndex]; }
	 * 
	 * 
	 * return recursive( target, nums, startIndex, minimumSize, sum, stack,
	 * secondIndex, thirdIndex+1);
	 * 
	 * }
	 */
}
