package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_36 {

	//KEEP TRACK OF ITEMS IN A ROW
	//KEEP TRACK OF ITEMS IN A COLUMN
	//KEEP TRACK OF ITEMS IN A 3X3 VOX
	
	public static boolean isValidSudoku(char[][] board) {
		Map<Integer, List<Character>> row = new HashMap<>();
		for (int i=0; i< 9; i++) {
			row.put(i, new ArrayList<>());
		}
		Map<Integer, List<Character>> column = new HashMap<>();
		for (int i=0; i< 9; i++) {
			column.put(i, new ArrayList<>());
		}
		Map<Integer, List<Character>> box = new HashMap<>();
		for (int i=0; i< 9; i++) {
			box.put(i, new ArrayList<>());
		}
		
		for(int rowC=0; rowC<9; rowC++) {
			for(int colC=0; colC<9; colC++) {
				if(board[rowC][colC] != '.') {
					if(row.get(rowC).contains(board[rowC][colC])) return false;
					else row.get(rowC).add(board[rowC][colC]);
					
					if(column.get(colC).contains(board[rowC][colC])) return false;
					else column.get(colC).add(board[rowC][colC]);
					
					int boxNo = ((rowC/3)*3) + colC/3;
					if(box.get(boxNo).contains(board[rowC][colC])) return false;
					else box.get(boxNo).add(board[rowC][colC]);
					
					
				}				
			}
		}
		return true;
		
    }
}
