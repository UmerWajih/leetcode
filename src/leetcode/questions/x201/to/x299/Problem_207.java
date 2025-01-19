package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem_207 {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		int[] d = new int[numCourses];
		List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
        	//if a course is a pre req add course dependant on it
            adj.get(prerequisite[1]).add(prerequisite[0]);
            d[prerequisite[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(d[i] == 0)q.offer(i); //courses that arent dependendant on any couses
        }
        int visited=0;
        
        while(!q.isEmpty()) {
        	int course = q.poll();
        	visited++;
        	for(int i : adj.get(course)) {
        		d[i]--;
                if (d[i] == 0) {
                    q.offer(i);
                }
        	}
        }
		
		return visited==numCourses;
    }
	
	
	
	
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		//Map stores values of all pre reqs
		Map<Integer, List<Integer>> map = new HashMap<>();
		//only courses with dependencies need to be studied
		for(int[] req : prerequisites) {
			if(!map.containsKey(req[0]))map.put(req[0], new ArrayList<>());
			map.get(req[0]).add(req[1]);
		}
		
		for(int i: map.keySet()) {
			if(!isValid( map, i, new HashSet<>()))return false;
		}
			
		return true;
    }
	public static boolean isValid(Map<Integer, List<Integer>> map, int course, Set<Integer>trail) {
		if(!map.containsKey(course)) {
			return true;
		}
		if(trail.contains(course)) return false;
		trail.add(course);
		for(int i : map.get(course)) {
			if(!isValid( map, i, trail))return false;
		}
		trail.remove(course);
		return true;
	}
	
}
