package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by megacreep on 2014/10/9.
 */
public class StoreCredit {

    public int[] findItem(int[] prices, int target) {

        Map<Integer, Integer> priceMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < prices.length; i++) {
            if (priceMap.containsKey(target - prices[i])) {
                return new int[]{priceMap.get(target - prices[i]) + 1, i + 1};
            }
            priceMap.put(prices[i], i);
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) throws IOException {
        StoreCredit solution = new StoreCredit();

        String problemName = "A-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = scanner.nextInt();
        for (int i = 1; i <= caseCount; i++) {
            int credit = scanner.nextInt();
            int itemCount = scanner.nextInt();
            int[] prices = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                prices[j] = scanner.nextInt();
            }
            int[] result = solution.findItem(prices, credit);
            writer.write("Case #" + i + ": " + result[0] + " " + result[1] + "\n");
        }

        scanner.close();
        writer.close();
    }
}
