package leetcode.questions.x1600.to.x1699;

//https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/
public class Problem_1605 {

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int [][]matrix = new int[rowSum.length][colSum.length];
        
        for(int col =0; col < colSum.length ;col++) {
        	for(int row =0; row < rowSum.length ;row++) {
        		matrix[row][col] = Math.min(colSum[col], rowSum[row]);
        		rowSum[row] -= matrix[row][col];
        		colSum[col] -= matrix[row][col];
        		if(colSum[col] == 0) break;
            }
        }
        
        return matrix;
    }
}
