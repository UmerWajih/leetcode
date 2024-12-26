package leetcode.questions.x300.to.x400;

//https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels
public class Problem_302 {

	public static int minArea(char[][] image, int x, int y) {
		// we need is starting point and ending point of x and y axis
		
		//to do it better than om
		
		//we know one of the pixels
		//so just go in all 4 directions
		//x is row, y is col
		
		int sCol=y, eCol=y;
		int sRow=x, eRow=x;
		
		for(int i=0; i<image.length;i++) {
			int start =0, end = image[0].length-1;
			while(start < y) {
				if (image[i][start] == '1') {
					sCol = Math.min(start, sCol);
					sRow= Math.min(i, sRow);
					eRow=Math.max(i, eRow);
					break;
				}
				start++;
			}
			while(end>= y) {
				if (image[i][end] == '1') {
					eCol = Math.max(end, eCol);
					sRow= Math.min(i, sRow);
					eRow=Math.max(i, eRow);
					break;
				}
				end--;
			}
		}
		
		int area = (eRow - sRow +1) * (eCol - sCol +1);
		return area;
    }
	
	//if we didnt have a pixel use this
//	int row =0;
//	int sRow=Integer.MAX_VALUE, eRow=Integer.MIN_VALUE, 
//			sCol = Integer.MAX_VALUE, eCol = Integer.MIN_VALUE;
//	while (row < image.length) {
//		for(int i=0; i<image[0].length; i++) {
//			if(image[row][i] == '1') {
//				//black region
//				int end= image[0].length-1;
//				while (end >= i) {
//					if(image[row][end] == '1') {
//						eCol = Math.max(eCol, end);
//						break;
//					}
//					end--;
//				}
//				sCol = Math.min(sCol, i);	
//				break;
//			}
// 		}
//		sRow = Math.min(sRow, row);
//		eRow= Math.max(eRow, row);
//		row++;
//	}
//	
//	int area = (sRow - eRow +1) * (eCol - sCol +1);
//	return area;
}
