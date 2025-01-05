package leetcode.questions.x900.to.x999;

public class Problem_977 {
	
	public int[] sortedSquares(int[] nums) {
		int output[] = new int[nums.length];
		int index=nums.length-1;
		int i=0, j=nums.length-1;
		
		while(i<=j) {
			if(Math.abs(nums[i]) > Math.abs(nums[j])) {
				nums[index]= (int)Math.pow(nums[i], 2); 
				i++;
			}else {
				nums[index]= (int)Math.pow(nums[j], 2); 
				j--;
			}
			index--;
		}
		return output;
    }
}
