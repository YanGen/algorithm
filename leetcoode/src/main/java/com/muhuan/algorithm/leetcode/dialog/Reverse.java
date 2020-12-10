package com.muhuan.algorithm.leetcode.dialog;

/**
 * @author yg
 * @date 2020/12/8 16:47
 */
public class Reverse {
    public static int reverse(int x) {
        if (Math.abs(x) < 10) {
            return x;
        }
        boolean f = x < 0;
        String s = String.valueOf(Math.abs(x));
        char[] chars = s.toCharArray();
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        int r;
        try {
            r = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){
            return 0;
        }
        r = f?-r:r;
        System.out.println(r);

        return r>= 2147483647|| r<=-2147483648?0:r;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

}
