package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.List;

import leetcode.questions.Common.TreeNode;

public class Problem_199 {
	//https://leetcode.com/problems/binary-tree-right-side-view/description/
	private static int recursive (TreeNode root, int level, int maxLevel, List<Integer>list) {
		if (root==null)return maxLevel;
		if(level > maxLevel) list.add(root.val);
		maxLevel = recursive ( root.right,  level+1,  Math.max(maxLevel, level), list); //we'll get max level from right side from here
		return  recursive ( root.left,  level+1,  Math.max(maxLevel, level), list);
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer>list = new ArrayList<>();
		recursive ( root,  0,Integer.MIN_VALUE, list);
		return list;
    }
}
