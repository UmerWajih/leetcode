package leetcode.questions.x300.to.x400;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/design-hit-counter
public class Problem_362 {

	//put time stamps in a heap
	//dont even need a heap
	//do binary search till we find diff of 300
	//return len-index as hits
	
	List<Integer> q;
	
	public Problem_362() {
        q=new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    
	public int getHits(int timestamp) {
		if (timestamp <= 300 || q.isEmpty())
			return q.size();
		else {
			int target = timestamp - 300;
			int left = 0, right = q.size() - 1;
			
			
			//if mid > target
			//bring right to mid
			//else bring left to mid
			
			
			
			//when left becomes greater than target then we stop
			while(q.get(left) < target) {
				int mid =left + (right - left) / 2;
				
				if(q.get(mid)  > target) {
					right=mid;
				}else {
					left=mid;
				}		
			}
			
			while(left >= 0 && q.get(left) > target) left--;
			
			return left == -1 ? q.size() : q.size()-(left+1);


		} 
    }
}
