package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.Map;

public class Problem_123 {

	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
	
	
	//start at index i
	//if the value next to it is lower move start point
	//keep track of all possible profits
	//profit index 0 is start 1 is end
	
	
	private static boolean indexExists(int index, Map<Integer[], Integer> profit) {
		for(Integer[] vals : profit.keySet()) {
			if(vals[0] == index) return true;
		}
		return false;
	}
	//this recursive function should get all possible profitable transactions
	private static void recursive(int[] prices, int index, Map<Integer[], Integer> profit) {
		if (index == prices.length) return;
		//if we have transactions from the current index already calculated the move forward
		if (indexExists( index, profit)) return;
		
		int start=index;
		Map<Integer[], Integer> profitFromIndex = new HashMap<>();
		for(int i= index; i < prices.length; i++) {
			if(prices[i] <= prices[start] && profitFromIndex.isEmpty()) {
				start = i;
				continue;
			}
			if(prices[i] > prices[start]) {
				profitFromIndex.put(new Integer[] {start, i}, prices[i] - prices[start]);
			}
		}
		profit.putAll(profitFromIndex);
		for(Integer[] vals : profitFromIndex.keySet()) {
			recursive(prices, vals[1]+1,  profit);
		}
		
	}
	
	private static int check(Map<Integer[], Integer> profit, Integer[]transaction, int transactionProfit) {
		int maxSum = transactionProfit;
		for (Integer[] val : profit.keySet()) {
			
			if(val[0] == transaction[0] && val[1] == transaction[1])continue;
			if(val[0] > transaction [1] && transactionProfit + profit.get(val) > maxSum) {
				maxSum = transactionProfit + profit.get(val);
			}
		}
		return maxSum;
	}
	private static int getMaxProfits(Map<Integer[], Integer> profit) {
		//if key [start] > key[end] 
		int maxSum=0;
		for (Integer[] val : profit.keySet()) {
			maxSum = Math.max(check( profit, val,profit.get(val)), maxSum);
		}
		return maxSum;
	}
	
	
	public static int maxProfit(int[] prices) {
		Map<Integer[], Integer> profit = new HashMap<>();
		recursive(prices, 0, profit); 
//		for (Integer[] val : profit.keySet()) {
//			System.out.println("Key:"+ val[0]+","+val[1]+"  : Value :  "+profit.get(val));
//		}
		return getMaxProfits(profit);
    }
}
