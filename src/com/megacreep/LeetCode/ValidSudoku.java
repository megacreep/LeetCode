package com.megacreep.LeetCode;

import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] lineFlag = new int[board.length];
        int[] rowFlag = new int[board.length];
        int[] cellFlag = new int[board.length];
        Arrays.fill(lineFlag, 0);
        Arrays.fill(rowFlag, 0);
        Arrays.fill(cellFlag, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int flag = 1 << (board[i][j] - '1');
                if ((lineFlag[i] & flag) != 0 || (rowFlag[j] & flag) != 0 || (cellFlag[i / 3 * 3 + j / 3] & flag) != 0) {
                    return false;
                } else {
                    lineFlag[i] |= flag;
                    rowFlag[j] |= flag;
                    cellFlag[i / 3 * 3 + j / 3] |= flag;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][] {
                "....5..1.".toCharArray(),
                ".4.3.....".toCharArray(),
                "........1".toCharArray(),
                "8......2.".toCharArray(),
                "..2.7....".toCharArray(),
                ".15......".toCharArray(),
                ".....2...".toCharArray(),
                ".2.9.....".toCharArray(),
                "..4......".toCharArray()};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
