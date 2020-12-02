package com.dalenys.snail;

public class Snail {

    public String compute(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid argument, the input must be > 0 ");
        }

        int count = 1;
        int startIndex = 0;
        int[][] square = new int[n][n];

        if (n == 1) {
            square[0][0] = n;
        }

        while (n >= 2) {

            for (int i = startIndex; i < n; i++) {
                square[startIndex][i] = count++;
            }

            for (int i = startIndex + 1; i < n; i++) {
                square[i][n - 1] = count++;
            }

            for (int i = n - 2; i >= startIndex; i--) {
                square[n - 1][i] = count++;
            }

            for (int i = n - 2; i >= startIndex + 1; i--) {
                square[i][startIndex] = count++;
            }

            n--;
            startIndex++;
        }

        return computeHtmlTable(square);
    }

    private String computeHtmlTable(int[][] table) {
        StringBuilder sb = new StringBuilder("<html><table border=\"1\">");
        for (int[] rows : table) {
            sb.append("<tr>");
            for (int number : rows) {
                sb.append("<td>").append(number).append("</td>");
            }
            sb.append("</tr>");
        }

        return sb.append("</table></html>").toString();
    }
}
