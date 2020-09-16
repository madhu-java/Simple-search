package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        String menu = "=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit\n";
        System.out.println("Enter the number of people:");
        int numberOfLines = scanner.nextInt();
        Set<String> lines = new HashSet<>();
        scanner.nextLine();
        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfLines; i++) {
            lines.add(scanner.nextLine());
        }
        System.out.println();
        boolean exit = false;
        while (!exit) {
            System.out.println(menu);
            int menuOPtion = scanner.nextInt();
            System.out.println();
            if (menuOPtion < 0 || menuOPtion > 2) {
                System.out.println("Incorrect option! Try again.\n");
                continue;
            }
            scanner.nextLine();
            switch (menuOPtion) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    String word = scanner.next();
                    scanner.nextLine();
                    find(word, lines);
                    break;
                case 2:
                    printAllPeople(lines);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Bye!");
                    break;

            }
        }
    }
//print all people entered
    public static void printAllPeople(Set<String> lines) {
        lines.forEach(System.out::println);
    }
//print the lines with matching words
    public static void find(String word, Set<String> lines) {
        int counter = 0;
        ArrayList<String> foundLines = new ArrayList<>();
        int found = 0;

        lines.forEach(line -> {
            if (line.toLowerCase().contains(word.toLowerCase())) {
                foundLines.add(line);
                // found++;
            }
        });

        if (foundLines.size() == 0) {
            System.out.println("unknown\nNo matching people found.");
        } else {
            // System.out.println("Found people:");
            foundLines.forEach(System.out::println);
        }

    }
}
