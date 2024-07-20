package leetcode.questions;

import java.util.Arrays;

public class Problem_88 {
	//problems/merge-sorted-array
	
	//nums1 = [1,2,3,0,0,0]
	//nums2 = [2,5,6]
	//index = [2,-1,-1]
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int i=m-1, j=n-1;
		while(i>=0 && j>=0) {
			if(nums1[i] > nums2[j]) {
				nums1[i+j+1] = nums1[i];
				i--;
			}else {
				nums1[i+j+1] = nums2[j];
				j--;
			}
		}
		//if values from i is left over no problem
		//if values from j are left over add them
		int k=0;
		while(k<=j) {
			nums1[k]=nums2[k];
			k++;
		}
		
    }
}
