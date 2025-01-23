package leetcode.questions.x1600.to.x1699;

import java.util.HashMap;
import java.util.Map;

public class Problem_1640 {
	public static boolean canFormArray(int[] arr, int[][] pieces) {
	     //arr distinct
	     //form arr through pieces
	    //you can not break the value of pieces down
	        //since arr has distinct values we can not have duplicates
	        //the goal is to find
	        
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i=0; i<arr.length; i++){
	            map.put(arr[i], i); //index against value
	        }
	        
	        int[] seen = new int[arr.length];
	        
	        for(int[] i : pieces){
	            if(map.containsKey(i[0]) && seen[map.get(i[0])]==0){
	                int index=map.get(i[0])-1;
	                for(int j=0; j<i.length; j++){
	                    if(map.containsKey(i[j]) &&  index+1 == map.get(i[j])){
	                        seen[map.get(i[j])]=1;
	                        map.remove(i[j]);
	                        index++;
	                    }else{
	                        return false;
	                    }
	                }
	            }else{return false;}
	        }
	        return true;
	        
	    }
}
