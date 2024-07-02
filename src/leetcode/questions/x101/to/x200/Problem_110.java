package leetcode.questions.x101.to.x200;

import leetcode.questions.Common.TreeNode;

public class Problem_110 {
	
	//https://leetcode.com/problems/balanced-binary-tree/description/
	
	//Approach 1: 
	//send in left side of the tree, get its height
	//senf in right, get its height
	//if difference is greater than 1, return false
	//This approach is not optimal, why are we checking if height of all nodes if a validation can happen quite quickly
	
	//Approach 2 DFS:
	//go down left, if there is an imbalance return false
	//do the same for right
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		
		return recurcise(root) == -1 ? false : true;
    }
	
	public int recurcise(TreeNode node) {
		
		if (node == null) return 0;
		int l = recurcise(node.left);
		int r = recurcise(node.right);
		// if there are invalid nodes
		if (l == -1 || r == -1)  return -1;
		if(Math.abs(l-r) > 1){
			return -1;
		}
		//return the height
		return Math.max(l, r)+1;
		
	}
}
