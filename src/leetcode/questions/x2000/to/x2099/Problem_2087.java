package leetcode.questions.x2000.to.x2099;

//https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/
public class Problem_2087 {

	public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		//our matrix is actually just start point to end point
		//any cols up and down dont need to be looked into
		
		int[][] matrix = new int[rowCosts.length][colCosts.length];
		
		int startRow = Math.min(homePos[0], startPos[0]);
		int endRow = Math.max(homePos[0], startPos[0]);
		
		int startCol = Math.min(homePos[1], startPos[1]);
		int endCol = Math.max(homePos[1], startPos[1]);
		
		if(endRow == startRow && startCol== endCol) {
			return 0; //no cost
		}
		
		//if house is before robot cost will the same
		//also due to cost we are only moving in 2 directions instead of 4
		
		for(int i = startRow; i< endRow+1; i++) {
			for(int j = startCol; j< endCol+1; j++) {
				//now just need to fetch costs and update matrix
				if(i-1 < startRow && j-1 < startCol) {
					continue; //start point
				}
				
				
				if(i-1 < startRow) {
					//if cant come from row just take col
					matrix[i][j] = colCosts[j] + matrix[i][j-1];
				}else if(j == startCol) {
					//if cant come from col just take row
					matrix[i][j] = rowCosts[i] + matrix[i-1][j];
				}else {
					//take either row cost or col cost
					matrix[i][j] = Math.min(colCosts[j] + matrix[i][j-1],
							rowCosts[i] + matrix[i-1][j]);
				}
			}
		}
		return matrix[endRow][endCol];
    }
}
