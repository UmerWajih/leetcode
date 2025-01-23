package leetcode.questions.x1900.to.x1999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem_1928 {

	public static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer, List<Integer>> paths =new HashMap<>();
        Map<String, Integer> time =new HashMap<>();
        
        for(int[] v : edges) {
        	if(!paths.containsKey(v[0]))paths.put(v[0], new ArrayList<>());
        	if(!paths.containsKey(v[1]))paths.put(v[1], new ArrayList<>());
        	
        	paths.get(v[0]).add(v[1]);
        	paths.get(v[1]).add(v[0]);
        	
        	time.put(v[0]+":"+v[1], v[2]);
        }
        
        
        int[] map = new int[passingFees.length];
        int[] t= new int[passingFees.length];
        
        Arrays.fill(map, Integer.MAX_VALUE);
        Arrays.fill(t, Integer.MAX_VALUE);
        map[0] = passingFees[0];
        t[0] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i=0; i <size; i++) {
        		int val= q.poll();
        		if(val == passingFees.length-1) return map[val];
        		set.add(val);
        		for(int v : paths.get(val)) {
        			if (set.contains(v))continue;
        			q.add(v);
        			t[v] = Math.min(t[v], t[val]+
        					(time.containsKey(val+":"+v) ?time.get(val+":"+v): time.get(v+":"+val)));
        			if(t[v]<=maxTime) map[v]=Math.min(map[v], map[val]+passingFees[v]) ;
        		}
        		//set.remove(val);
        	}
        	
        }
        
        
        
        
        return map[passingFees.length-1]==Integer.MAX_VALUE ?
        		-1 : map[passingFees.length-1];
        
//       	int val = rec(paths, time, maxTime, passingFees.length-1,0, 
//        		new int[passingFees.length], 0,passingFees[0], Integer.MAX_VALUE, passingFees) ;   
//       return	val == Integer.MAX_VALUE ? -1 : val;
    }
	
	
	private static int rec(Map<Integer, List<Integer>> paths, Map<String, Integer> time,
			int maxTime, int destination, int index, int[] track, int currentTime,
			int cost, int minCost, int[] passingFees) {

		if(currentTime > maxTime) {
			return minCost; //no need to check here
		} 
		if(index == destination) return Math.min(cost, minCost);
		track[index]=1;
		for(Integer i : paths.get(index)) {
			if(track[i]==1) continue;
			minCost= Math.min(minCost, rec(paths, time, maxTime, destination, i,  track, 
					currentTime+(time.containsKey(index+":"+i) ?time.get(index+":"+i): time.get(i+":"+index)),
					cost + passingFees[i], minCost, passingFees))	;
		}
		track[index]=0;
		return minCost;
	}
}
