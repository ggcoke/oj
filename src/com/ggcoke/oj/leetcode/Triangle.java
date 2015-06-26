package com.ggcoke.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Huisong <wanghuisong@letv.com>
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int length = triangle.size();

        int[] m = new int[length];

        for (int i = 0; i < length; i++) {
            m[i] = triangle.get(length - 1).get(i);
        }

        for (int i = length - 2; i > -1; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                m[j] = Math.min(m[j], m[j + 1]) + triangle.get(i).get(j);
            }
        }

        return m[0];
    }

    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        List<Integer> a3 = new ArrayList<Integer>();
        List<Integer> a4 = new ArrayList<Integer>();

        a1.add(2);
        a2.add(3); a2.add(4);
        a3.add(6); a3.add(5); a3.add(7);
        a4.add(4); a4.add(1); a4.add(8); a4.add(3);

        List<List<Integer>> a = new ArrayList<List<Integer>>();
        a.add(a1); a.add(a2); a.add(a3); a.add(a4);

        int result = minimumTotal(a);
        System.out.println(result);
    }
}
