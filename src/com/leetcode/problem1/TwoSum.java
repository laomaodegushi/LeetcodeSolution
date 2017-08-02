
package com.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.main.MainInterface;

public class TwoSum implements MainInterface {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		int length = nums.length;
		Map<Integer, Integer> arrayMap = new HashMap<>(length);
		for (int i = 0; i < length; i++) {
			if (arrayMap.containsKey(target - nums[i])) {
				result[0] = arrayMap.get(target - nums[i]) + 1;
				result[1] = i + 1;
				return result;
			}
			if (!arrayMap.containsKey(nums[i])) {
				arrayMap.put(nums[i], i);
			}
		}
		return null;
	}

	/* @see com.leetcode.main.MainInterface#excute()
	 */
	@Override
	public void excute() {
		System.out.println("problem 1 :");
		int[] nums = {2, 7, 11, 15};
		int[] result = new TwoSum().twoSum(nums, 9);
		if (result == null) {
			System.out.println("未找到匹配项");
		}
		System.out.println("位置分别为" + result[0] + "和" + result[1]);
		
	}

}
