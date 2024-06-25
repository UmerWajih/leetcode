package leetcode.questions.x101.to.x200;

import leetcode.questions.Common.TreeNode;

public class Problem_110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return recurcise(root.left, root.right);
    }
	
	public boolean recurcise(TreeNode left, TreeNode right) {
		
		//if either is null we have an end case
		if(left==null && right ==null) return true;
		if(left == null && right !=null) {
			if(right.right==null) return true;
			if(right.right!=null) return false;
		}
		
		if(left != null && right ==null) {
			if(left.left==null) return true;
			if(left.left!=null) return false;
		}
		
		return recurcise(left.left, right.right) || recurcise(left.right, right.left);
	}
}
