package com.megacreep.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by limy on 14-9-23.
 */
public class TwoSum {

    //This solution can't deal with duplicate numbers...
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            map.remove(numbers[i]);
            if (map.containsKey(target - numbers[i])) {
                result[0] = i + 1;
                result[1] = map.get(target - numbers[i]) + 1;
                if (result[0] == result[1]) {
                    continue;
                }
                break;
            }
        }
        return result;
    }

    public int[] twoSum_sort(int[] numbers, int target) {
        int[] tempNum = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(tempNum);
        int start = 0;
        int end = tempNum.length - 1;
        while (start < end) {
            int sum = tempNum[start] + tempNum[end];
            if (sum == target) {
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0; i < numbers.length && (result[0] == -1 || result[1] == -1 ); i++) {
            if (result[0] == -1 && numbers[i] == tempNum[start]) {
                result[0] = i;
                continue;
            }
            if (result[1] == -1 && numbers[i] == tempNum[end]) {
                result[1] = i;
            }
        }
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        result[0]++;
        result[1]++;
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 4, 3, 0};
        int target = 0;
        Utils.printArray(new TwoSum().twoSum(numbers, target));
    }
}
