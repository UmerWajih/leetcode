package leetcode.questions.x500.to.x599;

import java.util.ArrayList;
import java.util.List;

public class Problem_528 {
	//https://leetcode.com/problems/random-pick-with-weight/description/
	
	
	public class Solution{
		private List<Integer> arr;
		public Solution(int[] w) {
			arr = new ArrayList<>();
	        for(int i=0; i< w.length;i++) {
	        	for(int j=0; j< w[i];j++) {
	        		arr.add(i); //add index based on weights
	        	}
	        }
	        
	    }
	    
	    public int pickIndex() {
	      int rIndex = (int) Math.floor(Math.random() * arr.size()) ;
	      return arr.get(rIndex);
	    }
	}
	

}
