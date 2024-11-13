package leetcode.questions.x201.to.x299;

//https://leetcode.com/problems/move-zeroes/
public class Problem_283 {
	public void moveZeroes(int[] nums) {
        int count =0;

        for(int i=0; i< nums.length; i++){
            if(nums[i] ==0) {
                count++;
                continue;
            }
            nums[i-count] = nums[i];
        }
        for(int i=0 ; i<count ; i++){
            nums[nums.length-1-i] = 0;
        }
    }
}
