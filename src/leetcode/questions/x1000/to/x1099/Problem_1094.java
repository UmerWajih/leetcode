package leetcode.questions.x1000.to.x1099;

import java.util.Arrays;

//https://leetcode.com/problems/car-pooling/
public class Problem_1094 {
	
	public boolean carPooling(int[][] trips, int capacity) {
		//its pretty simple
		//create a 2-d Array
		int [][] arr = new int[trips.length*2][2];
		int len=0;
		for(int i=0; i<trips.length; i++) {
			arr[len] = new int[] {trips[i][1], trips[i][0]};
			len++;
			arr[len] = new int[] {trips[i][2], -trips[i][0]};
			len++;
		}
		
		//sort arr on first index
		Arrays.sort(arr, (a, b) -> {
            int primaryComparison = Integer.compare(a[0], b[0]);
            return primaryComparison != 0 ? primaryComparison : Integer.compare(a[1], b[1]);
        });
		int sum=0;
		for(int i=0; i< arr.length;i++) {
			sum+=arr[i][1];
			if(sum> capacity) return false;
		}
		return true;
		
    }
}
