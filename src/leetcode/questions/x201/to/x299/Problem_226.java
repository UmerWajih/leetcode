package leetcode.questions.x201.to.x299;

import leetcode.questions.Common.TreeNode;

public class Problem_226 {

	//https://leetcode.com/problems/invert-binary-tree
	
	//start from root
	//send in two nodes, right and left

	
	private void invert(TreeNode root) {
		if(root == null) return; //end of that path
		TreeNode t= root.left; //2
		root.left = root.right; //
		root.right=t;
		invert(root.left);
		invert(root.right);
		
	}
	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
    }
}
