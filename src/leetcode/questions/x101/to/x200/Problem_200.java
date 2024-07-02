package leetcode.questions.x101.to.x200;

//https://leetcode.com/problems/number-of-islands
public class Problem_200 {

//	  ["1","1","0","0","1"] 
//	  ["1","1","0","0","0"]
//	  ["0","1","0","0","0"]
//	  ["0","0","0","1","1"]
	
	
	//if we get 1 set all points to of that island to .
	
	
	private static void recursive(char[][] grid, int col, int row) {
		if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] != '1') return ;
		//mark that point as visited
		grid[row][col] = '.';
		//recursively go around and marking out all points in the land to .
		recursive(grid, col, row+1);
		recursive(grid, col+1, row);
		recursive(grid, col-1, row);
		recursive(grid, col, row-1);	
	}
	public static int numIslands(char[][] grid) {
		int count =0 ;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					recursive(grid,j, i);
				}
			}
		}
        return count;
    }
}
