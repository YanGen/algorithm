package com.muhuan.algorithm.leetcode.dialog;

import java.util.HashMap;

/**
 * @author yg
 * @date 2020/12/4 10:15
 * TODO
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 中心思想：
 * 贪心策略 让数据尽可能的吃大吃多(条件① 往前拼) 但是这样会让数组 [1,2,3,3,4,5] 得出 [1,2,3,4,5] 和[3] 这样的结果
 * 所以在走到3的时候不能搁下 拼凑长串(贪心策略)是我们的美好愿望 但无主的3也有自身生存发展的权力 落下3的话就不会达到共同富裕的结果(返回true)
 * 所以3往后吃两位 保证自身能拼成长度大于2的数组(条件② 往后吃吃的到)
 * 但是在3往后吃的时候吃不到 这时候只能返回 false(条件③ 往后吃吃不到)
 *
 */
public class IsPossible {
    public static boolean isPossible(int[] nums) {
        // 用来记录多少个以次元素结尾的数组数量 map = 1:2 时 表示以1结尾的数组有两个
        HashMap<Integer,Integer> log = new HashMap<>();
        // 记录元素出现次数
        HashMap<Integer,Integer> count = new HashMap<>();

        for (int num : nums) {
            int c = count.getOrDefault(num,0) + 1;
            count.put(num,c);
        }

        for (int num : nums) {
            // 如果这个数在前面被消耗为0那么跳过遍历
            int c = count.getOrDefault(num, 0);
            if (c == 0) {
                continue;
            }
            int pre = log.getOrDefault(num - 1,0);
            int cur = log.getOrDefault(num,0);
            if (pre > 0) {
                // 前面有 以nums[ap]-1结尾的的串 有则加入并消耗当前元素出现次数和字串数
                log.put(num- 1,pre-1);
                log.put(num,cur + 1);
                count.put(num,c-1);
            }else {
                // 往前找不到的话 新建长度为3的数组并消耗
                int numAdd1 = count.getOrDefault(num + 1, 0);
                int numAdd2 = count.getOrDefault(num + 2, 0);
                if (numAdd1 > 0 && numAdd2 > 0) {
                    count.put(num,c-1);
                    count.put(num + 1,numAdd1-1);
                    count.put(num + 2,numAdd2 -1);
                    log.put(num + 2,log.getOrDefault(num + 2,0)+1);
                }else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,3,4,4,5,5,5};
        System.out.println(isPossible(a));
    }
}
