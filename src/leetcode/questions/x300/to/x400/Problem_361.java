package leetcode.questions.x300.to.x400;

public class Problem_361 {
	public int maxKilledEnemies(char[][] grid) {
        //brute force approach
        //find an empty cell
        //get soldiers in row and col per cell
        
        int max=0;
        for(int i=0;i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='0'){
                    max= Math.max(max,getSoldiers(grid, i,j) );
                }
            }
        }
        return max;
    }
    
    private int getSoldiers(char[][] grid, int row, int col){
        int up =row-1;
        int count=0;
        while(up>=0){
            if(grid[up][col]=='E')count++;
            if(grid[up][col] == 'W')break;
            up--;
        }
        int down= row+1;
        while(down<grid.length){
            if(grid[down][col]=='E')count++;
            if(grid[down][col] == 'W')break;
            down++;
        }
        
        int left=col+1;
        while(left<grid[0].length){
            if(grid[row][left]=='E')count++;
            if(grid[row][left] == 'W')break;
            left++;
        }
        int right= col-1;
        while(right>=0){
            if(grid[row][right]=='E')count++;
            if(grid[row][right] == 'W')break;
            right--;
        }
        return count;
    }
}
