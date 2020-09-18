package search;

import java.util.ArrayList;
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
        ArrayList<String> lines;
        if(args.length==0) {
            ReadFromStdIn readFromStdIn = new ReadFromStdIn();
           readFromStdIn.readFromInput();
           lines=readFromStdIn.getLines();
        }else {
            ReadFromFile readFromFile = new ReadFromFile(args);
            readFromFile.readFile();
            lines=readFromFile.getLines();
        }
        //using strategy pattern
        Contex_SearchLines contex_searchLines ;
        //if you want to use invertedindex searhing
        contex_searchLines= new Contex_SearchLines(new InvertedIndexFind());
        //if you want to use the normal search
        //contex_searchLines = new Contex_SearchLines(new NormalSerachFind());
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
                    contex_searchLines.find(word, lines);
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
    public static void printAllPeople(ArrayList<String> lines) {
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
