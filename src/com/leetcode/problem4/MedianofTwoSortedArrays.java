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
	    return findKth(nums1, nums2, (m + n) / 2 + 1);
	} else {
	    return findKth(nums1, nums2, (m + n) / 2 + 1) / 2.0
		    + findKth(nums1, nums2, (m + n) / 2) / 2.0;
	}
    }

    public int findKth(int[] array1, int[] array2, int kth) {
	if (array1.length < array2.length) {
	    return findKth(array2, array1, kth);
	}
	if (array2.length == 0) {
	    return array1[kth - 1];
	}
	if (kth == 1) {
	    return Math.min(array1[0], array2[0]);
	}

	int offset2 = Math.min(array2.length, kth / 2);
	int offset1 = kth - offset2;

	if (array1[offset1 - 1] < array2[offset2 - 1]) {
	    int[] array1sub = new int[array1.length - offset1];
	    System.arraycopy(array1, offset1, array1sub, 0, array1sub.length);
	    return findKth(array1sub, array2, kth - offset1);
	} else {
	    int[] array2sub = new int[array2.length - offset2];
	    System.arraycopy(array2, offset2, array2sub, 0, array2sub.length);
	    return findKth(array2sub, array1, kth - offset2);
	}
    }

    @Override
    public void excute() {
	System.out.println("problem 4:");
	int[] num2 = { 1, 2, 4, 4, 5 };
	int[] num1 = { 2, 3, 7, 8 };
	System.out.println(findMedianSortedArrays(num1, num2));
    }

}
