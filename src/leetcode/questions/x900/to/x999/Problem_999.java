package leetcode.questions.x900.to.x999;

public class Problem_999 {
	//https://leetcode.com/problems/available-captures-for-rook/description/

	public int numRookCaptures(char[][] board) {
        //first find Rook
		int count =0;
		for(int i=0;i < board.length;i++) {
			for(int j=0; j< board[0].length; j++) {
				if(board[i][j]=='R') {
					//move all 4 ways to find max number of pawns you can strike
					int move =i-1;
					while(move>-1) {
						if(board[move][j] == 'p') {
							count ++;
							break;
						} 
						if(board[move][j] == 'B') {
							break;
						}
						move--;
					}
					move =i+1;
					while(move < board.length) {
						if(board[move][j] == 'p') {
							count ++;
							break;
						} 
						if(board[move][j] == 'B') {
							break;
						}
						move++;
					}
					move =j-1;
					while(move>-1) {
						if(board[i][move] == 'p') {
							count ++;
							break;
						} 
						if(board[i][move] == 'B') {
							break;
						}
						move--;
					}
					move =j+1;
					while(move < board[0].length) {
						if(board[i][move] == 'p') {
							count ++;
							break;
						} 
						if(board[i][move] == 'B') {
							break;
						}
						move++;
					}
					break;
				}
			}
		}
		
		return count;
    }

}
