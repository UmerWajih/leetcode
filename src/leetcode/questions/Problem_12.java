package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Problem_12 {
	//https://leetcode.com/problems/integer-to-roman/description/
	
	private static String conversion(int num, int mod) {
		Map< Integer, String> map = new HashMap<>();
        map.put(1, "I");map.put(5,"V");map.put(10, "X");
        map.put(50, "L");map.put(100,"C");map.put(500,"D");map.put(1000,"M");
	
        switch(num) {
	        case 1: return map.get(1*mod);
	        case 2:	return map.get(1*mod) + map.get(1*mod);
	        case 3: return map.get(1*mod) + map.get(1*mod) + map.get(1*mod);
	        case 4: return map.get(1*mod) + map.get(5*mod);
	        case 5: return map.get(5*mod);
	        case 6:	return map.get(5*mod) + map.get(1*mod);
	        case 7: return map.get(5*mod) + map.get(1*mod) + map.get(1*mod);
	        case 8: return map.get(5*mod) + map.get(1*mod) + map.get(1*mod) + map.get(1*mod);
	        case 9: return map.get(10*mod) + map.get(1*mod);
	        case 10: return map.get(10*(mod/10));
	        default: return "";
        }
        
        
	}
	
	
	public static String intToRoman(int num) {
        //666
		//6
		return conversion(num/1000, 1000) + conversion((num%1000)/100, 100)+ 
				conversion((num%100)/10, 10)+ conversion(num%10, 1);
    }
}
