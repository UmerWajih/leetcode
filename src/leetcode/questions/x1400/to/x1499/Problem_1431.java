package leetcode.questions.x1400.to.x1499;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
public class Problem_1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = Integer.MIN_VALUE;
		for (int i : candies) {
			max = Math.max(i, max);
		}
		List<Boolean> list = new ArrayList<>();
		for(int i : candies) {
			if(i+extraCandies >= max) {
				list.add(true);
			}else {
				list.add(false);
			}
		}
		return list;		
	}
}
