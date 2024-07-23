package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_210 {
	//https://leetcode.com/problems/course-schedule-ii/description/
	
	private static boolean recursive(Map<Integer, Set<Integer>> map, int course, 
			List<Integer> list, Set<Integer> set) {
		if(set.contains(course)) {
			list.clear();
			return false;
		} 
		set.add(course);
		if(map.get(course).isEmpty()) {
			if(!list.contains(course)) list.add(course);
			set.remove(course);
			return true;
		}
		
		for(int i : map.get(course)) {
			if(!recursive(map, i, list, set)) {
				return false;
			}
		}
		//remove all its dependencies
		map.get(course).clear();
		//add course
		if(!list.contains(course)) {
			list.add(course);
			set.remove(course);
		}
		return true;
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses; i++) {
        	map.put(i, new HashSet<>());
        }
        
        for(int i=0; i<prerequisites.length; i++) {
        	map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List <Integer> list= new ArrayList<>();
        for(int i =0; i<numCourses ;i++) {
        	if(!recursive(map,  i, list,new HashSet<>())) {
        		break;
        	}
        }
        int[] array =  new int[list.size()];
        for(int i=0;i<list.size();i++) {
        	array[i]=list.get(i);
        }
        return array;
    }
}
