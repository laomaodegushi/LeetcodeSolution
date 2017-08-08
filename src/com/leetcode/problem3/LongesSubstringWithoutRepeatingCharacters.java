/**
 * Project description
 * com.leetcode.problem3
 */
package com.leetcode.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    
    public List<String> longestSubstringWithoutRepeating(String s) {
	Set<Integer> startLocation = new HashSet<Integer>(0);
	int maxLength = 0, lastWithoutRepeatLocation = 0;
	Map<Character, Integer> hashMap = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    if (hashMap.containsKey(ch) && hashMap.get(ch) >= lastWithoutRepeatLocation) {
		int length = i - lastWithoutRepeatLocation;
		if (maxLength < length) {
		    maxLength = length;
		    startLocation.clear();
		    startLocation.add(lastWithoutRepeatLocation);
		} else if (maxLength == length){
		    startLocation.add(lastWithoutRepeatLocation);
		}
		lastWithoutRepeatLocation = hashMap.get(ch) + 1;
	    }
	    hashMap.put(ch, i);
	}
	if (maxLength < (s.length() - lastWithoutRepeatLocation)) {
	    maxLength = s.length() - lastWithoutRepeatLocation;
	    startLocation.clear();
	    startLocation.add(lastWithoutRepeatLocation);
	} else if (maxLength == (s.length() - lastWithoutRepeatLocation)){
	    startLocation.add(lastWithoutRepeatLocation);
	}
	
	List<String> result = new ArrayList<String>();
	for (Integer start : startLocation) {
	    result.add(s.substring(start, start + maxLength));
	}
	return result;
    }

    @Override
    public void excute() {
	System.out.println("problem 3 :");
	String string = "abbdaseedaksdhcnuiii23904821kj";
	System.out.println(lengthOfLongestSubstring(string));
	System.out.println(longestSubstringWithoutRepeating(string));
    }

}
