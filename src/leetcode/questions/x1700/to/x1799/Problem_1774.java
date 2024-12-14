package leetcode.questions.x1700.to.x1799;

public class Problem_1774 {

	//we can select one topping either 0,1,2 times
	//we can only have one from base
	//if we have 2 cost with similar diff to target we will store the lower one
	
	//baseCosts = [1,7], toppingCosts = [3,4], target = 10
	public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int output=Integer.MAX_VALUE;
        
        for(int i: baseCosts) {
        	for( int j= 0 ; j < toppingCosts.length ; j++) {
        		int a = Math.abs(target-output);
        		int c = rec (toppingCosts, target, j, 1, i,Math.abs(target - i));
        		int b = Math.abs(target-c);
        		
        		if (a > b) {
        			output= c;
        		}
        		if(a == b)output = Math.min(output,c);
        	}
        	
        }
        
        return output;
    }
	
	
	private static int rec ( int[] toppingCosts, int target, int index, int occ, int sum, int output) {
		
		if( index == toppingCosts.length) return output;
		
		//here logic to check
		sum+=toppingCosts[index];
		int diff = Math.abs(target - output);
		int iDiff = Math.abs(target- sum);
		
		if(iDiff < diff) {
			output= sum;
		}
		//if equal choose lower value
		if(iDiff == diff) {
			output = Math.min(sum, output);
		}
		if(iDiff > diff && sum > output) return output;
		
		//we can either try the topping again or try the next topping
		if(occ < 2) {
			int same = rec ( toppingCosts, target, index, occ+1,  sum,  output) ;
			int different= rec ( toppingCosts, target, index+1, 1,  sum,  output);
			
			if (Math.abs(target - same) < Math.abs(target - different)) {
				output = same;
			}else if  (Math.abs(target - same) > Math.abs(target - different)){
				output = different;
			}else {
				output = Math.min(same, different);
			}
			
		}else {
			//if we already have 2  toppings of the same we have to go to new one
			output = rec ( toppingCosts, target, index+1, 0,  sum,  output)  ;
		}
		
		
		return output;
	}
	
	
	
}
