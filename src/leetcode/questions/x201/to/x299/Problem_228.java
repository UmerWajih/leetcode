package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.List;

public class Problem_228 {

	//https://leetcode.com/problems/summary-ranges
	
	//0,1,2,4,5,7\
	//0
	
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if(nums.length==0) return list;
		String start =String.valueOf(nums[0]); //0
		boolean flag = false;
		for(int i =1; i< nums.length ; i++) {
			if (nums[i-1] == nums[i]-1 && !flag) {
				start+="->"; // 0->
				flag=true;
				continue;
			}
			if (nums[i-1] != nums[i]-1) {
				if(flag)start+=String.valueOf(nums[i-1]); //0->2
				list.add(start);
				flag=false;
				start= String.valueOf(nums[i]);
				
			}
		}
		if(flag)start+=String.valueOf(nums[nums.length-1]);
		list.add(start);
		return list;
    }
}
