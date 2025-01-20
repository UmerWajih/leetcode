package leetcode.questions.x2200.to.x2299;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_2246 {

	public static int longestPath(int[] parent, String s) {
		List<List<Integer>> list = new ArrayList<>(parent.length);
		for(int i=0; i< parent.length ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i< parent.length ; i++) {
			if(parent[i] == -1) continue;
			list.get(parent[i]).add(i);
			list.get(i).add(parent[i]);
		}
		int len=0;
		Set<Integer> set= new HashSet<>();
		for(int i=0; i< parent.length ; i++) {
			
			len= Math.max(len, 
					getLen(s.toCharArray(), ' ',i,list, 1, 0, set));
			
		}
		
		return len;
    }
	
	
	private static int getLen(char[] arr, char previous, 
			int index,List<List<Integer>> list, int cur, int max, Set<Integer> visited) {
		
		if(index == list.size()) return Math.max(cur, max);
		
		visited.add(index);
		for(int i: list.get(index) ){
			if(visited.contains(i) || arr[index] == arr[i] )continue;
			//visited.add(i);
			max =Math.max(max, getLen(arr, arr[index], i, list,  cur+1, max, visited));
			//visited.remove(i);
		}
		visited.remove(index);
		return Math.max(cur, max);
	}
	
}
