package leetcode.questions.x201.to.x299;

public class Problem_287 {
	//https://leetcode.com/problems/find-the-duplicate-number/
	
	//constraint, we can not use more space, so cant have a set to check for duplicates ;(
	//constraint, cant modify the array, so cant sort and check ;(
	//lets try fast and slow pointer
	
	//1,3,4,2,2
	//slow =3 , fast =2
	//fast = 4, slow =2
	//slow = 2 ,fast =2 //our number
	//3,1,3,4,2
	
	//
	public static int findDuplicate(int[] nums) {
		if(nums.length==2) return nums[0];
		
        int slow = 0;
        int fast = 0;
        //loop while slow is not equal fast
        while(true) {
        	fast = nums[nums[fast]];
        	slow = nums[slow];
        	if(fast==slow)break;
        }
        int slow2 = 0;
        while(nums[slow2]!=nums[slow]) {
        	slow2 = nums[slow2];
        	slow = nums[slow];
        }
        
        return nums[slow];
    }
}
