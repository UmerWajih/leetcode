package leetcode.questions.x3300.to.x3399;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_3342 {

	public static int minTimeToReach(int[][] moveTime) {
        int[][] visited= new int[moveTime.length][moveTime[0].length];
		visited[0][0]=1;
		
		moveTime[0][0]=0;
		
		int counter=1;
		Queue<int[]>q= new LinkedList<>();
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty()) {

			int size= q.size();
			for(int i=0; i< size; i++) {
				int[]v =q.poll();
				if(moveTime[v[0]][v[1]] == -1)continue;
				if(v[0]+1 < moveTime.length && moveTime[v[0]+1][v[1]] != -1) {
					if(visited[v[0]+1][v[1]] == 1) {
						moveTime[v[0]+1][v[1]]=Math.min(moveTime[v[0]+1][v[1]], moveTime[v[0]][v[1]] + (counter%2 == 0? 2 :1));
					}else {
						moveTime[v[0]+1][v[1]]= Math.max(moveTime[v[0]+1][v[1]], moveTime[v[0]][v[1]]);
						moveTime[v[0]+1][v[1]]+= (counter%2 == 0? 2:1);
						visited[v[0]+1][v[1]]=1;
					}
					q.offer(new int[] {v[0]+1,v[1]});
				}
				if(v[0]-1 >= 0 && moveTime[v[0]-1][v[1]] != -1) {
					if(visited[v[0]-1][v[1]] == 1) {
						moveTime[v[0]-1][v[1]]=Math.min(moveTime[v[0]-1][v[1]], moveTime[v[0]][v[1]] + (counter%2 == 0? 2 :1));
					}else {
						moveTime[v[0]-1][v[1]]= Math.max(moveTime[v[0]-1][v[1]], moveTime[v[0]][v[1]]);
						moveTime[v[0]-1][v[1]]+= (counter%2 == 0? 2:1);
						visited[v[0]-1][v[1]]=1;
					}
					q.offer(new int[] {v[0]-1,v[1]});
				}
				
				if(v[1]+1 < moveTime[0].length && moveTime[v[0]][v[1]+1] != -1) {
					if(visited[v[0]][v[1]+1] == 1) {
						moveTime[v[0]][v[1]+1]=Math.min(moveTime[v[0]][v[1]+1], moveTime[v[0]][v[1]] + (counter%2 == 0? 2 :1));
					}else {
						moveTime[v[0]][v[1]+1]= Math.max(moveTime[v[0]][v[1]+1], moveTime[v[0]][v[1]]);
						moveTime[v[0]][v[1]+1]+= (counter%2 == 0? 2:1);
						visited[v[0]][v[1]+1]=1;
					}
					q.offer(new int[] {v[0],v[1]+1});
				}
				if(v[1]-1 >= 0 && moveTime[v[0]][v[1]-1] != -1) {
					if(visited[v[0]][v[1]-1] == 1) {
						moveTime[v[0]][v[1]-1] =Math.min(moveTime[v[0]][v[1]-1], moveTime[v[0]][v[1]] + (counter%2 == 0? 2 :1));
					}else {
						moveTime[v[0]][v[1]-1]= Math.max(moveTime[v[0]][v[1]-1], moveTime[v[0]][v[1]]);
						moveTime[v[0]][v[1]-1]+= (counter%2 == 0? 2:1);
						visited[v[0]][v[1]-1]=1;
					}
					q.offer(new int[] {v[0],v[1]-1});
				}
				
				if(v[0]==moveTime.length-1 && v[1]==moveTime[0].length-1)break;
				moveTime[v[0]][v[1]]=-1;
			}
			counter++;
		}
		return moveTime[moveTime.length-1][moveTime[0].length-1];
    }
}
