package leetcode.questions.x401.to.x499;

public class Problem_457 {

	//https://leetcode.com/problems/circular-array-loop/description/
	
	//one way will be to loop through the array, if we end back at index i means loop
	//if index reaches nums.length no loop
	//slightly expensive approach n^2
	

	//since it is circular, we can try slow fast pointers
	//fast will be moving 1 move ahead
	//both will be intialized to index 0
	//if they match then return, if not get new index for both and move forward
	//we cant directly put nums[slow] and nums[nums[fast]] because for circularity
	//if we get elements with different directions it means that they are moving in opposite directions -> loop not found
	//issues, if value = 0
	//[2,-1,1,2,2]
	//2 , -1

	private static int getIndex(int[] nums, int i) {
		int n = nums.length;
        return i + nums[i] >= 0
        		? (i + nums[i]) % n //simple mod with n will give us the direction 
        				: n + ((i + nums[i]) % n); //we are basically subratcting index from size
	}
	
	private static boolean recursive(int[] nums,int slow, int fast) {
		if(slow == fast )return true;
		if(nums[fast] * nums[slow] < 0) return false;
		if(nums[fast] == 0 || nums[slow] == 0) return false; 
		int fastFirst = getIndex(nums, fast);
		if(fastFirst == fast) return false;//self loop
		if(nums[fastFirst] * nums[slow] < 0) return false; //different directions
		int fastNew = getIndex(nums, fastFirst);
		return recursive( nums,getIndex(nums, slow),fastNew );
	}
	
	public static boolean circularArrayLoop(int[] nums) {
		 if (nums == null || nums.length < 2) return false;
		 
		 for(int i=0; i< nums.length; i++) {
			 if(nums[i]==0)continue; //no movement at this point so ignore
			 int fast = getIndex(nums, i);
			 if(fast == i) {
				 //pointing to itself
				 nums[fast] = 0;
				 continue;
			 }
			 if(!recursive( nums,i, fast)) {
				 //circular loop not found
				 //set values along the path to 0 so we dont have to go through them
				int slow = i;
				int sgn = nums[i]; //basically trying oto get the direction 
				while (sgn * nums[slow] > 0) { //this will break when we have 2 different directions
					int tmp = getIndex(nums, slow);
					nums[slow] = 0;
					slow = tmp;
				}
			 }else {
				 return true;
			 }
		 }
		 
		return false;
	}
}
