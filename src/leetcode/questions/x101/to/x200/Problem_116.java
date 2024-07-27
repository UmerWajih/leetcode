package leetcode.questions.x101.to.x200;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.questions.Common.Node;

public class Problem_116 {
	//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
        	int levelNodes = q.size();
        	Node base = null;
        	for(int i=0; i< levelNodes;i++) {
        		if(q.peek().left!=null)q.offer(q.peek().left);
        		if(q.peek().right!=null)q.offer(q.peek().right);
        		if(base==null) {
        			base = q.poll();
        		}else {
        			base.next=q.poll();
        			base = base.next;
        		}
        		
        		
        	}
        }
        return root;
    }
}
