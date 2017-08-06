/**
 * Project description
 * com.leetcode.problem4
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
package com.leetcode.problem4;

import com.leetcode.main.MainInterface;

/**
 * @author nixianmiao
 * @date 2017年8月6日
 */
public class MedianofTwoSortedArrays implements MainInterface {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int m = nums1.length, n = nums2.length;
	if ((m + n) % 2 == 1) {
	    return findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
	} else {
	    return findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1) / 2.0
		    + findKth(nums1, 0, nums2, 0, (m + n) / 2) / 2.0;
	}
    }

    public int findKth(int[] array1, int start1, int[] array2, int start2, int kth) {
	if (array1.length - start1 < array2.length - start2) {
	    return findKth(array2, start2, array1, start1, kth);
	}
	if (start2 == array2.length) {
	    return array1[start1 + kth - 1];
	}
	if (kth == 1) {
	    return Math.min(array1[start1], array2[start2]);
	}
	int offset2 = Math.min(array2.length - start2, kth / 2);
	int offset1 = kth - offset2;
	if (array1[start1 + offset1 - 1] < array2[start2 + offset2 - 1]) {
	    return findKth(array1, start1 + offset1, array2, start2, kth - offset1);
	} else {
	    return findKth(array1, start1, array2, start2 + offset2, kth - offset2);
	}
    }

    @Override
    public void excute() {
	System.out.println("problem 4:");
	int[] num2 = { 1, 4, 4 };
	int[] num1 = { 2, 3 };
	System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(num1, num2));
    }

}
