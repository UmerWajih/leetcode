package leetcode.questions.x1200.to.x1299;

public class Problem_1219 {
	//https://leetcode.com/problems/path-with-maximum-gold/description/
	
//	Every time you are located in a cell you will collect all the gold in that cell.
//	From your position, you can walk one step to the left, right, up, or down.
//	You can't visit the same cell more than once.
//	Never visit a cell with 0 gold.
//	You can start and stop collecting gold from any position in the grid that has some gold.
	
	private static int recursion (int[][] grid, int row, int col,int sum) {
		if(col == -1 || row==-1 || col == grid[0].length || row == grid.length || grid[row][col]==0) return sum;
		int temp =grid[row][col];
		sum+=grid[row][col];
		grid[row][col]=0; //we have taken all the gold out, 0 so we dont come back here
		sum=Math.max(
				Math.max(
						Math.max(recursion (grid, row, col+1,sum), recursion (grid, row, col-1,sum))
						,recursion (grid, row+1, col,sum))
				,recursion (grid, row-1, col,sum));
		grid[row][col]=temp;//restore the value in grid
		return sum;
	}
	
	
	
	
	public static int getMaximumGold(int[][] grid) {
		int sum=0;
		for(int i=0; i<grid.length;i++) {
			for(int j=0;j<grid[0].length; j++) {
				if(grid[i][j]==0) continue;
				sum= Math.max(recursion (grid, i, j,0),sum);
			}
		}
		return sum;
    }
	

}
