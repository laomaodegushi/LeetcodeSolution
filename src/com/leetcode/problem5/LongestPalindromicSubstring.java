/**
 * Project description
 * com.leetcode.problem5
 */
package com.leetcode.problem5;

import com.leetcode.main.MainInterface;

/**
 * @author nixianmiao
 * @date 2017年8月8日
 */
public class LongestPalindromicSubstring implements MainInterface {
    public String longestPalindrome(String s) {
	int maxlength = 0;
	String result = "";
	if (s == null || s.trim().length() == 0) {
	    return result;
	}
	for (int i = 1; i < 2 * (s.length()); i++) {
	    int count = 1;
	    while ((i - count) >= 0 && (i + count) <= 2 * s.length()
		    && getChar(s, i - count) == getChar(s, i + count)) {
		count++;
	    }
	    count--;
	    if (maxlength < count) {
		maxlength = count;
		result = s.substring((i - count) / 2, (i + count) / 2);
	    }
	}
	return result;
    }

    private char getChar(String s, int index) {
	//  #a#b#b#a#
	if (index % 2 == 0) {
	    return '#';
	} else {
	    return s.charAt(index / 2);
	}
    }

    @Override
    public void excute() {
	System.out.println("problem 5:");
	String s = "abuiiuba3443";
	System.out.println("原字符串  ：" + s);
	System.out.println("最长对称字符串  ：" + longestPalindrome(s));
	
    }
}
