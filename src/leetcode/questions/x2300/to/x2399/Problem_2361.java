package leetcode.questions.x2300.to.x2399;

import java.util.PriorityQueue;

public class Problem_2361 {

	public static long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        //return of long means tricky test cases
		//n min len of 1 means we can start
		long [] output = new long[regular.length];
		
		long[]reg=new long[regular.length+1];
		long[]exp=new long[regular.length+1];
		
		
		reg[0]=0;
		exp[0]=expressCost;
		
		
		
		for(int i=0; i<=regular.length; i++) {
			if(i!=0)output[i-1]= Math.min(reg[i], exp[i]);
			if(i==regular.length)continue;
			reg[i+1]=Math.min(reg[i]+regular[i], exp[i]+express[i]);
			exp[i+1]=Math.min(reg[i+1]+expressCost, exp[i]+express[i]);
		}
		
		return output;
    }
}
