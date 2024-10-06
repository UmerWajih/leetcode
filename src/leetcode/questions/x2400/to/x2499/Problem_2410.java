package leetcode.questions.x2400.to.x2499;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
public class Problem_2410 {
	
	
	public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
		//sort both arrays
		Arrays.sort(players);
		Arrays.sort(trainers);
		
		//index i => player j=> trainer
		int i=0 ,j=0;
		int count =0;
		//&& because once one runs out is over
		while(i < players.length && j < trainers.length) {
			//we have a match
			if(players[i] <= trainers[j]) {
				i++;
				j++;
				count++;
			}else {
				//increase level of trainer
				j++;
			}
			
			
		}
		
		return count;
    }
}
