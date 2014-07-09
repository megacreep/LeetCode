package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] num) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			nums.add(num[i]);
		}
		return permute(nums);
	}
	public List<List<Integer>> permute(List<Integer> nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.size() == 1) {
			List<Integer> perm = new ArrayList<Integer>();
			perm.add(nums.get(0));
			result.add(perm);
		} else {
			for (int i = 0; i < nums.size(); i++) {
				int number = nums.get(i);
				nums.remove(i);
				List<List<Integer>> subResult = permute(nums);
				for (List<Integer> subPerm : subResult) {
					subPerm.add(number);
				}
				result.addAll(subResult);
				nums.add(i, number);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] num = new int[] {1,2,3};
		for (List<Integer> perm : new Permutations().permute(num)) {
			Utils.printArray(perm);
		}
	}
}
