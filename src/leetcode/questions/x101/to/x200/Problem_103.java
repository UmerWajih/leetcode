package leetcode.questions.x101.to.x200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.questions.Common.TreeNode;

public class Problem_103 {
	//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<List<Integer>>  output = new ArrayList<>();
		Queue<TreeNode> q= new LinkedList<>();
		//start by adding elements to a queue
		//[3,9,20,null,null,15,7]
		//first add the root
		
		q.offer(root);
		//now keep checking till q is not empty
		int level =0;
		while(!q.isEmpty()) {
			int levelNodes=q.size(); //this will have all nodes on that level // initially 1 then 2if both left and right are not null
			List<Integer> list = new ArrayList<>();
			
			for(int i=0;i<levelNodes ;i++) {
				if(q.peek().left!=null)q.offer(q.peek().left); //add left node
				if(q.peek().right!=null)q.offer(q.peek().right);//add right node
				list.add(q.poll().val);//add val from that node
			}
			if(level%2 !=0) Collections.reverse(list);
			level++;
			output.add(list);
		}
		
		
		
		return output;
	}
}
