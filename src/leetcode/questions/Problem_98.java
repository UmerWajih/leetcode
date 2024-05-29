package leetcode.questions;

import leetcode.questions.Common.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class Problem_98 {

	//copied code => very good solution
	static TreeNode old=null;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		
		if(isValidBST(root.left) && (old == null || root.val>old.val)) {
			old = root;
			return isValidBST(root.right);
		}
        return false;
	}
	
	
	//works but this is a cop out -> only valid solution will be go down left node and make out way up
	public boolean isValidBST2(TreeNode root) {
		if(root.left == null && root.right == null) return true;
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE, true);
	}

	public boolean recursive(TreeNode root, long min, long max, boolean firstNode) {
		if (root == null)return true;

		if (root.val >= max   )return false;
		if (root.val <= min  )return false;

		return recursive(root.left, min, root.val,false) && recursive(root.right, root.val, max, false);
	}
}
