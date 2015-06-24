package com.ggcoke.oj.leetcode;

/**
 * @author GGCoke <ggcoke@foxmail.com>
 * 设 f(n) 为n个数字时的BST数量，则 f(0) = 1, f(1) = 1 <br/>
 * 在计算f(n)时，依次取各个数字作为根节点(假设数字为1，2 … n) <br/>
 *  - 1（或最小数字）为根节点时，左子树的数目为f(0),右子树的数目为f(n-1)<br/>
 *  - 2（次小数字）为根节点时，左子树个数为f(1)，右子树个数为f(n-2)<r/>
 *  - 依次类推，n（最大数字）为根节点时左子树个数为f(n-1)，右子树个数为f(0)<br/>
 * 以i为根节点时BST的个数为 左子树个数*右子树个数 <br/>
 * 综上，f(n) = f(0)*f(n-1) + f(1)*f(n-2) + … + f(n-2)*f(1) + f(n-1)*f(0)
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int result = numTrees(n);
        System.out.println(result);
    }

    public static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] counts = new int[n + 1];
        counts[0] = 1;

        for (int i = 1; i <= n; i++) {
            counts[i] = 0;
            for (int j = 0; j < i; j++) {
                counts[i] += counts[j] * counts[i - j - 1];
            }
        }

        return counts[n];

    }
}
