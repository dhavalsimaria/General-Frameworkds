/**
 * 
 */
package com.dhaval.general;

import java.util.Scanner;

/**
 * @author Dhaval
 *
 */
public class EditDistance {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter first word: ");
        String word1 = scn.nextLine();

        System.out.println("Enter second word: ");
        String word2 = scn.nextLine();

        int dist = minDist(word1, word2);

        double longer, smaller;

        if (word1.length() > word2.length()) {
            longer = word1.length();
            smaller = word2.length();
        } else {
            longer = word2.length();
            smaller = word1.length();
        }

        System.out.println("Minimum edit distance is: " + dist);

        double percent = ((longer - dist) / (double) longer);

        System.out.println("Percentage similarity: " + percent);
    }

    public static int minDist(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i + 1][j] + 1;
                    int delete = dp[i][j + 1] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[len1][len2];
    }
}
