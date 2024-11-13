package leetcode.questions.x300.to.x400;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class Problem_323 {

	public int countComponents(int n, int[][] edges) {
        //initialize array of size n
		int [] arr = new int[n];
		//set parent of 2->1
		//set parent of 1->0
		int count=1, leftOvers=n;
		for(int i=0; i< edges.length; i++) {
			//check if parent of either one is present
			if(arr[edges[i][0]] == 0 && arr[edges[i][1]] == 0) {
				arr[edges[i][1]]=count;
				arr[edges[i][0]]=count;
				count++;
				leftOvers-=2;
				continue;
			}
			//they were 2 separate maps we need to fix them
			if(arr[edges[i][0]] != 0 && arr[edges[i][1]] != 0 && arr[edges[i][1]] != arr[edges[i][0]]) {
				int small = arr[edges[i][0]] < arr[edges[i][1]] ? arr[edges[i][0]] : arr[edges[i][1]];
				
				for (int k=0; k<n; k++) {
					if (arr[k] > small) {
						arr[k]= arr[k]-1;
					}
				}
				count--;
				continue;
			}
			
			
			if(arr[edges[i][0]] == 0) {
				arr[edges[i][0]]= arr[edges[i][1]];
				leftOvers--;
			}
			if(arr[edges[i][1]] == 0) {
				arr[edges[i][1]]= arr[edges[i][0]];
				leftOvers--;
			}
		}
		return count-1+leftOvers;
    }
}
