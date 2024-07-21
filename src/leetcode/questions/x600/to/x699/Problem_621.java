package leetcode.questions.x600.to.x699;

import java.util.PriorityQueue;

public class Problem_621 {

	//https://leetcode.com/problems/task-scheduler/description/
	public static int leastInterval(char[] tasks, int n) {
		//create a count of each char element
		int[]arr = new int[26];
		for(char c: tasks) {
			arr[c-'A'] =arr[c-'A']+1;
		}
		//store occurrences in a max heap
		PriorityQueue<Integer> heap = new PriorityQueue<>((x,y)-> y-x);
		//
		for(int a: arr) {
			if(a==0)continue;
			heap.add(a);
		}
		//3*2*6
		//create a new array of size heap.peek *n
		arr = new int[heap.peek()*n*heap.size()];
		//now start adding values to arr
		int index=0;
		for(int i=heap.size()-1; i>=0;i--) {
			int arrIndex  = index;
			for(int j=0; j< heap.peek(); j++) { //add 1 3 times
				arr[arrIndex]=1;
				arrIndex += n+1;
				while(arrIndex < arr.length && arr[arrIndex]!=0) {
					arrIndex += n+1;
				}
			}
			heap.poll();
			index++;
			while(arr[index]!=0) {
				index++;
			}
		}
		int size=arr.length;
		for(int i=arr.length-1 ; i>=0; i--) {
			if(arr[i]!=0)break;
			size--;
		}
		
		return size;
    }
}
