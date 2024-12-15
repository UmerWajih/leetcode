package leetcode.questions.x500.to.x599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/kill-process/
public class Problem_582 {

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		//create map and put child next to parents
		Map<Integer, List<Integer>> map = new HashMap<>();

		List<Integer> output =new ArrayList<>();
		for(int i=0; i< ppid.size(); i++) {
			if(ppid.get(i) == 0) continue;
			
			if(map.containsKey(ppid.get(i))) {
				map.get(ppid.get(i)).add(pid.get(i));
			}else {
				List<Integer> list =new ArrayList<>();
				list.add(pid.get(i));
				map.put(ppid.get(i), list);
			}
		}
		
		if(!map.containsKey(kill)) {
			//child node, no child of itself
			return Arrays.asList(kill);			
		}else {
			Queue<Integer> q = new LinkedList<>();
			q.add(kill);
			while (!q.isEmpty()) {
				int s =q.size();
				for(int i=0; i<s;i++) {
					output.add(q.peek());
					q.addAll(map.getOrDefault(q.poll(), new ArrayList<>()));
				}
			}
		}
		return output;
    }
}
