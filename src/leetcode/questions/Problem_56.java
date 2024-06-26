package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_56 {

	//https://leetcode.com/problems/merge-intervals
	
	public static int[][] merge(int[][] intervals) {
		if(intervals.length ==1) return intervals;
 		
 		//first sort the array to make it easier
 		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
 		
 		List<int[]> merged = new ArrayList<>();
        //start with first interval
 		int[] currentInterval = intervals[0];
 		
 		for (int i = 1; i < intervals.length; i++) {
 			//if current interval is greater than starting point of the next interval
 			// get max value of 2 endpoints and continue
            if (currentInterval[1] >= intervals[i][0]) { 
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
            	// interval is not overlapping
                merged.add(currentInterval);
                // new interval is now the current interval
                currentInterval = intervals[i];
            }
        }
 		merged.add(currentInterval); // Add the last interval

        return merged.toArray(new int[merged.size()][]);
    }
}
