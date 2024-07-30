package leetcode.questions.x300.to.x400;

public class Problem_378 {
	//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
	//solution 1: simply put everything in a priority queue then fetch the kth element
	//solution 2: binary search -> more difficult so lets try this
	public int kthSmallest(int[][] matrix, int k) {
		 int lo = matrix[0][0] , hi = matrix[matrix.length-1][matrix[0].length-1];
	        //min value is at the first element
	        //max value is at the last elemet
	        
	        //classic low high loop
	       
	        
	        while(lo < hi) {
	            int count=0;
	        	int mid = lo + ((hi-lo)/2);
	        	 int rowSize= matrix[0].length-1;
	        	//now mid index
	        	for(int i=0; i< matrix.length ; i++) {
	        		//try and find middle value
	        		
	        		while(rowSize>=0 && matrix[i][rowSize]>mid)rowSize--;
	        		//if it is greater than mid value, all elements of that row are < mid so add them
	        		count+=(rowSize+1);
	        	}
	        	//if middle value is not way too big for kth element
	        	if(count >= k)hi=mid;
	        	else lo=mid+1;
	        }
	        
	        
	        return lo;
    }
}
