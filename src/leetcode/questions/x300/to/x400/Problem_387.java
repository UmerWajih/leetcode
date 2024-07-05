package leetcode.questions.x300.to.x400;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Problem_387 {

	// https://leetcode.com/problems/first-unique-character-in-a-string/
	public int firstUniqChar(String s) {
		Set<Character> set = new HashSet<>();
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i]))
				continue;
			if (map.containsKey(arr[i])) {
				map.remove(arr[i]);
				set.add(arr[i]);
			} else {
				map.put(arr[i], i);
			}
		}

		for (Character c : map.keySet()) {
			return map.get(c);
		}

		return -1;
	}
}
