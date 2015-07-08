package com.ggcoke.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Huisong <ggcoke@foxmail.com>
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();

        List<List<Integer>> result = pascalsTriangle.generate(5);
        if (result != null) {
            for (List<Integer> list : result) {
                for (int item : list) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }

        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return result;
        }

        for (int row = 0; row < numRows; row++) {
            int maxColumn = row + 1;
            List<Integer> rowContent = new ArrayList<Integer>();

            if (row == 0) {
                rowContent.add(1);
            } else {
                List<Integer> lastRow = result.get(row - 1);
                rowContent.add(lastRow.get(0));
                for (int column = 1; column < maxColumn - 1; column++) {
                    rowContent.add(lastRow.get(column - 1) + lastRow.get(column));
                }
                rowContent.add(lastRow.get(lastRow.size() - 1));
            }

            result.add(rowContent);
        }

        return result;
    }
}
