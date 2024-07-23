package leetcode.questions.x1700.to.x1799;

import java.util.Arrays;

public class Problem_1710 {
	//https://leetcode.com/problems/maximum-units-on-a-truck/description/
	public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x,y)-> y[1]-x[1]); 
        int units =0;
        for(int i=0; i< boxTypes.length; i++){
            int sum =truckSize -boxTypes[i][0];
            
            if(sum < 0 ){
                units+= truckSize * boxTypes[i][1];
                break;
            }
            truckSize -=boxTypes[i][0];
            units+= boxTypes[i][0] * boxTypes[i][1];
            
        }
        return units;
    }
}
