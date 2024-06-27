package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Problem_54 {

	//https://leetcode.com/problems/spiral-matrix/
	
	// store starting point of col
	// store starting point of row
	public static List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> list = new ArrayList<>();
		int left=0, right = matrix[0].length, top=0, bottom = matrix.length;
		int movement=1;
		//movement right: 1, bottom: 2, left:3, up:4
		while(top!=bottom && left!=right) {
			switch(movement) {
				case 1:{
					for(int i=left; i<right; i++) {
						list.add(matrix[left][i]);
					}
					top++;
					movement=2;
					break;
				}
				case 2:{
					for(int i=top; i<bottom; i++) {
						list.add(matrix[i][right-1]);
					}
					right--;
					movement=3;
					break;
				}
				case 3:{
					for(int i=right-1; i>=left; i--) {
						list.add(matrix[bottom-1][i]);
					}
					bottom--;
					movement=4;
					break;
				}
				case 4:{
					for(int i=bottom-1; i>=top; i--) {
						list.add(matrix[i][left]);
					}
					left++;
					movement=1;
					break;
				}
			}
		}
		return list;
		
    }
}
