package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.reflect.generics.tree.Tree;

/**
 * Created by megacreep on 2014/9/29.
 */
public class UniqueBSTII {

    private List<TreeNode>[][] cache;

    public List<TreeNode> generateTrees(int n) {
        cache = new List[n + 1][n + 1];

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        if (cache[start][end] != null) {
            return cache[start][end];
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        cache[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        for (TreeNode root : new UniqueBSTII().generateTrees(3)) {
            Utils.printTree(root);
            System.out.println();
        }
    }
}
