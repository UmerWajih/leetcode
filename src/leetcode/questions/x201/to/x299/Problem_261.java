package leetcode.questions.x201.to.x299;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/graph-valid-tree
public class Problem_261 {

	
	public static boolean validTree(int n, int[][] edges) {
		//valid tree = no loops
		//we need parents of each
		//where valid, set all nodes parents of smaller tree
		int [] arr = new int[n];
		Arrays.fill(arr, -1);
		int rootNodes=n;
 		for(int i=0; i< edges.length;i++) {
 			int node= arr[edges[i][0]];
 			Set<Integer> set = new HashSet<>();
 			int size1=0;
 			set.add(edges[i][0]);
 			while(node !=-1) {
 				set.add(node);
 				node = arr[node];
 				size1++;
 			}
 			//at this point we will have parent from node 1
 			
 			node= arr[edges[i][1]];
 			int size2=0;
 			if(set.contains(edges[i][1])) return false; 
 			while(node !=-1) {
 				if(set.contains(node)) return false; //loop will be formed with this edge
 				node = arr[node];
 				size2++;
 			}
 			
 			//now we need to add an edge
 			//smaller tree will have its parents updated
 			if(size1 >= size2) {
 				updateParents(arr, edges[i][0], edges[i][1]);
 			}else {
 				updateParents(arr, edges[i][1], edges[i][0]);
 			}
 			rootNodes--;
		}
		return rootNodes==1;
    }
	
	private static void updateParents(int [] arr, int newParent, int index) {
		int oldParent = arr[index];
		arr[index] = newParent;
		if(oldParent==-1) {
			return;
		}
		updateParents( arr, index, oldParent);	
	}
}
