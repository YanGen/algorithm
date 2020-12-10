package com.muhuan.algorithm.leetcode.dialog;

import java.util.ArrayList;

/**
 * @author yg
 * @date 2020/12/8 10:59
 */
public class Convert {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length <= 2||numRows==1) {
            return s;
        }
        char[] array = s.toCharArray();
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }
        for (int i = 0; i < length; i++) {
            // 算出要加入哪一行
            int index = i % (2 * numRows - 2);
            stringBuilders.get(Math.min(2 * numRows - 2-index,index)).append(array[i]);
        }
        StringBuilder ss = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            ss.append(stringBuilder);
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        String s = convert("LEETCODEISHIRING",3);
        System.out.println(s);
    }

}
