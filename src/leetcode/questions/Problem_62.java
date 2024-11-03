package leetcode.questions;

//https://leetcode.com/problems/unique-paths/
public class Problem_62 {

	private static int rec(int row, int col, int m, int n, int output) {
		
		if(row == m-1 && col == n-1) return output+1;
		if(row < m-1) output= rec(row+1, col, m, n,output);
		if(col < n-1) output= rec(row, col+1, m, n,output);
		
		return output;
		
	}
	
	 public static int uniquePaths(int m, int n) {
		 return rec(0, 0, m, n,0);
	 }
}
