package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by megacreep on 2014/10/9.
 */
public class ReverseWords {

    public String reverse(String line) {
        String[] words = line.split(" ");
        Collections.reverse(Arrays.asList(words));

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        ReverseWords solution = new ReverseWords();

        String problemName = "B-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= caseCount; i++) {
            String line = scanner.nextLine();
            String result = solution.reverse(line);

            writer.write("Case #" + i + ": " + result + "\n");
        }

        scanner.close();
        writer.close();
    }
}
