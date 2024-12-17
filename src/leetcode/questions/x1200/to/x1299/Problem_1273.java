package leetcode.questions.x1200.to.x1299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/delete-tree-nodes/
public class Problem_1273 {
	public static int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        //create a hashmap
		//key will be node, value will be list of its childs
		Map <Integer, List<Integer>> map = new HashMap<>();
		for(int i=0; i< nodes; i++) {
			if(parent[i] == -1) {
				//root node
				map.put(0, new ArrayList<>());
				continue;
			}
			if(!map.containsKey(parent[i])) {
				map.put(parent[i], new ArrayList<>());
			}
			map.get(parent[i]).add(i);
			if(!map.containsKey(i))map.put(i, new ArrayList<>());
		}
		
		//now we need to do sum of each nodes
		if(getSum(0,  map, value, 0)==0)return 0; 
		return map.size();
    }
	
	
	private static int getSum(int node, Map <Integer, List<Integer>> map, int[] value, int sum) {
		if(map.get(node).size()==0) return value[node];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		int size = q.size();		
		sum+=value[node];
		for(int i=0; i< size; i++) {
			for(int j:  map.get(q.peek())) {
				int localSum=  getSum(j, map, value, 0);
				if(localSum == 0) {
					deleteNodes(j, map); 
				}
				sum+=localSum;
			}
			q.poll();
		}		
		return sum;
	}
	
	private static void deleteNodes(int node, Map <Integer, List<Integer>> map) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			int s =q.size();
			for(int i=0; i<s ;i++) {
				if(map.containsKey(q.peek()))q.addAll(map.get(q.peek()));
				map.remove(q.peek());
				q.poll();
			}
		}
	}
}
