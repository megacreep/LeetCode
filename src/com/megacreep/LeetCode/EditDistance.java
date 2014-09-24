package com.megacreep.LeetCode;

/**
 * Created by limy on 14-9-24.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int[][] distance = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            distance[0][j] = j;
        }

        for (int j = 1; j <= word2.length(); j++) {
            for (int i = 1; i <= word1.length(); i++) {
                int min = distance[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    min++;
                }
                min = Math.min(min, Math.min(distance[i][j - 1], distance[i - 1][j]) + 1);
                distance[i][j] = min;
            }
        }

        return distance[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "";
        String word2 = "tst2";

        System.out.println(new EditDistance().minDistance(word1, word2));
    }
}
