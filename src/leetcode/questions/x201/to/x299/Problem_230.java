package leetcode.questions.x201.to.x299;

import java.util.Stack;

import leetcode.questions.Common.TreeNode;

public class Problem_230 {
	//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	//go to the bottom that will be your smallest value node
	
	private static int recursive (TreeNode root, int k,Stack<Integer> stack, int val) {
		if(root==null)return -1;
		
		val = recursive ( root.left, k,stack,val);
		if(val!=-1)return val;
		stack.add(root.val);
		if(stack.size()==k) return stack.pop();
		return recursive ( root.right, k,stack,val);
	}
	
	public static int kthSmallest(TreeNode root, int k) {
        return recursive ( root,  k, new Stack<>(),-1);
    }
	
//       |
//     |   |
//    | | | |
}
