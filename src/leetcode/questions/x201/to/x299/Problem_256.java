package leetcode.questions.x201.to.x299;

//https://leetcode.com/problems/paint-house/description/
public class Problem_256 {
	//no two houses can have same color
    //col is color
    //row  is house number
	
	
	
	private static int rec(int[][] costs, int [] color, int houseNumber, int cost, int minCost ) {
		if(cost >=minCost) return minCost; //no need to check ahead
		
		if(houseNumber == costs.length) return Math.min(minCost, cost); //we have reached the end for tha
	
		//only have 3 cols so...
		for(int i=0; i<3; i++) {
			if(houseNumber != 0 && color[houseNumber-1] == i+1) continue;
			color[houseNumber]=i+1;
			minCost= rec(costs, color,houseNumber+1, cost+costs[houseNumber][i], minCost) ;
			color[houseNumber]=0;
		}
		return minCost;
	}
	
	
	public static int minCostRec(int[][] costs) {
		//create an array to indicate color set for each house
		int [] color = new int [costs.length];
		
		return rec(costs, color, 0, 0, Integer.MAX_VALUE);
    }
	
	public static int minCost(int[][] costs) {
		//costs min len =1
		for(int i=1; i<costs.length ; i++) {
			costs[i-1][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i-1][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i-1][2] += Math.min(costs[i-1][1], costs[i-1][0]);
		}
		int l = costs.length-1;
		return Math.min(Math.min(costs[l][0], costs[l][1]), costs[l][2]);
	
    }
}
