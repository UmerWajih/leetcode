package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/factor-combinations/
public class Problem_254 {

	 public static List<List<Integer>> getFactors(int n) {
		 Set<List<Integer>> set = new HashSet<>();
		 rec(n, new ArrayList<>(), set);
		 return new ArrayList<>(set);
	 }
	 
	 //this recursive function 
	 //n will change
	 //PriorityQueue so we dont have to sort
	 //set to avoid duplicates
	 
	 //n= 4
	 private static void rec(int n, List<Integer> q, Set<List<Integer>> set) {
		 int half = n/2;
		 
		 for(int i=2; i<= half; i++) {
			 if(n%i==0) {
				 //we have a factorial
				 q.add(i); //2,2,2
				 rec(n/i, q, set);
				 q.add(n/i);
				 add(q, set);
				 //remove last 2 elements
				 q.remove(q.size()-1);
				 q.remove(q.size()-1);
			 }
		 }
	 }
	 private static void add(List<Integer> q, Set<List<Integer>> set) {
		 List<Integer> l = new ArrayList<>(q);
		 Collections.sort(l);
		 if(!set.contains(l)) {
			 set.add(l);
		 }
	 }
}
