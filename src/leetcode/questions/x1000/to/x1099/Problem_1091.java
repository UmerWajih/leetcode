package leetcode.questions.x1000.to.x1099;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class Problem_1091 {
	public static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m= grid[0].length;
		if(grid[0][0]==1 ||grid[n-1][m-1] ==1 ) return -1; //invalid 

         int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
		 while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                if (curPos[0] == n - 1 && curPos[1] == m - 1) {
                    return ans;
                }

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }
	
	
	//Was Learning  Bottom-Up So Solution for that
	public static int shortestPathBinaryMatrix2(int[][] grid) {
		//if either the starting point or end point is 1 return -1
		int n = grid.length;
		int m= grid[0].length;
		
		if(grid[0][0]==1 ||grid[n-1][m-1] ==1 ) return -1; //invalid 
		rec(grid,new int[n][m], n-1, m-1,0);
		//since we can go in all 8 direction, top down recursively will be too expensive ie stakc overflow.
		//start at the end, this way we will never go down the invalid path
		
		return grid[0][0] == 0 ? -1 : grid[0][0]; //0 would mean we never reached the start point
		
    }
	
	private static void rec(int[][] grid, int[][] visited,int row, int col, int val) {
		if(row < 0 || row==grid.length || col == grid[0].length || col < 0) {
			return;
		}
		grid[row][col]=val+1;
		visited[row][col]=1;
		//if a direction ==1 mark it as -1 => invalid
		//if a direction <= current size ignore, there is shorter way to get there
		//if its not then add visit that node
		
		
		if(row+1 < grid.length) {
			check(grid, visited,row+1, col, grid[row][col]);
			//check left and right on next row
			if(col+1 < grid[0].length) {
				check(grid,visited, row+1, col+1, grid[row][col]);
			}
			if(col-1 >=0) {
				check(grid, visited,row+1, col-1, grid[row][col]);
			}
		}
		if(row-1 >=0) {
			check(grid,visited, row-1, col, grid[row][col]);
			//check left and right on previous row
			if(col+1 < grid[0].length) {
				check(grid,visited, row-1, col+1, grid[row][col]);
			}
			if(col-1 >=0) {
				check(grid, visited,row-1, col-1, grid[row][col]);
			}
		}
		if(col+1 < grid[0].length) {
			check(grid,visited, row, col+1, grid[row][col]);
		}
		if(col-1 >=0) {
			check(grid, visited,row, col-1, grid[row][col]);
		}
		visited[row][col]=0;
	}
	
	private static void check(int[][] grid,int[][] visited, int row, int col, int val) {

		if(visited[row][col] == 1) {
			return;
		}
		
		//if it value is 1 or -1, either way this is an invalid path
		if (grid[row][col] ==1 || grid[row][col] ==-1 ) {
			grid[row][col]=-1;
			return;
		}
		//if value is 0 which means this path has not been visited -> go
		if(grid[row][col] == 0) {
			rec(grid, visited, row, col, val);
		}
		
		//if it isnt 0,1,-1 it means this a visited node, check if your current value+1 is less than that
		
		if (val+1 <=grid[row][col]) {
			rec(grid,visited,  row, col, val);
		}
		
		
	}
	
	
}
