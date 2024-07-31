package leetcode.questions.x101.to.x200;

import java.math.MathContext;
import java.util.Arrays;

public class Problem_174 {

	//https://leetcode.com/problems/dungeon-game/
	
	//since we have to find the start point
	//start in reverse
	//we can now only move left and up
	
	private static int val=Integer.MIN_VALUE;
	private static int recursive(int[][] dungeon, int col, int row,  int cur) {
		if(col==-1 || row ==-1) return  cur;
		if(col==0 && row == 0) {
			cur += dungeon[row][col];
			if(cur < 0) {
				val = Math.max(val, cur);
				return val;
			} 
		}
		cur += dungeon[row][col];
		recursive(dungeon, col-1, row, cur);
		recursive(dungeon, col, row-1, cur);
		return val;
	}
	
//	public static int calculateMinimumHP(int[][] dungeon) {
//		val=Integer.MIN_VALUE;
//		int val =recursive(dungeon, dungeon[0].length-1, dungeon.length-1,  0);
//		//if val ==min val means minimum possible health we would never go into negative
//        return  val == Integer.MIN_VALUE ? Math.abs(dungeon[0][0])+1  : Math.abs(val)+1;
//    }
	
	private static int getValue(int[][] dummy, int row, int col) {
		if(row< 0 || row >= dummy.length || col < 0 || col >= dummy[0].length 
				|| dummy[row][col]==-1001) return 0;
		return dummy[row][col];
	}
	
	private static void recursive(int[][] dungeon, int [][] dummy, int row, int col) {
		if(row< 0 || row >= dungeon.length || col < 0 || col >= dungeon[0].length) return;
		int val3 = Math.min(getValue( dummy, row+1, col), getValue( dummy, row, col+1))  
				+ dungeon[row][col];
		if(dummy[row][col] == -1001) {
			dummy[row][col]= val3;
		}else {
			if(dummy[row][col] > 0 && val3 < 0)dummy[row][col]= val3;
			if(dummy[row][col] < 0 && val3 < 0)dummy[row][col] = Math.max(dummy[row][col], val3);
		}
		recursive(dungeon, dummy, row-1, col);
		recursive(dungeon, dummy, row, col-1);
	}
	
	
	public static int calculateMinimumHP(int[][] dungeon) {
		int [][] dummy =new int[dungeon.length][dungeon[0].length];
		for(int i=0; i<dungeon.length;i++) {
			for (int j=0; j<dungeon[0].length; j++) {
				dummy[i][j]=-1001;
			}
		}
		recursive(dungeon, dummy, dungeon.length-1, dungeon[0].length-1);
		return dummy[0][0] >= 0 ? 1 : Math.abs(dummy[0][0])+1;
    }
}

