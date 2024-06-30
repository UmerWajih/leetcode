package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_64 {

	//https://leetcode.com/problems/minimum-path-sum/
	
	
	//create 2 paths, get min of each
	//stating point is known, 0,0,
//	
//	[1,3,1]
//	[1,5,1]
//	[4,2,1]
	private static int recursive(int[][] grid, int column, int row, int sum, Map<String, Integer> map) {
		if(column == grid[0].length-1  && row == grid.length-1) return sum += grid[row][column];
		
		sum += grid[row][column];
		
		if(map.containsKey(row + ":"+ column)) return map.get(row + ":"+ column) +sum;
		
		int sum1 =Integer.MAX_VALUE, sum2 =Integer.MAX_VALUE;
		if(column+1 < grid[0].length) {
			sum1 =recursive(grid, column+1,  row, sum, map);
		}
		if(row +1 < grid.length) {
			sum2 =recursive(grid, column,  row+1, sum, map);
		}
		int val = Math.min(sum1, sum2);
		map.put(row + ":"+ column, val - sum);
		return val;
	}
	
	
	public static int minPathSum(int[][] grid) {
	 return recursive(grid,  0,  0,  0 ,new HashMap<>());
    }
}
