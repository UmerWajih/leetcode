package leetcode.questions.x800.to.x899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Problem_815 {

	public static int numBusesToDestination(int[][] routes, int source, int target) {
        //Key: Route, Value: Buses going through the route
		Map<Integer, List<Integer>> map= new HashMap<>();
		
		
		//complexity for this mxn
		for(int i =0; i< routes.length; i++) {
			//i: bus number
			for(int j=0; j< routes[i].length;j++) {
				if(!map.containsKey(routes[i][j])) {
					map.put(routes[i][j], new ArrayList<>());
				}
				map.get(routes[i][j]).add(i);
			}
		}
		//source=1
		//target=6
		//routes = [[1,2,7],[3,6,7]]
//		map:{
//			1: {0},
//			2: {0},
//			7: {0,1},
//			3: {1},
//			6: {1},
//		}
		
		//Apply BFS
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		int count=0;
		
		//just so we dont go in cycles for the route
		Set<Integer> set = new HashSet<>();
		set.add(source);
		Set<Integer> buses = new HashSet<>();
		while(!stack.isEmpty()) {
			//check for buses in that go through the route
			int size = stack.size();
			count++;
			for (int s =0; s<size; s++) {
				for(int bus: map.get(stack.pop())) {
					if(buses.contains(bus)) {
						continue;
					}
					System.out.print("=>"+bus);
					buses.add(bus);
					//buses are available
					//check for routes for each bus
					for(int route : routes[bus]) {
						
						//if route == target
						if(route == target) {
							return count;
						}
						if(!set.contains(route)) {
							set.add(route);
							stack.add(route);
						}
					}
				}
				System.out.println();
			}
		}
		
		//if min is 0 then return -1 else min
		return  -1;
    }
}
