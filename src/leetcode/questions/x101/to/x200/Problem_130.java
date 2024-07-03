package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_130 {

	//https://leetcode.com/problems/surrounded-regions
	
	//mark all visited points as '.'
	//if it is connected then return true
	//else return false
	//in case of true mark . as X
	//else mark . as 0
	private static boolean isConnected(char[][] board, int col, int row, Set<Integer[]> set) {
		//reached the end of the array
		if(col < 0 || col >=board[0].length || row < 0 || row >= board.length) return false;
		
		if(board[row][col] == 'O') {
			board[row][col] = '.'; //[1,2] = .
			set.add(new Integer[] {row,col});
			return isConnected(board,  col+1,  row,set) && isConnected(board,  col-1,  row,set)
						&& isConnected(board,  col,  row+1,set) &&  isConnected(board,  col,  row-1,set);
		}
		//it means that character here is X and is within bounds
		return true;
	}
	
	public static void solve(char[][] board) {
        Map<Set<Integer[]> , Boolean> map = new HashMap<>();	
		for(int i=0; i< board.length; i++) {
			for (int j=0; j<board[0].length ; j++) {
				if(board[i][j] == 'O') {
					Set<Integer[]> set = new HashSet<>();
					map.put(set, isConnected( board, j, i, set));
				}
			}
		}
		// now set the connected regions accordingly
		for (Set<Integer[]> set : map.keySet()) {
			if (map.get(set)) {
				for (Integer[] index : set) {
					board[index[0]][index[1]] = 'X';
				}
			} else {
				for (Integer[] index : set) {
					board[index[0]][index[1]] = 'O';
				}
			}
		}

	}
}
