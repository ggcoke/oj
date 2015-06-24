package com.ggcoke.oj.leetcode;

/**
 * @author GGCoke <ggcoke@foxmail.com>
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        int result = climbStairs(n);
        System.out.println(result);

    }

    private static int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;

        if (n == 1) {
            return f1;
        }
        if (n == 2) {
            return f2;
        }

        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
