package p5_workspase;

import java.util.;


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
        	return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, h = n1;
        int l1 = (n1 + n2 + 1) / 2;


        while (l <= h) {
        	int cut1 = l + (h - l) / 2;
        	int cut2 = l1 - cut1;

        	int left1 = getValidVal(nums1, cut1 - 1), right1 = getValidVal(nums1, cut1);
        	int left2 = getValidVal(nums2, cut2 -1), right2 = getValidVal(nums2, cut2);

        	if(left1 > right2) {
        		h = cut1 - 1;
        	} else if(left2 > right1) {
        		l = cut1 + 1;
        	} else {
        		if((n1 + n2) % 2 == 0) {
        			return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0; 
        		} else {
        			return Math.max(left1, left2);
        		}
        	}
        }
        return 0.0;
    }
     /
     		i 		0 	1 	2 	3 	4
     		nums1 = 1 	6	8	10	14
     		nums2 = 30	100

     		n1 = 5, n2 = 2

     		l = 0, h = 4

     		cut1 = 2
     		l1 = 3

     		left1 = 8		right1 = 10
     		left2 = 30		right2 = 100
     / 

     private int getValidVal(int[] nums, int idx) {
     	return idx < 0 ? Integer.MIN_VALUE :
     		   idx >= nums.length ? Integer.MAX_VALUE :
     		   nums[idx];

     }
}