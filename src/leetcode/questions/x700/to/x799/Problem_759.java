package leetcode.questions.x700.to.x799;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.questions.Common.Interval;

public class Problem_759 {
	//https://leetcode.com/problems/employee-free-time/
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        //emp: [[[1,2],[5,6]],[[1,3]],[[4,10]]]
		//events: [1,1][2,-1],[5,1],[6,-1],[1,1],[3,-1],[4,1],[10,-1]
		//sort the events: by first val=> [1,1],[1,1],[2,-1],[3,-1],[4,1],[5,1],[6,-1],[10,-1]
		//when number becomes 0 track the element
		//if diff between 0th element  > 0 add interval
		//else reject the value
		List<Interval> output = new ArrayList<>();
		//we have to use array list as number of schedules is not known, we know just know employee count
		//we can break the events down as there are no overlapping events per employee
		List<Interval> events = new ArrayList<>();
		for(List<Interval> interval : schedule) {
			for(Interval val : interval) {
				events.add(new Interval(val.start, 1));
				events.add(new Interval(val.end, -1));
			}
		}
		Collections.sort(events,(e1,e2)->e1.start-e2.start);
		int count=0;
		int val=-1;
		for(Interval interval : events) {
			if(count == 0 && val != -1 && interval.start-val > 0) {
				output.add(new Interval(val, interval.start));
				val=-1;
			}
			count+=interval.end;
			
			if(count ==0) {
				val=interval.start;
			}
		}
		return output;
    }
}
