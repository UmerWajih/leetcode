package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/number-of-islands-ii
public class Problem_305 {

	// {0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}
	// 0,1,1
	// 4,0,2
	// 0,3,0
	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> list = new ArrayList<>();
		int land=0;
		//set would contain ids for lands
		Set<Integer> set = new HashSet<>();
		int[][] map = new int[m][n];		
		
		for(int i=0; i< positions.length; i++) {
			int row = positions[i][0];
			int col = positions[i][1];
			
			if(map[row][col] !=0) {
                list.add(set.size());
				continue;
			}
			
			//if we find a land in any of the 4 directions
			//we will select the minimum one
			Set<Integer> l = new HashSet<>();
			int sLand=0;
			//check left
			if(col-1 >= 0 && map[row][col-1] !=0) {
				l.add(map[row][col-1]);
				sLand = sLand == 0 ? map[row][col-1] : Math.min(map[row][col-1], sLand);
			}
			//check right
			if(col+1 < n && map[row][col+1] !=0) {
				l.add(map[row][col+1]);
				sLand = sLand == 0 ? map[row][col+1] : Math.min(map[row][col+1], sLand);
			}
			//check top
			if(row-1 >= 0 && map[row-1][col] !=0 ) {
				l.add(map[row-1][col]);
				sLand = sLand == 0 ? map[row-1][col] : Math.min(map[row-1][col], sLand);
			}
			//check bottom
			if(row+1 < m && map[row+1][col] !=0) {
				l.add(map[row+1][col]);
				sLand = sLand == 0 ? map[row+1][col] : Math.min(map[row+1][col], sLand);
			}
			if(l.isEmpty()) {
				land++;
				set.add(land);
				map[row][col]= land;
				list.add(set.size());
			}else {
				map[row][col]= sLand;
				l.remove(sLand);
				updateMap(map, sLand,l);
				set.removeAll(l);
				list.add(set.size());
			}
		}
		return list;
    }
	
	private static void updateMap(int[][] map, int land, Set<Integer> set) {
		
		for(int i=0; i<map.length ;i++) {
			for(int j=0; j<map[0].length ;j++) {
				if(set.contains(map[i][j])) {
					map[i][j] = land;
					continue;
				}
			}
		}
	}
	
}
