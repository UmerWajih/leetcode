package leetcode.questions.x101.to.x200;

public class Problem_121 {
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static int maxProfit(int[] prices) {
		//if len == 1 then you cant sell the price
        if(prices.length == 1) return 0;
        
        //keep track of minimum value
        int minimumVal=Integer.MAX_VALUE;
        int profit =0 ;
        for(int i=0 ; i< prices.length; i++) {
        	//if price >= min value output will be less or equal so continue
        	if (prices[i] >= minimumVal) continue;
        	minimumVal = prices[i];
        	for(int j=i+1 ; j< prices.length; j++) {
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        return profit;
    }
}
