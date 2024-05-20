package leetcode.questions;

public class Problem_48 {

	//https://leetcode.com/problems/rotate-image/
	public static  void rotate(int[][] matrix) {
        //rotate i with j 
		int col = matrix.length;
		int row = matrix[0].length;
		for (int i=0; i< row; i++) {
			for (int k=i; k< col; k++) {
				int t = matrix[i][k];
				matrix[i][k] = matrix[k][i]; 
				matrix[k][i] = t;
			}
		}
		
		// now reverse the colums
		int start = 0, end=col-1;
		for(int i=0; i< row; i++) {
			while(start < end) {
				int t = matrix[i][end];
				matrix[i][end] = matrix[i][start];
				matrix[i][start] = t;
				start++;end--;				
			}
			start = 0; end=col-1;
		}
    }
}
