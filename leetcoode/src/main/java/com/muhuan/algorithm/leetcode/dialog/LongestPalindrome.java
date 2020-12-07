package com.muhuan.algorithm.leetcode.dialog;

/**
 * @author yg
 * @date 2020/12/3 16:18
 * TODO
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 动态规划：
 *  s为字串 用一个二维数组 dp[i][j] 来记录i,j之间的字串是否为回文字串
 *  那么 dp[i][j] = (dp[i+1][j-1] && s[i]==s[j])
 *  初始状态 长度为奇数时 dp[i][i] = true  偶数时 dp[i][i+1] = (s[i] == s[i+1])
 *  遍历：字串边界 是否越界也应该考虑
 *
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s){
        int sl = s.length();
        String max = "";
        boolean[][] dp = new boolean[sl][sl];

        for (int offset = 0; offset < sl; offset++) {
            for (int i = 0; i + offset < sl; i++) {
                int j = i + offset;
                if (i == j || j - 1 == i) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else  {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                max = dp[i][j]&&offset + 1>max.length() ? s.substring(i,j+1):max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ABCBAA"));
    }
}
