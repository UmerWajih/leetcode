package leetcode.questions;


//https://leetcode.com/problems/sort-colors/description/?envType=problem-list-v2&envId=two-pointers
public class Problem_75 {
	//throw all 2 to the end
	//throw all 0 to front
	//you will be left with 1 in middle
	
	
	//2,0,2,1,1,0
	public static void sortColors(int[] nums) {
        int l=0, r= nums.length-1, index=0;
        
        while(index <= r) {
        	if(nums[index]==0) {
        		int t= nums[index];
        		nums[index]=nums[l];
        		nums[l] = t;
        		l++;
        	}
        	if(nums[index]==2) {
        		int t= nums[index];
        		nums[index]=nums[r];
        		nums[r] = t;
        		r--;
        		continue;
        	}
        	index++;
        }
    }
}
