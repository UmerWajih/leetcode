package leetcode.questions.x2600.to.x2699;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.questions.Common.TreeNode;

public class Problem_2641 {

	public TreeNode replaceValueInTree(TreeNode root) {
		
		//key level, value would be sum of entire map
		Map<Integer, Integer> map = new HashMap<>();
		
		//level 1 will never have any cousins
		int level =0;
		Queue<TreeNode> list = new LinkedList<>();
		list.add(root);
		
		while(!list.isEmpty()) {
			int sum=0;	
			int size = list.size(); //get nodes on that level
			
			for(int i=0; i< size; i++) {
				if(list.peek().left !=null) list.offer(list.peek().left);
				if(list.peek().right !=null) list.offer(list.peek().right);
				sum+= list.poll().val;
			}
			map.put(level, sum);
			level++;
			sum=0;
		}
		//we will now have sum of all rows
		list = new LinkedList<>(); level =0;
		list.add(root);
		root.val=0;
		while(!list.isEmpty()) {
			int size = list.size(); //get nodes on that level
			
			for(int i=0; i< size; i++) {
				//get sum of left and right
				int sum = 0;
				if(list.peek().left !=null) sum += list.peek().left.val;
				if(list.peek().right !=null) sum += list.peek().right.val;
				
				if(list.peek().left !=null) {
					list.offer(list.peek().left);
					list.peek().left.val = map.get(level+1)-sum;
				}
				if(list.peek().right !=null) {
					list.offer(list.peek().right);
					list.peek().right.val = map.get(level+1)-sum;
				}
				list.poll();
			}
			level++;
		}
		
		
		return root;
    }
}
