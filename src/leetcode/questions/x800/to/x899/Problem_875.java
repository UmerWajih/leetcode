package leetcode.questions.x800.to.x899;

import java.util.Arrays;

public class Problem_875 {
	//https://leetcode.com/problems/koko-eating-bananas
	public static int minEatingSpeed(int[] piles, int h) {
        //pile[i] =>number of bananas in the pile
        //h => number of hours koko have
        //k=> number of bananas she can eat
        //if pile has less than k bananas she will eat who bunch but wont pick
        //from another pile

        //sort the array
        Arrays.sort(piles);
        //if the size of pile == h return max number
      //  if(piles.length == h) return piles[h-1];
        int low=1, high = 1000000000;
        int k=Integer.MAX_VALUE;
        while(low<=high) {
        	int middle =(int) Math.ceil(low + ((high-low)/2.0));
        	
        	int count=0;
        	for (int i : piles) {
        		if(i%middle !=0) count++;
        		count += (i/middle);
        		if (count > h) {
                    low = middle + 1; // increase low when count is greater than h
                }
        	}
        	if(count<=h){
        		k=Math.min(middle, k);
        		if(high==middle) {
        			high-=1;
        			continue;
        		}
        		high=middle;
        	}
        }
        return k;
    }
}
