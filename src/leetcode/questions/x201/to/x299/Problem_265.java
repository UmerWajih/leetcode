package leetcode.questions.x201.to.x299;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/paint-house-ii/description/
public class Problem_265 {

	public static  int minCostII(int[][] costs) {
        //row is house number
		//column is color
		//from each row select minumimun and proceed
		//this seems like greedy dynamic problem
		//from each row find the minimum from avialable columns
		//once cost > minimumCost return
		Set<Integer>availableCols =  new HashSet<>();
		for(int i=0; i< costs[0].length ; i++) {
			availableCols.add(i);
		}
		return rec(costs, 0, Integer.MAX_VALUE, 0,availableCols );
		
    }
	
	//[1,5,3]
	//[2,9,4]
	
	
	private static int rec(int[][] costs, int row, int min, int currentCost, Set<Integer>availableCols) {
		if(row== costs.length) {
			return Math.min(min, currentCost);	
		}
		
		
		for(int i=0; i< costs[0].length; i++) {
			if(!availableCols.contains(i)) continue; //this column already in use
			currentCost+=costs[row][i];
			
			if(currentCost >= min) {
				currentCost-=costs[row][i];
				continue;
			} 
			availableCols.remove(i); //cant select any more from this col
			min= rec( costs,  row+1, min,  currentCost, availableCols);
			currentCost-=costs[row][i];
			availableCols.add(i); //add this column again as it will be available for the next iteration
		}
		
		return min;
	}
}
