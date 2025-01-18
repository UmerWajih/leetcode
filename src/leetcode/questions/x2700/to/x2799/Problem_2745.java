package leetcode.questions.x2700.to.x2799;

public class Problem_2745 {

	public static int longestString(int x, int y, int z) {
        //can never put x->z & z->b
        //start with x then start with y then stary with z

		int len=0;
		if(x>0) {
			len =rec(x-1, y, z, 0, 0,1);
			len*=2;
		}
		if(y>0) {
			len =Math.max(rec(x, y-1, z,  0, 1,1)*2, len);  
		}
		if(z>0) {
			len =Math.max(rec(x, y, z-1,  0, 2,1)*2, len);  	
		}
		return len;
		
    }
	
	
	private static int rec(int x, int y, int z, int len, int last, int cur) {
		if(x==0 && y==0 && z==0) return Math.max(len, cur);
		
		if(last == 0 && y>0)len =Math.max(len, rec(x, y-1, z, len, 1,cur+1))  ;
		
		
		if(last==1 && x >0)len =Math.max(len, rec(x-1, y, z, len, 0,cur+1))  ;
		if(last==1 && z >0)len =Math.max(len, rec(x, y, z-1, len, 2,cur+1))  ;
		
		if(last==2 && x>0)len =Math.max(len, rec(x-1, y, z, len, 0,cur+1))  ;
		if(last==2 && z>0)len =Math.max(len, rec(x, y, z-1, len, 2,cur+1))  ;
		
		return Math.max(len, cur);
	}
}
