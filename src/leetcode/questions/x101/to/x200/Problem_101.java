package leetcode.questions.x101.to.x200;

import leetcode.questions.Common.TreeNode;

//https://leetcode.com/problems/symmetric-tree/description/
public class Problem_101 {

	public boolean isSymmetric(TreeNode root) {
		return recursive(root.right, root.left);
    }
	
	public boolean recursive(TreeNode right, TreeNode left) {
		// return statement like that because if both are null then true
		if (right == null || left == null) return right == left;
		
		if(right.val != left.val) return false;
		
		return recursive(right.right,  left.left) && recursive(right.left,  left.right);
	}
}
