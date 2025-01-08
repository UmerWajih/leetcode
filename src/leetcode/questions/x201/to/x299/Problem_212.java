package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_212 {

	public static List<String> findWords(char[][] board, String[] words) {
		//establish a map, starting char as key
		//using set as value as easier to remove
		Map<Character, Set<String>>map = new HashMap<>();
		List<String> output = new ArrayList<>();
		List<String> foundWords = new ArrayList<>();
		for(String s : words) {
			Set<String> set = map.getOrDefault(s.charAt(0), new HashSet<>());
			set.add(s);
			map.put(s.charAt(0), set);
		}
		
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				if(map.containsKey(board[row][col])) {
					for(String str : map.get(board[row][col])) {
						check(board, new int[board.length][board[0].length], 
								row, col,str, 0, foundWords );
					}
					output.addAll(foundWords);
					map.get(board[row][col]).removeAll(foundWords);			
					if(map.get(board[row][col]).isEmpty()) map.remove(board[row][col]);
					foundWords.clear();
				}
			}			
		}
		
		return output;
    }
	
	
	private static boolean check(char[][] board, int[][] visited, int row, 
			int col,String word, int wordIndex, List<String> output ) {
		if(row < 0 ||  row >= board.length || 
				col < 0 || col >= board[0].length || visited[row][col]==1)
			return false;
		
		
		
		if(board[row][col] != word.charAt(wordIndex)) {
			return false;
		}
		if( wordIndex+1 == word.length()) {
			//word has been found
			output.add(word);
			return true;
		}
		visited[row][col]=1;
		
		//look in all 4 direction
		if(check(board, visited, row+1, col, word, wordIndex+1,   output) ||
		check(board, visited, row-1, col, word, wordIndex+1, output) ||
		check(board, visited, row, col+1, word, wordIndex+1, output) ||
		check(board, visited, row, col-1, word, wordIndex+1, output)) {
			return true;
		}
		
		visited[row][col]=0;
		
		return false;
	}
}
