package com.muhuan.algorithm.leetcode.dialog;

import java.math.BigInteger;

public class MyAtoi {
    public static int myAtoi(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean append = false;
        for (char c : s.trim().toCharArray()) {
            boolean digit = Character.isDigit(c);
            // 不是数字但已经开始
            if (!digit && append||!digit &&c != '-'&&c!='+') {
                break;
            }

            stringBuilder.append(c);
            append = true;
        }
        String s1 = stringBuilder.toString();
        if (! append ||s1.equals("-")||s1.equals("+")) {
            return 0;
        }
        int r;
        if (s1.charAt(0) == '-') {
            r = new BigInteger(s1).compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) == -1 ? Integer.MIN_VALUE : Integer.parseInt(s1);
        }else {
            r = new BigInteger(s1).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1  ? Integer.MAX_VALUE : Integer.parseInt(s1);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }
}
