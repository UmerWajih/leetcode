package leetcode.questions.x300.to.x400;

import java.util.List;

import leetcode.questions.Common.NestedInteger;

public class Problem_339 {
	//https://leetcode.com/problems/nested-list-weight-sum/
	
	//elements within nestedInteger can be either only list or int not both.
	//we need levels
	
	private int recursive(NestedInteger integer, int level, int sum) {
		if(integer==null)return sum;
        
		if(integer.getList() == null || integer.getList().isEmpty()) {
			//this means it only has an integer inside of it
            if(integer.getInteger() == null)return sum;
			sum += (integer.getInteger() * level);
			return sum;
		}
		
		for(NestedInteger i : integer.getList()) {
			sum=recursive(i,  level+1, sum);
		}
		return sum;
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
		int sum=0, level=1;
		for(NestedInteger i : nestedList) {
			sum=recursive(i,  level,  sum);
		}
       return sum;
        
    }
}
