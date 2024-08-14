package leetcode.questions.x1600.to.x1699;

import leetcode.questions.Common.Node;

public class Problem_1650 {
	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
	
	
	public Node lowestCommonAncestor(Node p, Node q) {
		//keep checking parents of both
		Node n1 = p, n2=q;
		while (n1!=n2) {
			n1 = n1 == null ? q : n1.parent;
			n2 = n2 == null ? p : n2.parent;
		}
		return n1;
    }
}
