package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Problem_57 {

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		// if intervals ==0 return new interval

		List<int[]> list = new ArrayList<>();
		if(intervals.length ==0) {
			list.add(newInterval);
			return list.toArray(new int[list.size()][]);
		}
		// intervals = [[1,5]], newInterval = [6,9]
		int j = 0;
		while ( j< intervals.length &&  intervals[j][1] < newInterval[0]) {
			list.add(intervals[j]);
			j++;
		}
		//here we have all intervals smaller than new interval
		
		while(j < intervals.length && intervals[j][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[j][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[j][1]);
            j++;
		}
		list.add(newInterval);
		//now add remaining intervals
		while (j < intervals.length) {
            list.add(intervals[j]);
            j++;
        }
		return list.toArray(new int[list.size()][]);
	}
}
