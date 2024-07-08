package leetcode.questions.x1300.to.x1399;

import leetcode.questions.Common.TreeNode;

public class Problem_1315 {
	//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
	private int sum(TreeNode node){
        if (node ==null) return 0;
        int left=0, right=0;
        if (node.left != null) left = node.left.val; 
        if (node.right != null) right = node.right.val; 
        return left+right;
    }
    
    private int recursive(TreeNode root, int sum){
        if (root == null) return sum;
        
        if(root.val % 2 == 0){
            sum+= sum(root.left); //sum = 9
            sum+= sum(root.right); //sum =13
        } 
        
        sum = recursive(root.left, sum);
        sum = recursive(root.right, sum);
        
        return sum;
        
    }
    
    
    public int sumEvenGrandparent(TreeNode root) {
        return recursive(root, 0);
    }
}
