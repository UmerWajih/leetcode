package leetcode.questions.x401.to.x499;

import java.util.Arrays;

public class Problem_452 {

	
	//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
public int findMinArrowShots(int[][] points) {
	
        Arrays.sort(points, (x1,x2) -> Integer.compare(x1[1] , x2[1]));
        int count =1;
        int[] current = points[0];
        for(int i=1; i< points.length; i++) {
        	if(current[1] >= points[i][0]) {
        		continue;
        	}
        	count++;
        	current = points[i];
        }

        return count;
		}
}
