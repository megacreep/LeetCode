package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by megacreep on 2014/10/9.
 */
public class Template {

    public String function() {
        //TODO implementation

        return null;
    }


    public static void main(String[] args) throws IOException {
        Template solution = new Template();

        //TODO change dataset name
        String problemName = "A-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= caseCount; i++) {

            //TODO parse input file
            int credit = scanner.nextInt();
            int itemCount = scanner.nextInt();
            int[] prices = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                prices[j] = scanner.nextInt();
            }

            //TODO solve problem
            String result = solution.function();

            //TODO write back solution
            writer.write("Case #" + i + ": " + result + "\n");
        }

        scanner.close();
        writer.close();
    }
}
