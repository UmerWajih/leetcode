package leetcode.questions.x201.to.x299;

import java.util.HashSet;
import java.util.Set;

public class Problem_202 {
	private static boolean recursive(int n, Set<Integer> set) {
		if (set.contains(n))return false;
		int output = 0, input =n ;
		while (n > 9) {
			output += Math.pow(n % 10, 2);
			n = n/ 10;
		}
		output += Math.pow(n % 10, 2);
		if (output == 1)return true;
		set.add(input);
		return recursive(output, set);
	}

	public static  boolean isHappy(int n) {
		return recursive(n, new HashSet<Integer>());
	}
}
