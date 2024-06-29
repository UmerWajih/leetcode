package leetcode.questions;

public class Problem_70 {

	//https://leetcode.com/problems/climbing-stairs
	
	//this is fibonacci
	public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
		int val1=1, val2=2, val3=0;
		
		for(int i=3; i<=n ; i++) {
			val3= val1+val2;
			val1=val2;
			val2=val3;
		} 
		
		return val3;
    }
}
