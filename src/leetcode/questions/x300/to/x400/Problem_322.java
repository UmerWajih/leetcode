package leetcode.questions.x300.to.x400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/coin-change
public class Problem_322 {
	
	public static int coinChange(int[] coins, int amount) {
		//since coins.len > 0 and amount can be 0 return 0
        if(amount == 0) return 0;
		
		//sort the coins
		Arrays.sort(coins);
		int index= coins.length-1;
		while(index >= 0 && coins[index] > amount) {
			index--;
		}
		//coins we have are greater than amount, not possible
		if(index == -1) return -1;
		
		//here we have only valid coins. start solution here
		int min = rec(coins,  amount, 0, 0, Integer.MAX_VALUE,  index, new HashMap<>());
		return min == Integer.MAX_VALUE ? -1 : min;
    }
	//if we have sum at index x then we have checked this
	//since string is immutatable, we can use that as key, coins from that point onwards as diff.
	
	//coins = [1,2,5], amount = 11
	private static int rec(int[] coins, int amount, int sum, int coinCount, int minCount, int index, Map<String,Integer>map) {
		if(index == -1) return minCount;
		
		if(minCount <= coinCount) return minCount;
		
		if(sum > amount && index-1 >=0) {
			minCount = rec(coins,  amount, sum- coins[index] + coins[index-1] , 
					coinCount, minCount, index-1,map);
		}
		
		//if(map.containsKey(sum+":"+index)) return Math.min(minCount, coinCount+ map.get(sum+":"+index)); 
		if(sum == amount) return Math.min(minCount, coinCount);
		int count= minCount;
		if(sum + coins[index] <= amount) {
			minCount = rec(coins,  amount, sum+ coins[index] , coinCount+1, minCount, index, map);
			//map.put(sum+":"+index, minCount- count);
		}
		if(index-1 >=0) {
			minCount = rec(coins,  amount, sum+ coins[index-1] , coinCount+1, minCount, index-1,map);
			//map.put(sum+":"+index, minCount- count);
		}
		
		
		return minCount;
		
	}
	
	
}
