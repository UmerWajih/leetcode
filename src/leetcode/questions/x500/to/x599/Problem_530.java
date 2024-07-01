package leetcode.questions.x500.to.x599;

import leetcode.questions.Common.TreeNode;

public class Problem_530 {

	//https://leetcode.com/problems/minimum-absolute-difference-in-bst
	
	//based on logic of tree minimum difference will be between parent in 2 childs
	//[4,2,6,1,3]
	private static int[] recursive(TreeNode root, int  min, int val) {
		if(root == null) return new int[] {min,val}; //end of tree so return min which in this case will be int min
		
		
		int [] a= recursive(root.left,min,val);  //Integer.MIN_VALUE
		
		if(a[1]!=Integer.MAX_VALUE)min = Math.min(a[0], root.val - a[1] ); //2-1 to set min here
		val  = root.val;  //set value to roots current value //
		
		//check if node has right
		a=  recursive(root.right,min,val);
		
		return a;
	}
	public static int getMinimumDifference(TreeNode root) { //4,2,1
		return recursive(root,  Integer.MAX_VALUE,  Integer.MAX_VALUE)[0];
    }
}
