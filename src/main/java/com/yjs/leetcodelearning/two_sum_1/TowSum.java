package com.yjs.leetcodelearning.two_sum_1;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * create by jiangsongy on 2019/3/26
 */
public class TowSum {

	/**
	 * 时间复杂度O(n2)
	 * 空间复杂度O(1)
	 */
	static int[] twoSum0(int[] nums, int target) {
		int[] result =new int[2];
		for(int i=0;i < nums.length;i++) {
			for(int j = i+1;j < nums.length;j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 */
	static int[] twoSum1(int[] nums, int target) {
		Map<Integer,Integer> map = Maps.newHashMap();
		for (int i = 0; i < nums.length; i++) {
			int differenceValue = target - nums[i];
			if (map.containsKey(differenceValue)) {
				return new int[]{i,map.get(differenceValue)};
			}
			map.put(nums[i],i);
		}
		throw new RuntimeException("不存在");
	}


	public static void main(String[] args) {
		int[] nums = new int[]{2,7,11,15};
		int target = 9;
//		int[] ints = twoSum0(nums, target);
		int[] ints = twoSum1(nums, target);

		System.out.println(ints[0]);
		System.out.println(ints[1]);
	}
}
