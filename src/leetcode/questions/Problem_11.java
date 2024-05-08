package leetcode.questions;

public class Problem_11 {
	//https://leetcode.com/problems/container-with-most-water/description/
	public static int maxArea(int[] height) {
     int i =0, j = height.length-1 , vol=0, maxVol=0;
     
     while (i<j) {
    	 if(height[i] > height[j]) {
    		 vol = height[j] * (j-i);
    		 j--;
    	 }else {
    		 vol=  height[i] * (j-i);
    		 i++;
    		 
    	 }
    	 if(vol> maxVol) {maxVol=vol;}
     }
     
     return maxVol;
    }
}
