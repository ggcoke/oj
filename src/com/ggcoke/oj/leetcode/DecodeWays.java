package com.ggcoke.oj.leetcode;

/**
 * @author GGCoke <ggcoke@foxmail.com>
 */
public class DecodeWays {
    public static void main(String[] args) {

        String s = "123";
        int result = numDecodings(s);
        System.out.println(result);
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() <= 0 || s.charAt(0) == '0') {
            return 0;
        }

        int f1 = 1;
        int f2 = 1;
        int f3 = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char lastChar = s.charAt(i - 1);

            if (c == '0') {
                if (lastChar == '1' || lastChar == '2') {
                    // 0前为1,2时只有两个数字组合这一种情况,不可能是单个数字
                    f3 = f1;
                } else {
                    // 没有对应的字母
                    return 0;
                }
            } else {
                if (lastChar == '0' || lastChar > '2') {
                    // 只能是单个数字的情况,不可能是两个数字的组合
                    f3 = f2;
                } else {
                    if (lastChar == '2' && c > '6' && c <= '9') {
                        // 只能是单个数字的情况,不可能是两个数字的组合
                        f3 = f2;
                    } else {
                        // 既可能是单个数字,也可能是两个数字组合
                        f3 = f1 + f2;
                    }
                }
            }

            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
