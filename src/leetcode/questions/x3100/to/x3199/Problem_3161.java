package leetcode.questions.x3100.to.x3199;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem_3161 {
	//anywhere on the line means both sides of the block
	
	public static List<Boolean> getResults(int[][] queries) {
		TreeSet <Integer> set = new TreeSet <>();
		List<Boolean> list = new ArrayList<>();
		for(int i=0; i< queries.length; i++) {
			//add an obstacle
			if(queries[i][0] == 1) set.add(queries[i][1]);
			else {
				if(set.isEmpty()) {
					list.add(true);
					continue;
				}
				
				int target = queries[i][1];
				int size = queries[i][2];
				
				if(size>target) {
					list.add(false);
					continue;
				}
				
				int start=0;
				boolean valid= false;
				for(int k: set) {
					if(k>target)break;
					if(k-start >= size) {
						valid = true;
						break;
					}else {
						start =k;
					}
				}
				
				if(!valid && target-start >= size) {
					valid = true;
				}
				
				list.add(valid);
			}
		}
		return list;
    }
}
