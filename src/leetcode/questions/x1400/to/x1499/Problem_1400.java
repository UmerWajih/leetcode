package leetcode.questions.x1400.to.x1499;

import java.util.HashMap;
import java.util.Map;

public class Problem_1400 {
	 public boolean canConstruct(String s, int k) {
	        if(s.length() < k)return false;
	        
	        Map<Character, Integer> map = new HashMap<>();
	        
	        char[] arr= s.toCharArray();
	        
	        for(char c: arr){
	            map.put(c, map.getOrDefault(c,0)+1);
	        }
	        
	        
	        //if odd count > k false
	        int oddCount=0;
	        
	        for(Character c: map.keySet()){
	            if(map.get(c) % 2==1){
	                oddCount++;
	                if(oddCount > k)return false;
	            }
	        }
	        
	        return true;
	    }
}
