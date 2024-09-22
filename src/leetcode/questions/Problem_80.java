package leetcode.questions;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=problem-list-v2&envId=two-pointers
public class Problem_80 {
	//this two pointer is different
	
	//one is for keeping track of an element
	// second one is or switching
	public static int removeDuplicates(int[] nums) {
		//if its less than 3 it is always valid
        if(nums.length < 3) return nums.length;
        
        int repIndex= 2;
		for(int i=2; i< nums.length; i++) {
			//do with repIndex instead of i as i will always increase which will mess up the order and output
			if ( nums[i] > nums[repIndex - 2]) {
				nums[repIndex++] = nums[i];
				
			} 
		}
		return repIndex;
    }
}
