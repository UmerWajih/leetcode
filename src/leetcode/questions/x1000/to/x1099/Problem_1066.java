package leetcode.questions.x1000.to.x1099;

//https://leetcode.com/problems/campus-bikes-ii/
public class Problem_1066 {

	public static int assignBikes(int[][] workers, int[][] bikes) {
        //brute force approach
		//try and find all possible combinations available
		int [] wUsed= new int[workers.length];
		int [] bUsed= new int[bikes.length];
		
		return rec(workers, bikes, wUsed, bUsed, Integer.MAX_VALUE, 0, 0);
    }
	//workers= [[0,0],[2,1]]
	//bikes = [[1,2],[3,3]]
	//wUsed =[1,1]
	//bUsed =[1,1]
	//curDistance =3
	//minDistance
	
	private static int rec(int[][] workers, int[][] bikes, int [] wUsed, int [] bUsed, 
			int minDistance, int curDistance, int index) {
		
		if(index == workers.length) return Math.min(minDistance, curDistance);
		if(curDistance > minDistance) return minDistance;
		wUsed[index] = 1;
		for(int i=0; i< bUsed.length; i++) {
			if(bUsed[i] == 1) continue; //bike in use
			bUsed[i]=1;
			minDistance=rec(workers, bikes, wUsed, bUsed, minDistance,
					curDistance+manhattanDistance(workers[index] ,bikes[i]), index+1);
			bUsed[i]=0;
		}
		wUsed[index] = 0;
		return minDistance;
		
		
	}
	
	
	private static int manhattanDistance(int[]a ,int[]b ) {
		return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
	}
}
