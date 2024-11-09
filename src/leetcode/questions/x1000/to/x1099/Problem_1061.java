package leetcode.questions.x1000.to.x1099;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
public class Problem_1061 {

	
	private static void func(char a, char b, Map<Character, Character> map) {
		//
		
		//leetcode
		//programs
		if(a=='c' || b=='c') {
			System.nanoTime();
		}
		
		char min= a <= b ? a : b;
		//find min of a and b
		//check if map has this min and does not have a as key just assign it
		
		if(!map.containsKey(min) && !map.containsKey(a)) {
			map.put(a, min);
			return;
		}
		
		if(!map.containsKey(min)) {
			//find min value of map.containsKey(a) and min
			if(min < map.get(a)) {
				char oldKey = map.get(a);
				map.entrySet().stream().forEach(e -> {
						if(e.getValue()==oldKey) {
							map.put(e.getKey(), min);
						}
					});
				map.put(a, min);
			}
			//else no need to change
			return;
		}
		
		if(map.containsKey(min) && map.containsKey(a)) {
			if (map.get(min) < map.get(a)) {
				char oldKey = map.get(a);
				map.entrySet().stream().forEach(e -> {
					if(e.getValue()==oldKey) {
						map.put(e.getKey(), min);
					}
				});
				map.put(a, map.get(min));
			}
			return;
		}
		
		map.put(a, map.get(min));
		
	}
	public static String smallestEquivalentString(String s1, String s2, String baseStr) {
		//we need to find mappings
		//if map already contains char, check the min value
		
		Map<Character, Character> map = new HashMap<>();
		char [] arr = s1.toCharArray();
				
 		for (int i=0; i<arr.length ; i++) { 	 			
 			func(arr[i], s2.charAt(i),  map);
 			func(s2.charAt(i),arr[i],   map);
		}
 		
 		//here map contains minimum mapping for each char.
 		arr = baseStr.toCharArray();
 		
 		for (int i=0;i<arr.length;i++) {
 			char key =arr[i];
 			while(map.containsKey(key)) {
 				if(key == map.get(key)) break;
 				key = map.get(key);
 			}
 			
 			arr[i] = key;
 		}
 		
		return new String(arr);
    }

//	private int[] p;
//
//    public String smallestEquivalentString(String s1, String s2, String baseStr) {
//        p = new int[26];
//        for (int i = 0; i < 26; ++i) {
//            p[i] = i;
//        }
//        for (int i = 0; i < s1.length(); ++i) {
//            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
//            int pa = find(a), pb = find(b);
//            if (pa < pb) {
//                p[pb] = pa;
//            } else {
//                p[pa] = pb;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (char a : baseStr.toCharArray()) {
//            char b = (char) (find(a - 'a') + 'a');
//            sb.append(b);
//        }
//        return sb.toString();
//    }
//
//    private int find(int x) {
//        if (p[x] != x) {
//            p[x] = find(p[x]);
//        }
//        return p[x];
//    }
}
