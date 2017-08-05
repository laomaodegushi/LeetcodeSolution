/**
 * Project description
 * com.leetcode.problem3
 */
package com.leetcode.problem3;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.main.MainInterface;

/**
 * @author nixianmiao
 * @date 2017年8月6日
 */
public class LongesSubstringWithoutRepeatingCharacters implements MainInterface {
    public int lengthOfLongestSubstring(String s) {
	Map<Character, Integer> hashMap = new HashMap<>();
	int maxLength = 0, lastWithoutRepeatLocation = 0;
	for (int i = 0; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    if (hashMap.containsKey(ch) && hashMap.get(ch) >= lastWithoutRepeatLocation) {
		int length = i - lastWithoutRepeatLocation;
		maxLength = Math.max(maxLength, length);
		lastWithoutRepeatLocation = hashMap.get(ch) + 1;
	    }
	    hashMap.put(ch, i);
	}
	return Math.max(maxLength, s.length() - lastWithoutRepeatLocation);
    }

    @Override
    public void excute() {
	System.out.println("problem 3 :");
	String string = "aba!@#!@3123$32 cdfr";
	LongesSubstringWithoutRepeatingCharacters demo = new LongesSubstringWithoutRepeatingCharacters();
	System.out.println(demo.lengthOfLongestSubstring(string));
    }

}
