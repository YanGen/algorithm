package com.muhuan.algorithm.leetcode.dialog;

/**
 * @Author: yg
 * @Date: 2020/12/22 15:48
 * @description ...
 * TODO:
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * 解：使用位运算。对于这道题，可使用异或运算 \oplus⊕。异或运算有以下三个性质。
 *
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        // 异或运算满足交换律和结合律
        //任何数和 0 做异或运算，结果仍然是原来的数 所以初始值为0无影响
        int single = 0;
        // 任何数和其自身做异或运算，结果是 0，即 a⊕a=0
        // 题目给的是 除了某个元素只出现一次以外，其余每个元素均出现两次，所以一轮循环下来成对出现的数会被抵消，剩下一个单独的数
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{1});
    }
}
