package leetcode.questions.x201.to.x299;

import java.util.HashSet;
import java.util.Set;

public class Problem_217 {

	
	//https://leetcode.com/problems/contains-duplicate/
public boolean containsDuplicate(int[] nums) {
		Set<Integer> set  = new HashSet<>(); 
		for(int i : nums) {
			if(set.contains(i))return true;
			set.add(i);
		}
		return false;
    }
}
