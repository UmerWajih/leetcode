package leetcode.questions.x101.to.x200;

public class Probelm_191 {

	//https://leetcode.com/problems/number-of-1-bits
	public int hammingWeight(int n) {
        int count =0;
        while(n!=0) {
        	//1011
        	//0001
        	//and condition for this will be 1 if the first bit is 1
        	//it will be 0 if the bit is 0
        	count += (n&1);
        	//move n 1 bit to the right
        	n=n >>> 1;
        }
        return count;
    }
}
