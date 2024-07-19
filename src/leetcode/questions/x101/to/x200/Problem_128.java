package leetcode.questions.x101.to.x200;

import java.util.HashSet;
import java.util.Set;

public class Problem_128 {
	//https://leetcode.com/problems/longest-consecutive-sequence/
	//nums = [100,4,200,1,3,2]
	public int longestConsecutive(int[] nums) {
        //add all elements to a set
		Set<Integer> set = new HashSet<>(); //100,4,200,1,3,2
		for(int k : nums) {set.add(k);}
		int maxCount=0;
		// start loop again
		for(int k : nums) {
			//sequence for this element has already bee dealt with
			if(!set.contains(k))continue;
			//create a count for counter
			int count=1; //100
			int val = k;
			//remove that number
			set.remove(val); //set no longer has 4 init
			while(set.contains(--val)) { //0 is not  present break when count=4
				count++;
				set.remove(val);
			}
			//reset val
			val = k;
			while(set.contains(++val)) { //5 is not preset so break
				count++;
				set.remove(val);
			}
			maxCount = Math.max(maxCount, count);
			
		}
		
		return maxCount;
    }
}
