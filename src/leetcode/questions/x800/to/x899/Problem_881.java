package leetcode.questions.x800.to.x899;

import java.util.Arrays;

public class Problem_881 {
//https://leetcode.com/problems/boats-to-save-people/
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j=people.length -1;
        int count =0;
        while(i<=j){
             if(people[i]+ people[j] <= limit){
                i++; 
             }
             j--; count++;
        }
        return count;
        //sort the array
        //i=0, j=people.len-1
        //if sum of i and j is >= to limit => both people can be put on boat
        //else only j can go on boat
        //add boat count on every iteration
    }
}
