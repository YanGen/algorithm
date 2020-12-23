package com.muhuan.algorithm.leetcode.dialog;

/**
 * @Author: yg
 * @Date: 2020/12/23 11:34
 * @description ...
 * TODO:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 思路：
 *      部落冲突的混战
 *      如果遇到不同那就1：1消耗 剩下最后的就是最多的
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int cache = 0;
        int cacheNum = 0;
        for (int num : nums) {
            // 第一次进 或者 消耗为0 重新置排头兵
            if (cacheNum == 0) {
                cache = num;
            }
            if (cache == num) {
                // 加一
                cacheNum ++;
            }else {
                // 消耗1
                cacheNum --;
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        int i = majorityElement(new int[]{2, 3, 2});
        System.out.println(i);
    }
}
