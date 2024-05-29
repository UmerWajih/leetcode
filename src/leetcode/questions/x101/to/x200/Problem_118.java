package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class Problem_118 {
	
	//5
	//[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
	//	size 1
	//	size 2
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<>();
		
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		output.add(list);
		if(numRows==1) return output;
		
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);list2.add(1);
		output.add(list2);
		if(numRows==2) return output;
		
		
		recursive(numRows, 2,output);
		return output;
    }
	
	
	// row count 2 or over here
	public static void recursive(int numRows, int row, List<List<Integer>>  output) {
		if(row == numRows) return;
		//[1,2,1] => needed
		
		Integer[] arr =new Integer[row+1];
		//[1,1]
		List<Integer> prev = output.get(row-1);
		int i=0, j = prev.size();
		while(i<=j) {
			arr[i]= i==0 ? 1 : prev.get(i-1)+ prev.get(i);
			arr[j]= i==0 ? 1 : prev.get(j)+ prev.get(j-1);
			i++; j--;
		}
		output.add(Arrays.asList(arr));
		recursive(numRows, row+1,  output);
		
		
		
		
		
	}
}
