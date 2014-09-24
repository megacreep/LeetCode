package com.megacreep.LeetCode;

import java.util.*;

public class LevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}

        List<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);

        List<TreeNode> nextLevel = new ArrayList<TreeNode>();


        while (!current.isEmpty()) {
            List<Integer> levelResult = new ArrayList<Integer>();
            for (TreeNode node : current) {
                levelResult.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(0, levelResult);
            current = nextLevel;
            nextLevel = new ArrayList<TreeNode>();
        }

        return result;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		List<List<Integer>> result = new LevelOrderTraversalII().levelOrderBottom(root);
		for (List<Integer> line : result) {
			Utils.printArray(line);
		}
	}
}
