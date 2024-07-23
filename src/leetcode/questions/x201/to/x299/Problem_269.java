package leetcode.questions.x201.to.x299;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Problem_269 {

	//https://leetcode.com/problems/alien-dictionary/description/
	public static String alienOrder(String[] words) {
        //one thing we can do is create map
		//map value will be list as we need to track indexes
		//map will have character and all characters greater than it
		//if we find a loop when mathcin values we return empty
		
		Map<Character, Set<Character>> map = new LinkedHashMap<>();
		for (int i=0; i< words.length ; i++) {
			for (int k =0; k < words[i].length(); k++) {
				char c = words[i].charAt(k); 
				map.putIfAbsent(c, new LinkedHashSet<>());
				
				for(int j=0; j<i; j++) {
					if(c!=words[j].charAt(0))map.get(words[j].charAt(0)).add(c);
				}
				
				
				if(k > 0) {
					//checking second word onwards is previos string matches
					int j=i+1; 
					while(j < words.length &&
							words[j].substring(0, k).equalsIgnoreCase(words[i].substring(0, k))) {
						if(words[j].length() > k) { //check needed so we dont overflow
							map.putIfAbsent(words[j].charAt(k), new LinkedHashSet<>());
							if(words[j-1].charAt(k) != words[j].charAt(k)) {
								map.get(words[j-1].charAt(k)).add(words[j].charAt(k));
							} 
						}
						j++;
					}
				}
			}
		}
		//"wrt","wrf","er","ett","rftt"
		//w < e < r < t <f 
		
		
		String str ="";
		//now we need to map values
		for(Character key: map.keySet()) {
			if(str.contains(String.valueOf(key)))continue;
			String val=recursive( map , key, "") ;
			if(val.equals("") && !map.get(key).isEmpty())return val;
			if(str.equals("")) {
				str=val;
				continue;
			}
			int i = str.length()-1, j=val.length()-1;
			while(i>=0 && j >= 0 && val.charAt(j)==str.charAt(i)) {
				i--; j--;
			}
			if(i==str.length()-1) {
				str+=val;
				continue;
			}
			str= str.substring(0,i+1) + val;
			System.out.println(str);
			
		};
		
		return str;
    }
	
	private static String recursive(Map<Character, Set<Character>> map , Character key, String str) {
		//map
		//{w=[r, f, e, t], r=[t], t=[f], f=[], e=[t, r, f]}
		str+=String.valueOf(key);
		
		for(Character c : map.get(key)) {
			if(map.get(c).contains(key)) return "";
			if(!str.contains(String.valueOf(c))) {
				//str = etf
				String val= recursive(map ,  c,  "");
				if(val.equalsIgnoreCase("") && !map.get(c).isEmpty())return "";
				//val = rtf
				int i = str.length()-1, j=val.length()-1;
				while(i>0 && j > 0 && val.charAt(j)==str.charAt(i)) {
					i--; j--;
				}
				str=(i > 0 ? str.substring(0,i) : String.valueOf(key) )+val;
			}
		}
		return str;
	}
	
//	public String alienOrder(String[] words) {
//        Map<Character, Integer> degree = new HashMap<>(); //contains set of map of all characters
//        Map<Character, Set<Character>> map = new HashMap<>();
//        for(int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words[i].length(); j++) {
//                degree.put(words[i].charAt(j), 0);
//            }
//        }
//
//        for(int i = 0; i < words.length-1; i++) {
//            String cur = words[i];
//            String next = words[i+1];
//            if (cur.length() > next.length() && cur .startsWith(next)) {
//                return "";
//            }
//            int len = Math.min(cur.length(), next.length());
//            for(int j = 0; j < len; j++) {
//                if (cur.charAt(j) != next.charAt(j)) {
//                    if (!map.containsKey(cur.charAt(j))) {
//                        map.put(cur.charAt(j), new HashSet<>());
//                    }
//                    if (map.get(cur.charAt(j)).add(next.charAt(j))) {
//                        degree.put(next.charAt(j), degree.get(next.charAt(j))+1);
//                    }
//                    break;
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        Queue<Character> q = new LinkedList<>();  //adding all characters whose reference points we dont know about
//        for(Character c : degree.keySet()) {
//            if (degree.get(c) == 0) {
//                q.offer(c);
//            }
//        }
//        while(!q.isEmpty()) {
//            Character c = q.poll();
//            git.append(c);
//            if (!map.containsKey(c)) {
//                continue;
//            }
//            
//            for(Character nei : map.get(c)) {
//                degree.put(nei, degree.get(nei)-1);
//                if (degree.get(nei) == 0) {
//                    q.offer(nei);
//                }
//            }
//        }
//
//        if (sb.toString().length() != degree.size()) {
//            return "";
//        }
//        return sb.toString();
//    }
}
