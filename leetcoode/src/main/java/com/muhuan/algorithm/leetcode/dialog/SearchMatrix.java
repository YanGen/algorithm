package com.muhuan.algorithm.leetcode.dialog;

/**
 * @Author: yg
 * @Date: 2020/12/23 16:43
 * @description ...
 * TODO:
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *  思路一： 二叉搜索
 *  选左上角，往右走和往下走都增大，不能选
 *
 * 选右下角，往上走和往左走都减小，不能选
 *
 * 选左下角，往右走增大，往上走减小，可选
 *
 * 选右上角，往下走增大，往左走减小，可选
 *
 * 思路二： 二分搜索
 * 先二分找行 再二分找列
 * 或先二分找列 再二分找行
 *
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}
