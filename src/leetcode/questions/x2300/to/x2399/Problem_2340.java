package leetcode.questions.x2300.to.x2399;

public class Problem_2340 {

	//https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/
	public static  int minimumSwaps(int[] nums) {
		int min = nums[0], max= nums[0], minIndex=0,maxIndex=0;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] < min ) {
				min= nums[i];
				minIndex = i;
			}
			if(nums[i] >= max ) { //we need the right most occurance on equal increment index
				max= nums[i];
				maxIndex =i; //we need to reset the a
			}
		}
		if(minIndex <= maxIndex) { //if there is only 1 element in that case we need =
			return minIndex+ (nums.length-1 - maxIndex);
		}
		return minIndex+ (nums.length-1 - maxIndex)-1;
	}
}
