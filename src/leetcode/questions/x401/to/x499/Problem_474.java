package leetcode.questions.x401.to.x499;

//https://leetcode.com/problems/ones-and-zeroes/
public class Problem_474 {

	//start of with the first index
	//create count of 1's and 0's
	//iterate through the entire array
	//once the count > m and n return the diff between current index-1 and start index
	//if at any point strs.len ==  count return, no need to check further
	
	
	//issue with this code is it isnt considering pairs if a mismatch happend
	//add another secondary index to be continued...
	private static int rec(String[] strs, int m, int n, int zCount, int oCount, int startIndex, 
			int index, int maxSize, int size) {
		
		if(startIndex == strs.length) return maxSize;
	
		int zeroCount=0, oneCount=0;
		
		for(char c : strs[index].toCharArray()) {
			if(c == '0') zeroCount+=1;
			else oneCount+=1;
		}
		
		if(zCount+zeroCount <= m && oCount+oneCount <= n) {
			size+=1;
			zCount+=zeroCount;
			oCount+=oneCount;
		}
		
		if(index+1 == strs.length) {
			maxSize= Math.max(maxSize, size);
			maxSize= rec( strs,  m,  n,  0,  0,  startIndex+1, startIndex+1,  maxSize,  0);
		}else {
			maxSize= Math.max(rec( strs,  m,  n,  zCount,  oCount,  startIndex, index+1,  maxSize,  size), 
					rec( strs,  m,  n,  zCount-zeroCount,  oCount-oneCount,  startIndex, index+1,  maxSize,  size-1))
					;
		}
		
		return maxSize;
		
		
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
     return rec(strs, m, n, 0, 0, 0, 0, 0, 0);   
    }
}
