package com.ggcoke.oj.leetcode;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author Wang Huisong <ggcoke@foxmail.com>
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        int[] nums = {0, 0, 1, 1, 2, 2, 3, 3, 5, 4, 5};

        System.out.println(sn.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int num : nums) {
            if (table.containsKey(num)) {
                table.remove(num);
            } else {
                table.put(num, num);
            }
        }

        int result = 0;
        Iterator it = table.keySet().iterator();
        while (it.hasNext()) {
            result = (Integer) it.next();
        }

        return result;
    }
}
