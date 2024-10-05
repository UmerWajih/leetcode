package leetcode.questions.x900.to.x999;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/
public class Problem_986 {

	//firstList = [[0,2],[5,10],[13,23],[24,25]], 
	//secondList =[[1,5],[8,12],[15,24],[25,26]]
	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //if either first list or second list is empty return
		if(firstList.length == 0 || secondList.length == 0) return new int[][] {};
		
		//will convert this into an array later
		List<Integer[]> list= new ArrayList<>();
		
		//since it is sorted we can check one by one
		//i represents first j represents second
		int i=0, j=0;
		//and condition bcz if one list ends no more intersections
		
		while (i < firstList.length && j<secondList.length ) {
			int [] arr1=  firstList[i]; //[0,2]
			int [] arr2=  secondList[j]; //[1,5]
			//output intersection
			Integer [] arr3= new Integer[2];
			
			//this means there is an intersection here
			if((arr1[1] > arr2[0] && arr1[1] <= arr2[1]) || arr1[1] == arr2[0]) {
				arr3[1] = arr1[1];
				//whatever is the max starting point
				arr3[0] = Math.max(arr2[0], arr1[0]);
				list.add(arr3);
				
				//increment list1
				i++;
				continue;
			}
			
			//try the same for arr2
			if((arr2[1] > arr1[0] && arr2[1] <= arr1[1]) || arr2[1] == arr1[0]) {
				arr3[1] = arr2[1];
				//whatever is the max starting point
				arr3[0] = Math.max(arr2[0], arr1[0]);
				list.add(arr3);
				//increment list2
				j++;
				continue;
			}
			if(arr1[1] < arr2[0]) {
				i++;
				continue;
			}
			if(arr2[1] < arr1[0]) {
				j++;
				continue;
			}
		}
		int k=0;
		int [][] output = new int[list.size()][];
		for(Integer[] l: list) {
			output[k] = new int[] {l[0], l[1]};
			k++;
		}
		
		return output;
    }
}
