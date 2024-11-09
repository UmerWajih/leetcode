package leetcode.questions.x300.to.x400;

//https://leetcode.com/problems/range-addition/
public class Problem_370 {
	/*You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].

You have an array arr of length length with all zeros, and you have some operation to apply on arr. 
In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] 
by inci.

Return arr after applying all the updates.
	 * */
	
	public int[] getModifiedArray(int length, int[][] updates) {
		// length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
		//Output: [-2,0,3,5,3]
		// create arr of length 5
		int[] arr = new int[length];
		
		//start loop on updates
		for(int i=0; i<updates.length; i++) {
			for(int j =updates[i][0]; j<= updates[i][1];j++ ) {
				arr[j] = arr[j]+updates[i][2];
			}
		}
		return arr;
	}
}
