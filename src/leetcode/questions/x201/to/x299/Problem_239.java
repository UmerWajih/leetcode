package leetcode.questions.x201.to.x299;

//https://leetcode.com/problems/sliding-window-maximum/
public class Problem_239 {

	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		//first get sum of first k elements.

		int [] returnArr = new int [nums.length+1-k];
		int maxValue= Integer.MIN_VALUE;
		for(int i=0; i<k; i++) {
			maxValue= Math.max(maxValue, nums[i]);
		}
		returnArr[0] = maxValue;
		int index=1;
		for(int i=k; i< nums.length; i++) {
			if(maxValue != nums[i-k]) {
				maxValue= Math.max(maxValue, nums[i]);
			}else {
				maxValue=getMaxValue(nums, (i-k)+1, k);
			}
			returnArr[index] = maxValue;
			index++;
		}
		
		
 		return returnArr;
		
    }
	private static int getMaxValue(int[] nums, int start, int k) {
		int maxValue= Integer.MIN_VALUE;
		for(int i=start; i<start+k; i++) {
			maxValue= Math.max(maxValue, nums[i]);
		}
		
		return maxValue;
	}
}
