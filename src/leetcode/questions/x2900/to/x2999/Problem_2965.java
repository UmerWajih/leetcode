package leetcode.questions.x2900.to.x2999;

import java.util.HashSet;
import java.util.Set;

public class Problem_2965 {
	//https://leetcode.com/problems/find-missing-and-repeated-values/
	 public int[] findMissingAndRepeatedValues(int[][] grid) {
	        int numberOfVals= grid.length * grid.length;
	        Set<Integer>set = new HashSet<>();
	         for (int i = 1; i <= numberOfVals; i++) {
	            set.add(i);
	        }
	        
	        int []arr = new int [2];

	        for(int i = 0; i < grid.length; i++){
	            for(int j = 0; j < grid.length; j++){
	                if(!set.contains(grid[i][j])){
	                    arr[0]=grid[i][j];
	                }else{
	                    set.remove(grid[i][j]);
	                }
	            }
	        }

	        for(int i: set){
	            arr[1] = i;
	        }
	        return arr;
	    }
}
