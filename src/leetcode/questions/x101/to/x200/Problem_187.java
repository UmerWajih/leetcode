package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/repeated-dna-sequences
public class Problem_187 {

	public List<String> findRepeatedDnaSequences(String s) {
		//if s len < 10 return 0
		if(s.length() < 10) return new ArrayList<>();
		
		//create a hashmap
		Map<String, Integer> map = new HashMap<>();
		
		int start=0, end=10;
		while(end <= s.length()) {
			String a;
			if(end == s.length()) {
				a = s.substring(start);
			}else {
				a = s.substring(start,end);
			}
			
			map.put(a, map.getOrDefault(a, 0) +1);
			
			start++;
			end++;
		}
		List<String> list= map.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
		
		return  list; 
    }
}
