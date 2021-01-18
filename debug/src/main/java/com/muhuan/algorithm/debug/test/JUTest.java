package com.muhuan.algorithm.debug.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: yg
 * @Date: 2020/12/24 16:21
 * @description ...
 * TODO:
 */
public class JUTest {
    public static void main(String[] args) {

        int[] nums = new int[]{2,4,6,3,4,6,7,4,2};
        // 升序排序 可以从start 到 end 进行排序
        Arrays.sort(nums);
        // 打印数组
        String s = Arrays.toString(nums);
        System.out.println(s);
        // 深层次打印数组
        int[][]nums2 = new int[][]{{2,3},{3,4},{2,3}};
        String s1 = Arrays.toString(nums2);
        String s2 = Arrays.deepToString(nums2);
        System.out.println(s1);
        System.out.println(s2);
        // 两层以上自定义排序规则
        Arrays.sort(nums2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 第一个相等对比第二个
                return o1[0] != o2[0]?o1[0] - o2[0]:o1[1] - o2[1];
            }
        });
        String s3 = Arrays.deepToString(nums2);
        System.out.println(s3);
    }
}
