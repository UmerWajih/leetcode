package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class Problem_73 {


//	for(int k =0; k< matrix.length; k++) {
//		matrix[k][j]=0;
//	}
//	
	
	public void setZeroes(int[][] matrix) {		
		//we need indexes of 0's
		//then update based on those indexes
		Set<Integer> cols = new HashSet<>();
		Set<Integer> rows = new HashSet<>();
		for (int i =0 ;i<matrix.length; i++) {
			
			for (int j =0 ;j<matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					cols.add(j);rows.add(i);
				}
			}
		}
		for (Integer col : cols) {
			for(int k =0; k< matrix.length; k++) {
				matrix[k][col]=0;
			}
		}
		
		
		
    }
}
