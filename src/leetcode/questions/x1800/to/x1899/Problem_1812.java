package leetcode.questions.x1800.to.x1899;

public class Problem_1812 {
	//https://leetcode.com/problems/determine-color-of-a-chessboard-square/
	public boolean squareIsWhite(String coordinates) {
        int [][]board = new int[][]{
            {0,1},{1,0}
        };
     if(board[(8 -(coordinates.charAt(1)-'0'))%2][ (coordinates.charAt(0)-'a')%2] == 0) return true;
        else return false;
    }
}
