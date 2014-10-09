package com.megacreep.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by megacreep on 2014/10/9.
 */
public class Milkshakes {

    private static class Customer implements Comparable<Customer> {

        Map<Integer, Integer> favs;
        int malted;

        Customer() {
            favs = new HashMap<Integer, Integer>();
            malted = 10000;
        }

        void addFav(int x, int y) {
            if (y == 1) {
                malted = x - 1;
            } else {
                favs.put(x - 1, y);
            }
        }

        @Override
        public int compareTo(Customer o) {
            if (this.favs.size() < o.favs.size()) {
                return -1;
            } else if (this.favs.size() > o.favs.size()) {
                return 1;
            } else {
                return malted - o.malted;
            }
        }

        public void removeFav(int malted) {
            this.favs.remove(malted);
        }

        @Override
        public String toString() {
            return malted + " " + favs;
        }
    }

    public int[] function(int n, int m, Customer[] customers) {
        int[] solution = new int[n];
        Arrays.fill(solution, 0);

        HashMap<Integer, List<Customer>> mapping = new HashMap<Integer, List<Customer>>();
        HashMap<Integer, List<Customer>> fuckCustomer = new HashMap<Integer, List<Customer>>();
        for (Customer customer : customers) {
            for (Map.Entry<Integer, Integer> entry : customer.favs.entrySet()) {
                List<Customer> list = mapping.get(entry.getKey());
                if (list == null) {
                    list = new ArrayList<Customer>();
                    mapping.put(entry.getKey(), list);
                }
                list.add(customer);
            }
            if (customer.malted != 10000) {
                if (!fuckCustomer.containsKey(customer.malted)) {
                    fuckCustomer.put(customer.malted, new ArrayList<Customer>());
                }
                fuckCustomer.get(customer.malted).add(customer);
            }
        }

        TreeSet<Customer> customerTreeSet = new TreeSet<Customer>(Arrays.asList(customers));
        while (!customerTreeSet.isEmpty()) {
            Customer customer = customerTreeSet.pollFirst();

            if (customer.favs.size() == 0 && customer.malted != 10000) {
                solution[customer.malted] = 1;
                if (mapping.containsKey(customer.malted)) {
                    for (Customer c : mapping.get(customer.malted)) {
                        customerTreeSet.remove(c);
                        c.removeFav(customer.malted);
                        customerTreeSet.add(c);
                    }
                }
                customerTreeSet.removeAll(fuckCustomer.get(customer.malted));
            } else if (customer.favs.size() > 0) {
                return solution;
            } else {
                return null;
            }
        }
        return solution;
    }


    public static void main(String[] args) throws IOException {
        Milkshakes solution = new Milkshakes();

        //TODO change dataset name
        String problemName = "B-large-practice";
        File input = new File(problemName + ".in");
        Scanner scanner = new Scanner(input);

        File output = new File(problemName + ".out");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= caseCount; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Customer[] customers = new Customer[m];
            for (int j = 0; j < m; j++) {
                int t = scanner.nextInt();
                customers[j] = new Customer();
                for (int k = 0; k < t; k++) {
                    customers[j].addFav(scanner.nextInt(), scanner.nextInt());
                }
            }
            int[] result = solution.function(n, m, customers);

            String resStr;
            if (result == null) {
                resStr = "IMPOSSIBLE";
            } else {
                resStr = concats(result);
            }
            writer.write("Case #" + i + ": " + resStr + "\n");
        }

        scanner.close();
        writer.close();
    }

    private static String concats(int[] array) {
        StringBuilder sb = new StringBuilder();
        int iMax = array.length - 1;
        if (iMax >= 0) {
            for (int i = 0; ; i++) {
                sb.append(array[i]);
                if (i == iMax) {
                    break;
                }
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
