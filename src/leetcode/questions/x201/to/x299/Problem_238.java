package leetcode.questions.x201.to.x299;
//https://leetcode.com/problems/product-of-array-except-self/
public class Problem_238 {

public static int[] productExceptSelf(int[] nums) {
        
	//Input: nums = [1,2,3,4]
	//Output: [24,12,8,6]
	
	// 1, 2, 6,24
	// 1, 1, 2, 6
	int[] result = new int[nums.length];
	int tmp=1;
    for (int i = 0; i < nums.length; i++) {
        result[i] = tmp;
        tmp *= nums[i];
    }
    tmp=1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] *= tmp;
        tmp *= nums[i];
    }
    return result;
    }
}
