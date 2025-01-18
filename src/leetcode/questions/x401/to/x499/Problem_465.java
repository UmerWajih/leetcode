package leetcode.questions.x401.to.x499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_465 {
	
	
	//we only need to keep track of balances that are not 0
	public static int minTransfers(int[][] transactions) {
		Map<Integer,Integer> map = new HashMap<>();
		//map now has balances after all transactions in transactions
		//only data for users whose accounts are not balanced are stored
		for(int[] arr : transactions){
			map.put(arr[0], map.getOrDefault(arr[0], 0) - arr[2] );
			if(map.get(arr[0]) == 0) map.remove(arr[0]);
			map.put(arr[1], map.getOrDefault(arr[1], 0) + arr[2]);
			if(map.get(arr[1]) == 0) map.remove(arr[1]);
		}
		
		int[] balances = new int[map.size()];
		int index=0;
		for(int i : map.values()) {
			balances[index]=i;
			index++;
		}
		Arrays.sort(balances);
        return recursive(balances, 0, Integer.MAX_VALUE, 0);
    }
	
	private static int recursive(int[] balances, int index, int min, int number) {
		if(index >= balances.length) return Math.min(min, number); //we are assuming last person balances are alteady baalnced
		
        int val = balances[index];
        if(val == 0) return  recursive( balances, index+1, min, number); //this person has already been balanced
		for(int i= index+1; i< balances.length; i++) {
			if(val * balances[i] >=0) continue; //in this scenario either both have money or neither have money
			
			balances[i]+=val;
			min = recursive(balances, index+1,  min, number+1); //after trans with 1 person, now try with another
			balances[i]-=val;
		}
		return min;
	}

}
