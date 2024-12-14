package leetcode.questions.x1100.to.x1199;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.questions.Common.TreeNode;

public class Problem_1161 {

	
	//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
	public int maxLevelSum(TreeNode root) {
        int minSum= Integer.MIN_VALUE, minLevel = 0;
        int level=1;
        
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
        	int size= q.size();
        	int levelSum = 0;
        	
        	for(int i=0; i<size; i++) {
        	
        		if(q.peek().left != null) q.offer(q.peek().left);
        		if(q.peek().right != null) q.offer(q.peek().right);
        		levelSum+=q.poll().val;
        	}
        	if(levelSum > minSum) {
        		minLevel= level;
        		minSum= levelSum;
        	}
        	
        	level++;
        }
        return minLevel;
    }
}
