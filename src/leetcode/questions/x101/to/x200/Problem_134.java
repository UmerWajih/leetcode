package leetcode.questions.x101.to.x200;

public class Problem_134 {

	//https://leetcode.com/problems/gas-station/
	public static  int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==1 && (gas[0] < cost[0]) ) return -1;
		if(gas.length==1 && (gas[0] == cost[0]) ) return 0;
        int index=-1;
		for(int i=0; i< gas.length; i++) {
            if(gas[i] == cost[i]) continue;
			if (gas[i] - cost[i] >= 0) {
				index = i; //3 
				int sum = gas[index];
				while (sum > -1) {
					if(sum - cost[index] < 0) break;
					sum = sum - cost[index] + 
					gas[index + 1 == gas.length ? 0 :index + 1 ];
					index += 1;
					if(index==i || (index == gas.length && i==0)) return i;
					if (index == gas.length) index = 0;
				}
				index=-1;
			}
		}
		return -1;
    }
}
