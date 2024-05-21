package leetcode.questions.x101.to.x200;

import java.util.Stack;

import leetcode.questions.Common.TreeNode;

public class Problem_173 {
	//https://leetcode.com/problems/binary-search-tree-iterator
	public static class BSTIterator {
		private Stack<TreeNode> stack = new Stack<>();
		
		private void setStack(TreeNode root){
			while(root != null) {
		    	   stack.push(root);
		    	   root=root.left; //{stack will have 3 , 7}
		       }
		}
		public BSTIterator(TreeNode root) {
			setStack(root);
	    }
	    
	    public int next() {
	    	// sec next call
	    	TreeNode node = stack.pop();
	    	if(node!=null) {
	    		setStack(node.right); // stack is now [ 9, 15]
	    		return node.val; //retrun 7
	    	}
	    	return -1;
	    }
	    
	    public boolean hasNext() {
	        return !stack.isEmpty(); // true
	    }
		
	}
	
}
