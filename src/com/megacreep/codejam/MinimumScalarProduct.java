package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by megacreep on 2014/10/9.
 */
public class MinimumScalarProduct {

    public long minimumScalar(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        long product = 0;
        for (int i = 0; i < x.length; i++) {
            product += (long) x[i] * y[y.length - 1 - i];
        }
        return product;
    }


    public static void main(String[] args) throws IOException {
        MinimumScalarProduct solution = new MinimumScalarProduct();

        //TODO change dataset name
        String problemName = "A-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= caseCount; i++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                y[j] = scanner.nextInt();
            }
            //TODO solve problem
            long result = solution.minimumScalar(x, y);

            //TODO write back solution
            writer.write("Case #" + i + ": " + result + "\n");
        }

        scanner.close();
        writer.close();
    }
}
