package leetcode.questions.x3300.to.x3399;


//https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
public class Problem_3341 {
	
	
	public static int minTimeToReach(int[][] moveTime) {
        return min(moveTime, new int[moveTime.length][moveTime[0].length], 0,0,0,Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
	//time mentioned in the node is from start not from when you are at the adjacent node
	//they conveniently left that out.
	
	//rec function
	//visited will keep track of previous path so we dont go back there
	
	//if we have maximum waiting time
	//just add movements from there
	private static int min(int[][] moveTime, int[][] visited, int row, int col, 
			int cur, int min, int localMax) {
		if(col==2 && row ==0)
			System.out.print("hello");
		if(col < 0 || col >= moveTime[0].length || row < 0 || 
				row >= moveTime.length ||visited[row][col] ==1) {
			return min; //invalid path or already visited node
		}
		
		if(moveTime[row][col] > localMax && !(col ==0 && row==0)) {
			cur = Math.max(cur, moveTime[row][col] +1);
			localMax = Math.max(localMax, moveTime[row][col]);
		}
		
		if(col== moveTime[0].length-1 && row == moveTime.length-1) return Math.min(cur, min);
		
		
		if(cur >= min) return min; //no need to check further-> not a shortest path
		visited[row][col]=1;
		//try all 4 directions
		min= min(moveTime, visited, row+1,col,  cur+1,min, localMax); 
		min= min(moveTime, visited, row-1,col,  cur+1,min, localMax); 
		min= min(moveTime, visited, row,col+1,  cur+1,min, localMax); 
		min= min(moveTime, visited, row,col-1,  cur+1,min, localMax); 
		
		
		visited[row][col]=0;
		return min;
	}
}
