package leetcode.questions.x101.to.x200;

public class Problem_136 {

	//https://leetcode.com/problems/single-number
	public int singleNumber(int[] nums) {
		//every number occurs twice
		//we xor those 2 numbers we'll get 0
		int num = nums[0];
		for(int i=1; i< nums.length; i++) {
			num = num ^ nums[i];
		}
		return num;
    }
}
