package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem_310 {
	//https://leetcode.com/problems/minimum-height-trees/
	public static  List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>>map = new HashMap<>();
		for(int i=0;i<n;i++) {
        	map.put(i, new HashSet<>());
        }
		for(int i=0; i<edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
    	}
		Map<Integer, List<Integer>> output = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for(Integer key : map.keySet()) {
			set.add(key);
			int size =recursive(map,  key,  set, 0);
			set.remove(key);
			if(!output.containsKey(size)) {
				output.put(size, new ArrayList<>());
			}
			output.get(size).add(key);
		}
		PriorityQueue<Integer> q= new PriorityQueue<>(output.keySet());
		return output.get(q.poll()) ;
	}
	private static int recursive(Map<Integer, Set<Integer>>map, Integer key, Set<Integer> node, int size) {
		int len=size;
		for(Integer k : map.get(key)) {
			//if(size==0)len=size;
			if(node.contains(k))continue;
			node.add(k);
			len =Math.max(recursive(map, k,  node,  size+1), len) ; 
			node.remove(k);
		}
		return len;
	}
}
