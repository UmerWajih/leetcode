package leetcode.questions.x101.to.x200;

public class Problem_167 {
	//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
	public int[] twoSum(int[] numbers, int target) {
        int i=0, j = numbers.length-1;
        int [] output = new int [2];
        while (i<j) {
        	int sum = numbers[i] + numbers[j];
        	if (sum == target) {
        		output[0] = i+1; 
        		output[1] = j+1; 
        		break;
        	}
        	if(sum > target) j--;
        	if(sum < target) i++;
        }
        return output;
    }
}
