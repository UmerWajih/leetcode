package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_332 {
	public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> output= new ArrayList<>();
        for(List<String> l : tickets){
            if(!map.containsKey(l.get(0))) map.put(l.get(0), new PriorityQueue<>());
            map.get(l.get(0)).add(l.get(1));
        }
        //output list has to be of city.len
        
        get( map, "JFK", output);
        return output;
    }
    
    
    private static void get(Map<String, PriorityQueue<String>> map, String key, 
                     List<String>output){
    	PriorityQueue<String> arrivals = map.get(key);
        while (arrivals != null && !arrivals.isEmpty())
        	get(map,arrivals.poll(),output);
        output.add(key);
    }
    
}