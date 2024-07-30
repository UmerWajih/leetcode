package leetcode.questions;

public class Problem_74 {
	//https://leetcode.com/problems/search-a-2d-matrix/description/
	public static boolean searchMatrix(int[][] matrix, int target) {
		 if (matrix == null || matrix.length == 0) {
             return false;
         }
        int rowSize=matrix[0].length-1;
        for (int i=0; i< matrix.length; i++){
            if(matrix[i][rowSize] >= target){
                 int lo= 0, hi = rowSize;
                    while(lo<=hi){
                        int mid = lo + ((hi-lo)/2);
                        if(matrix[i][mid] == target) return true;
                        if(matrix[i][mid] < target) lo = mid+1;
                        else  hi=mid-1;
                    }
                    return false; 
            }
        }
       
        return false;

    }
}
