package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.questions.Common.TreeNode;

public class Problem_102 {
	//https://leetcode.com/problems/binary-tree-level-order-traversal/
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<List<Integer>>  output = new ArrayList<>();
		Queue<TreeNode> q= new LinkedList<>();
		//start by adding elements to a queue
		//[3,9,20,null,null,15,7]
		//first add the root
		
		q.offer(root);
		//now keep checking till q is not empty
		while(!q.isEmpty()) {
			int levelNodes=q.size(); //this will have all nodes on that level // initially 1 then 2if both left and right are not null
			List<Integer> list = new ArrayList<>();
			
			for(int i=0;i<levelNodes ;i++) {
				if(q.peek().left!=null)q.offer(q.peek().left); //add left node
				if(q.peek().right!=null)q.offer(q.peek().right);//add right node
				list.add(q.poll().val);//add val from that node
			}
			
			output.add(list);
		}
		
		
		
		return output;
    }
}
