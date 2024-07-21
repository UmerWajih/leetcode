package leetcode.questions.x201.to.x299;

import java.util.Arrays;

public class Problem_253 {
	
	//https://leetcode.com/problems/meeting-rooms-ii/
	public static int minMeetingRooms(int[][] intervals) {
		//sort array from start time
		if(intervals.length==1)return 1;
		int [][] arr = new int[intervals.length * 2][2];
		//pair start time with 1
		//pair end time with -1
		for(int i=0; i<intervals.length; i++) {
			arr[i*2][0]=intervals[i][0];
			arr[i*2][1]=1;
			
			arr[(i*2) +1][0]=intervals[i][1];
			arr[(i*2) +1][1]=-1;
		}
		//sort based on time
		Arrays.sort(arr,  (x,y)->{
			if(x[0]==y[0])return x[1]-y[1];
			return x[0]-y[0];
		});
 		int count=0, maxCount=0;
 		for(int i=0; i<arr.length; i++) {
 			//this will give us the number of conference rooms in use
 			count+=arr[i][1];
 			//store max number of conference rooms in use
 			maxCount = Math.max(maxCount, count);
		}
 		
 		return maxCount;
    }
}
