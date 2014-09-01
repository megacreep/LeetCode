package com.megacreep.LeetCode;


public class SurroundedRegion {
    int[] unionSet;
    boolean[] hasEdgeO;
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int height = board.length;
        int width = board[0].length;
        
        unionSet = new int[height * width];
        hasEdgeO = new boolean[unionSet.length];
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
            int x = i / width;
            int y = i % width;
            if (x == 0 || x == height - 1 || y == 0 || y == width - 1) {
                hasEdgeO[i] = board[x][y] == 'O';
            } else {
                hasEdgeO[i] = false;
            }
        }
        
        for (int i  = 0; i < unionSet.length; i++) {
            int x = i / width;
            int y = i % width;
            int up = x - 1;
            int left = y - 1;
            if (up >= 0 && board[x][y] == board[up][y]) {
                union(i, i - width);
            }
            if (left >= 0 && board[x][y] == board[x][left]) {
                union(i, i - 1);
            }
        }
        
        for (int i = 0; i < unionSet.length; i++) {
            int x = i / width;
            int y = i % width;
            if (board[x][y] == 'O' && !hasEdgeO[find(i)]) {
                board[x][y] = 'X';
            }
        }
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        boolean newO = hasEdgeO[rootX] || hasEdgeO[rootY];
        unionSet[rootX] = rootY;
        hasEdgeO[rootY] = newO;
    }
    private int find(int x) {
        if (unionSet[x] != x) {
            unionSet[x] = find(unionSet[x]);
        }
        return unionSet[x];
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        
        new SurroundedRegion().solve(board);
        Utils.printMatrix(board);
        
        
    }

}
