package com.muhuan.algorithm.leetcode.dialog;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yg
 * @date 2020/12/1 16:48
 * TODO
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 双指针，一前一后，前指针一直向前，每走一步判断当前字符是否与当前子串重复
 * 若重复，后指针一直走到重复字符后面，后指针移动时肯定子串越来越短，不用更新最大长度。
 */
public class LengthOfLongestSubstring {
    // 滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet();
        // 前指针
        int bef = 0;
        // 后指针
        int aft = 0;
        while (aft < s.length()) {
            char ac = s.charAt(aft);
            char bc = s.charAt(bef);
            if (set.contains(ac)) {
                // 前后相同
                if (bef+1 == aft) {
                    // 后一位刚好在前一位后面（挨着） 都 +1
                    aft += 1;
                }else {
                    // 前后指针不挨着 则删除后指针对应set中的字符并前进一位
                    set.remove(bc);
                }
                bef += 1;
            }else {
                // 不同后指针接着走
                set.add(ac);
                max = Math.max(max,set.size());
                // 起始位置相同 初始化前后位置
                aft += 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int r = lengthOfLongestSubstring("dvdf");
        System.out.println(r);
    }
}
