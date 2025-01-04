package leetcode.questions.x1200.to.x1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/meeting-scheduler/
public class Problem_1229 {
	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        if(slots1.length == 0 || slots2.length == 0) return new ArrayList<>();
		
		int [][] slots = new int[(slots1.length+slots2.length)*2][2];
        int size=0;
        for(int[]s : slots1) {
        	slots[size][0]=s[0];
        	slots[size][1]=1;
        	size++;
        	slots[size][0]=s[1];
        	slots[size][1]=-1;
        	size++;
        }
        for(int[]s : slots2) {
        	slots[size][0]=s[0];
        	slots[size][1]=1;
        	size++;
        	slots[size][0]=s[1];
        	slots[size][1]=-1;
        	size++;
        }
        Arrays.sort(slots, (a,b) -> (a[0] - b[0]));
        
        int start=-1, available=0;
        
        for(int[]s : slots) {
        	available+= s[1];
        	//here both are available
        	if(available == 2) {
        		start = s[0];
        		continue;
        	}
        	if(available == 1 && start != -1) {
        		int diff =  s[0] -start;
        		if(diff >= duration) {
        			return Arrays.asList(start, start+duration);
        		}else {
        			start = -1;
        		}
        	}
        }
        return new ArrayList<>();
    }
}
