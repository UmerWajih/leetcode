package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_46 {
	//https://leetcode.com/problems/permutations
	private void recursive(int[] nums,Integer []dummy, int index,List<List<Integer>> output ){
        
        if(index == nums.length){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i < nums.length; i++){
             l.add(dummy[i]);   
            }
            output.add(l);
        };
        
        for(int i=0;i < nums.length; i++){
            if(dummy[i]==11){
                dummy[i]=nums[index];
                recursive(nums, dummy, index+1,output );
                dummy[i]=11;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        Integer []dummy = new Integer[nums.length];
        Arrays.fill(dummy,11); //11 as nums[i] <=10
        List<List<Integer>>  output = new ArrayList<>();
        recursive( nums,dummy, 0,output );
        return output;
    }
}
