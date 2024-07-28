package leetcode.questions.x101.to.x200;

import java.util.LinkedList;
import java.util.List;

import leetcode.questions.Common.TreeNode;

public class Problem_114 {

	//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
	
	//Easy way, go down left -> go down rigt -> store data in list -> map list onto tree
	private static void recursive (TreeNode root, List<Integer>list) {
		if(root == null )return;
		list.add(root.val);
		recursive ( root.left, list);
		recursive ( root.right, list);
	}
	public void flatten(TreeNode root) {
		List<Integer>list = new LinkedList<>();
		recursive (root, list);
		TreeNode val =root;
		val.left=null;
		val.right=null;
		for(int i=0; i<list.size(); i++) {
			val.right= new TreeNode(list.get(i));
			val = val.right;
		}	
    }
	
}
