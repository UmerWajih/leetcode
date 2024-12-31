package leetcode.questions.x300.to.x400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/evaluate-division/
public class Problem_399 {

	public static  double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //create a map
		//Key:string , value: relationship with weightage
		Map<String, Map<String, Double>> map = new HashMap<>();
		for(int i =0 ;i<values.length; i++) {
			List<String> eq = equations.get(i);
			if(!map.containsKey(eq.get(0))) {
				map.put(eq.get(0), new HashMap<>());
			}
			map.get(eq.get(0)).put(eq.get(1), values[i]);
			
			if(!map.containsKey(eq.get(1))) {
				map.put(eq.get(1), new HashMap<>());
			}
			map.get(eq.get(1)).put(eq.get(0), 1/values[i]);			
		}
		
		
		double [] output  =new double[queries.size()];
		int index=0;
		for(List<String> l : queries) {
			//if either is missing, invalid entry
			if(l.get(0).equalsIgnoreCase(l.get(1)) ||  
					!map.containsKey(l.get(0)) || 
					!map.containsKey(l.get(1))) {
				output[index] = -1;
				index++;
				continue;
			}
			
			//direct link
			Map<String, Double> pairs = map.get(l.get(0));
			if(pairs.containsKey(l.get(1))) {
				output[index] = pairs.get(l.get(1));
				index++;
				continue;
			}
			
			//indirect link
			//try bfs here
			Stack<Map<String, Double>> s = new Stack<>();
			s.add(pairs);
			output[index] = bfs(s, l.get(1), map) ;
			index++;
			
		}	
		return output;
    }
	
	private static double bfs(Stack<Map<String, Double>> s, String target,
			Map<String, Map<String, Double>> map) {
		
		
		Set<String> visited = new HashSet<>();
		while(!s.isEmpty()) {
			int size = s.size();
			for(int i =0 ;i< size; i++) {
				Map<String, Double> p = s.pop();
				if(p.containsKey(target)) {
					return p.get(target);
				}
				for(String k : p.keySet()) {
					if(visited.contains(k))continue;
					visited.add(k);
					
					Map<String, Double> pairs =  new HashMap<>(map.get(k));
					for(String t : pairs.keySet()) {
						pairs.put(t, pairs.get(t) * p.get(k));
					}					
					s.add(pairs);					
				}	
			}
		}
		
		return -1.0;
	}
	
//	private static double dfs(Map<String, Map<String, Double>> map , 
//			Map<String, Double> m, String target, double val) {
//		if(m.keySet().contains(target)) return m.get(target);
//		
//		
//		for(String str : m.keySet()) {
//			double temp = getValue(map, map.get(str), target,val);
//			if(temp != 0.0) {
//				val = temp * m.get(str);
//			}
//			if(val != 0.0) break;
//		}
//		
//		return val;
//	}
}
