package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/word-search/description/
public class Problem_79 {

	public static boolean exist(char[][] board, String word) {
		int c = word.charAt(0);
		boolean valid= false;
		
	outer:	for(int i=0; i< board.length; i++) {
			for(int j=0 ;j<board[0].length;j++) {
				if(board[i][j] == c) {
					//valid start point
					valid= rec ( board,word, i, j,0, valid, new HashSet<>());
					if(valid) break outer;
				}
			}
		}
		
		return valid;
    }

	private static boolean rec (char[][] board, String word, int row, int col, 
			int index, boolean valid, Set<String> set) {
		if(index == word.length()) return true; //word has been found
		
		if(row < 0 || row == board.length) return false; //over bound
		if(col < 0 || col == board[0].length) return false; //over bound
		
		
		if(board[row][col] == word.charAt(index)) {
			set.add(row+":"+col);
			index++; 
		}else {
			return false; //not a valid path
		}
		
		//look right
		int t = col + 1;
		if (!set.contains(row + ":" + t)) {
			valid = rec(board, word, row, col + 1, index, valid, set);
			if (valid)
				return true;
		}
		
		//look bottom
		t = row+1;
		if(!set.contains(t+":"+col)) {
			valid= rec (board,  word, row+1,  col, index,  valid, set);
			if(valid) return true;
		}
		
		//look top
		t = row-1;
		if(!set.contains(t+":"+col)) {
			valid= rec (board,  word, row-1,  col, index,  valid, set);
			if(valid) return true;
		}
		
		
		//look left
		t = col-1;
		if(!set.contains(row+":"+t)) {
			valid= rec (board,  word, row,  col-1, index,  valid, set);
			if(valid) return true;
		}
		
		
		
		return valid; //it should be false
	}

}
