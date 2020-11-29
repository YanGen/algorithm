package com.muhuan.algorithm.leetcode.dialog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muhuan
 * @date 2020/11/29 13:28
 * @description ...
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Twosum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int find = target - num;
            if (cache.containsKey(find)) {
                return new int[]{cache.get(find),i};
            }
            cache.put(num,i);

        }
        return null;
    }
    public static void main(String[] args) {
        int []nums = new int[]{2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(nums,target)));
        

    }
}
