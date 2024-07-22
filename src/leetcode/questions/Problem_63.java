package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_63 {
	//https://leetcode.com/problems/unique-paths-ii/
	//create a data storre so we dont go down same paths again
    private int recursive (int[][] obstacleGrid, int row, int col, int count,Map<String, Integer>map){
        if(row == obstacleGrid.length || col == obstacleGrid[0].length 
        || obstacleGrid[row][col]==1) return count;
        if(row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1  ) return count+1;
        if(map.containsKey(row+":"+col)) return map.get(row+":"+col)+count;
        int nCount = recursive (obstacleGrid,  row+1,  col,  recursive (obstacleGrid,  row,  col+1,  count, map),map);
        map.put(row+":"+col, nCount-count);
        return nCount;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return recursive (obstacleGrid, 0,  0, 0, new HashMap<>());
    }
}
