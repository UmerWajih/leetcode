package leetcode.questions.x900.to.x999;

//https://leetcode.com/problems/minimum-cost-for-tickets/
public class Problem_983 {

	public static int mincostTickets(int[] days, int[] costs) {
		
//		int n = days.length;
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        
//        for (int i = 1; i <= n; i++) {
//            dp[i] = dp[i - 1] + costs[0]; // 1-day pass for current day
//            
//            int j = i - 1;
//            while (j >= 0 && days[i - 1] - days[j] < 7) j--;
//            dp[i] = Math.min(dp[i], dp[j + 1] + costs[1]); // 7-day pass for current day
//            
//            j = i - 1;
//            while (j >= 0 && days[i - 1] - days[j] < 30) j--;
//            dp[i] = Math.min(dp[i], dp[j + 1] + costs[2]); // 30-day pass for current day
//        }
//        
//        return dp[n];
//		
		
		
		return rec( days, costs, 0, 0, Integer.MAX_VALUE);
    }
	
	//days = [1,4,6,7,8,20], costs = [2,7,15]
	private static int rec(int[] days, int[] costs, int dIndex, int cost, int minCost) {
		if(dIndex == days.length) return Math.min(cost, minCost);
		if(cost>=minCost) return minCost;
		
		int day= days[dIndex];
		//check 1 day pass
		minCost= rec(days, costs, dIndex+1, cost+ costs[0], minCost);
		
		//check for 7 day pass
		int cDays=1;
		while (dIndex+cDays < days.length && days[dIndex+cDays] <= day+6) {
			cDays++;
		}
		minCost= rec(days, costs, dIndex+cDays, cost+ costs[1], minCost);
		
		//check for 7 day pass
		while (dIndex+cDays < days.length && days[dIndex+cDays] <= day+29) {
			cDays++;
		}
		minCost= rec(days, costs, dIndex+cDays, cost+ costs[2], minCost);
		
		return minCost;
	}
}
