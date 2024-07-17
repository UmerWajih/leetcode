package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.questions.Common.TreeNode;

public class Problem_314 {
	//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
	
	//when you go left -1 from column, when go right add one to the column
	//keep track of min and max
	//start point is 0
	//apparently you can use TreeMap instead of Hashmap
	private static int recursive(TreeNode node, int min,int col,  Map<Integer,List<Integer> > map) {
		if(node == null) return min; 
		if(col < min) min = col;
		
		if(!map.containsKey(col))  map.put(col, new ArrayList<>());
		
		map.get(col).add(node.val);
		min = recursive(node.left, min, col -1,  map);
		recursive(node.right, min, col +1,  map);
		return min;
	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		Map<Integer,List<Integer> > map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
        int min =recursive(root, 0, 0,  map) ;
		while(map.containsKey(min)) {
			list.add(map.get(min));
			min++;
		}
		return list;
    }
}
