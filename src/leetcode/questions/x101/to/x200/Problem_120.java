package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Problem_120 {

	//so we are on current index
	//in the next row we'll go from index i and index i+1
	//we'll need sum value, minSum Value
	//minsum will only be calucluated at max index it size of an array
	
	
	//[[2],[3,4],[6,5,7],[4,1,8,3]]
	
	//store minimum value somewhere
	private static int sum(List<List<Integer>> array, int index,
			int arrIndex, int sum, Map<String, Integer> map) {
		if(index == array.size()) {
			return sum;
		} 
		if(map.containsKey(index+":"+arrIndex)) return sum + map.get(index+":"+arrIndex);
		int sum1= sum( array, index+1, arrIndex, (sum + array.get(index).get(arrIndex)), map);
		int sum2 =sum( array, index+1, arrIndex+1, (sum + array.get(index).get(arrIndex+1)), map);
		
		map.put(index+":"+arrIndex,   Math.min(sum1, sum2) - sum);
		return  Math.min(sum1, sum2);

	}
	
	

	
	
	public static int minimumTotal(List<List<Integer>>  array) {
		//return sum2( array,  1,  0,  array.get(0).get(0), Integer.MAX_VALUE, new HashMap<>());
		return sum( array,  1,  0,  array.get(0).get(0), new HashMap<>());
	}
}
