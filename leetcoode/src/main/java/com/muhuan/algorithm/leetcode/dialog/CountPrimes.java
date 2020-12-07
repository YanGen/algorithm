package com.muhuan.algorithm.leetcode.dialog;

/**
 * @author yg
 * @date 2020/12/3 15:40
 * TODO
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 质数
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        //dp 新建一个bs 都是false
        boolean[] bs = new boolean[n];
        for (int cur = 2; cur < n; cur++) {
            // 2
            if (!bs[cur]) {
                // 能进来的都是质数
                count += 1;
                // 这个数的倍数永远不是质数 在这里排除掉 关键点:后面的非质数可在前面dp过程中倍乘得出
                // 这个for 将n范围内的cur的倍数全部标注为非质数 上一层循环走到时不会进来
                for (int aft = cur*2;aft<n;aft+=cur){
                    bs[aft] = true;
                }
            }
        }
        return count;
    }
}
