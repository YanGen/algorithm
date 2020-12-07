package com.muhuan.algorithm.leetcode.dialog;

/**
 * @author yg
 * @date 2020/12/3 11:07
 * TODO
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 题目要求时间复杂度 log(m +n ) 思路应该是要定义双指针 各自二分法确定位置 我懒得写
 * 下面是归并排序 统一到一个a + b /2 长度的数组 时间复杂度 m + n
 *
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int al = nums1.length;
        int bl = nums2.length;
        int tl = (al + bl)/2 + 1;
        System.out.println(tl);
        // 用来存放合并数据
        double[] rs = new double[tl];
        // ap num1指针 bp num2指针 rp 结果数组的指针
        int ap =0,bp=0,rp=0;
        // 存储结果数据的指针越过则跳出
        while (rp < tl){
            // a越界了直取b
            if (ap == al) {
                rs[rp] = nums2[bp];
                bp += 1;
            }else if (bp == bl){
                rs[rp] = nums1[ap];
                ap += 1;
            }else {
                // 都不越界取 <=
                if (nums1[ap] <= nums2[bp]) {
                    rs[rp] = nums1[ap];
                    ap += 1;
                }else {
                    rs[rp] = nums2[bp];
                    bp += 1;
                }
            }
            rp += 1;
        }
        return (al + bl) % 2==0?(rs[tl-1]+rs[tl-2])/2:rs[tl-1];
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        double v = findMedianSortedArrays(a, b);
        System.out.println(v);
    }
}
