package leetcode.questions.x300.to.x400;

public class Problem_427 {
	static class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    
	    public Node() {
	        this.val = false;
	        this.isLeaf = false;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = topLeft;
	        this.topRight = topRight;
	        this.bottomLeft = bottomLeft;
	        this.bottomRight = bottomRight;
	    }
	}
	
	public static Node construct(int[][] grid) {
		return subTree(grid, 0, 0,grid.length);
    }
	
	private static Node subTree(int[][] grid, int row, int col,int target){
        int val=grid[row][col]; //1
        boolean isLeaf=true, value= val==1?true:false; //isLeaf= true, value=true
        Node node=new Node();
        
        int rowTarget = row+target, colTarget = col+target;
        int i=row;
        int j= col;
        
        for(; i<rowTarget; i++){
        	j= col;
            for(; j<colTarget; j++){
                if(grid[i][j]!=val){
                    isLeaf=false;
                    node.topLeft= subTree(grid, row, col,(target-row)/2);
                    node.bottomLeft= subTree( grid, row+(target-row)/2, 
                                             col,(target-row)/2);
                    node.topRight= subTree(grid, row, 
                                             col+(target-row)/2,(target-row)/2);
                    node.bottomRight= subTree(grid, row+(target-row)/2, 
                                             col+(target-row)/2,(target-row)/2);
                    break;
                    
                }
            }
        }
        node.isLeaf=isLeaf;
        node.val=value; //we'll look into the val
        
        
        return node;
    }
}
