package com.yjs.leetcodelearning.longest_subString_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长无重复子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * create by jiangsongy on 2019/3/28
 */
public class LongestSubString {

	/**
	 * 暴力法
	 */
	public static int lengthOfLongestSubstring0(String s) {
		int length = s.length();
		int maxSub = 0;
		for(int i=0;i<length;i++) {
			for(int j=i+1;j<=length;j++){
				if(isUnique(s,i,j)) {
					maxSub = maxSub > (j-i) ? maxSub : (j-i);
				}
			}
		}
		return maxSub;
	}
	/**
	 * 暴力法
	 */
	public static boolean isUnique(String s,int start,int end) {
		Set<Character> set = new HashSet<>();
		for(int i=start;i<end;i++) {
			if (set.contains(s.charAt(i))) {
				return false;
			}
			set.add(s.charAt(i));
		}
		return true;
	}

	/**
	 * 优化滑动窗口
	 */
	public static int lengthOfLongestSubstring1(String s) {
		int length = s.length();
		int maxSub = 0;
		int i=0,j=0;
		Map<Character,Integer> map = new HashMap();
		while (j<length) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i,map.get(s.charAt(j)));
			}
			maxSub = Math.max(maxSub,j-i+1);
			map.put(s.charAt(j),j+1);
			j++;
		}
		return maxSub;
	}

	public static void main(String[] args) {
		String s = "\"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOP";
		System.out.println(lengthOfLongestSubstring0(s));
		System.out.println(lengthOfLongestSubstring1(s));



	}
}
