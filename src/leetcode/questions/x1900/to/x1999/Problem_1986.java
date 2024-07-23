package leetcode.questions.x1900.to.x1999;

public class Problem_1986 {
	
	//https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
	//new int[] {1,5,7,10,3,8,4,2,6,2}, 10
	public static int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, MAX = Integer.MAX_VALUE; //n=10
        
        int[][] dp = new int[1<<n][2]; //new int[10000000000][2]
        //dp[i][0] => session number
        //dp[i][1] => time used
        dp[0][0] = 1; // first session
        dp[0][1] = 0; // so far no time is used
        
        for(int i = 1; i < (1 << n); i++) { 
            dp[i][0] = MAX; //
            dp[i][1] = 0;
            
            for(int t = 0; t < n; t++) {
                if(((1<<t) & i) == 0) continue; //[10000000000] we are anding with this bit mask, if 0 need to check
                //we are checking if task n is on in this bit mask
                //if on we will move forward
                //lets say we have [10010010100] => 3 task are being used => index 3,5,8
                //so at t = 3,5,8 we will enter this chunk
                int[] prev = dp[(1<<t) ^ i];
                //now in this bitmask we will check for session time will t task
                //ex: t=3
                //prev will have value task t removed and all the rest tasks are on
                if(prev[1] + tasks[t] <= sessionTime) {
                    dp[i] = min(dp[i], new int[]{prev[0], prev[1] + tasks[t]}); //if if adding task t gives us value less than session time check this
                }else{
                    dp[i] = min(dp[i], new int[]{prev[0] + 1, tasks[t]}); //else for mask 
                }
            }            
        }
        
        return dp[(1<<n) - 1][0];
    }
    
    private static int[] min(int[] d1, int[] d2) {
        if(d1[0] > d2[0]) return d2;
        if(d1[0] < d2[0]) return d1;
        if(d1[1] > d2[1]) return d2;
        
        return d1;
    }
}
