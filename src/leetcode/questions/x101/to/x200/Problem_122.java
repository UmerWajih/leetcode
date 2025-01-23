package leetcode.questions.x101.to.x200;

public class Problem_122 {

	public static  int maxProfit(int[] prices) {
		return rec( prices, 0, 1, prices[0], 0, 0) ;
	}

	private static int rec(int[] prices,int max, int index, int buy, int profit, int tradeProfit) {

		if (index == prices.length) {
			return profit+tradeProfit;
		}
		if (index - 1 >= 0 && prices[index - 1] > prices[index]) {
			profit+=tradeProfit;
			tradeProfit=0;
			buy = prices[index];
		} else {
			tradeProfit = (prices[index] - buy);
		}
		return rec(prices,  max, index + 1, buy, profit, tradeProfit);
	}

}

