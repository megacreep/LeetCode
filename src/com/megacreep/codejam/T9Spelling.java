package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class T9Spelling {

    private static final String[] mapping = {
            "2",
            "22",
            "222",
            "3",
            "33",
            "333",
            "4",
            "44",
            "444",
            "5",
            "55",
            "555",
            "6",
            "66",
            "666",
            "7",
            "77",
            "777",
            "7777",
            "8",
            "88",
            "888",
            "9",
            "99",
            "999",
            "9999"
    };

    public String spell(String message) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            String toAppend;
            if (message.charAt(i) == ' ') {
                toAppend = "0";
            } else {
                toAppend = mapping[message.charAt(i) - 'a'];
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == toAppend.charAt(0)) {
                sb.append(' ');
            }
            sb.append(toAppend);
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        T9Spelling solution = new T9Spelling();

        //TODO change dataset name
        String problemName = "C-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= caseCount; i++) {
            String message = scanner.nextLine();
            String result = solution.spell(message);

            writer.write("Case #" + i + ": " + result + "\n");
        }

        scanner.close();
        writer.close();
    }
}
