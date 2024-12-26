package leetcode.questions.x201.to.x299;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller
public class Problem_259 {

	public static int threeSumSmaller(int[] nums, int target) {
		if(nums.length < 3) return 0; //no chance of having a triplet
		//we can not sort as indexes matter in this question
		//above statement is a trap can not do it then without n^3 brute force
		//i,j,k just need to be different
		Arrays.sort(nums);
		
        int count=0;
        
        for(int i=0; i< nums.length-2; i++) {
        	int j=i+1, k = nums.length-1;
        	
        	while(j<k) {
        		int sum = nums[i]+nums[j]+nums[k];
        		if(sum < target) {
        			count+= k-j;
        			j++;;
        		}else {
        			k--;
        		}
        	}
        }
        
        return count;
    }
}
