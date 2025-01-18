package leetcode.questions.x800.to.x899;

import java.util.HashMap;
import java.util.Map;

public class Problem_860 {

	public boolean lemonadeChange(int[] bills) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(5, 0);map.put(10, 0);map.put(20, 0);
		
		for(int i: bills) {
			if(i == 5) {
				map.put(5, map.get(5)+1);
				continue;
			}
			if(i == 10) {
				if(map.get(5) == 0) return false;
				map.put(5, map.get(5)-1);
				map.put(10, map.get(10)+1);
				continue;
			}
			if(i == 20) {
				//here check for 2 cases
				if(map.get(10)>=1 && map.get(5) >=1) {
					map.put(5, map.get(5)-1);
					map.put(10, map.get(10)-1);
				}else if(map.get(5) >=3){
					map.put(5, map.get(5)-3);
				}else {
					return false;
				}
			}
		}
		
		return true;
    }
}
