package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_6 {

	//https://leetcode.com/problems/zigzag-conversion/description/
	// create a map : key will be row
	// increment row count till row == numRows
	// then decrement rowcount till row == 1.
	// add on each iteration against the rowNum
	public static String convert(String s, int numRows) {
		if(numRows==1)return s;
		char [] a = s.toCharArray();
		int rowNum=1;
		boolean addRows=true;
		HashMap<Integer, List<Character>> map =new HashMap<>();
		for(char c : a) {
			if(!map.containsKey(rowNum)) map.put(rowNum, new ArrayList<Character>());
			map.get(rowNum).add(c);
			if(rowNum == numRows) {addRows = false;}
			if(!addRows) {rowNum--;}else {rowNum++;}
			if(rowNum == 1) {addRows=true;}
		}
		StringBuilder stringBuilder = new StringBuilder();
		map.values().forEach(val -> val.forEach(t->stringBuilder.append(t)));
		return stringBuilder.toString();
		
    }
}
