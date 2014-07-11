package com.megacreep.LeetCode;

import java.util.*;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		TreeNode anchor = new TreeNode(-1);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(anchor);
		List<Integer> currentLevel = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == anchor) {
				result.add(currentLevel);
				if (queue.isEmpty()) {
					break;
				}
				queue.offer(anchor);
				currentLevel = new ArrayList<Integer>();
			} else {
				currentLevel.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		List<List<Integer>> result = new LevelOrderTraversal().levelOrder(root);
		for (List<Integer> line : result) {
			Utils.printArray(line);
		}
	}
}
