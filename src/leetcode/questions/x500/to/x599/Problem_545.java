package leetcode.questions.x500.to.x599;

import java.util.ArrayList;
import java.util.List;

import leetcode.questions.Common.TreeNode;

public class Problem_545 {

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		if(root==null) return output;
		output.add(root.val);
		left(root.left, output);
		leaves(root.left, output);
		leaves(root.right, output);
		right(root.right, output);
		return output;
    }
	
	
	private void left(TreeNode root, List<Integer> output) {
		if (root ==null || (root.left==null && root.right == null))return;
		output.add(root.val);
		if(root.left==null)left(root.right,  output);
		else left(root.left,  output);
	}
	
	
	private void right(TreeNode root, List<Integer> output) {
		if (root ==null || (root.left==null && root.right == null))return;
		if(root.right==null)right(root.left,  output);
		else right(root.right,  output);
		output.add(root.val);
	}
	
	public void leaves(TreeNode root, List<Integer> output) {
	    if(root == null) return;
	    if(root.left == null && root.right == null) {
	    	output.add(root.val);
	        return;
	    }
	    leaves(root.left,output);
	    leaves(root.right,output);
	}
	
	//go down to left hand side
	//all right nodes exceeding left most level would get added
	
}
