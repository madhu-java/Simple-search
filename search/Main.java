package search;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int numberOfLines = scanner.nextInt();
        String[] lines = new String[numberOfLines];
        scanner.nextLine();
        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfLines; i++) {
            lines[i]=(scanner.nextLine());
        }
        System.out.println();
        System.out.println("Enter the number of search queries:");
        int numberOfSearches = scanner.nextInt();
        scanner.nextLine();
        for (int j = 1; j <= numberOfSearches; j++) {
            System.out.println("\nEnter data to search people:");
            String word = scanner.next();
            find(word, lines);
        }

//        String[] lineOfWords = scanner.nextLine().split("\\s");
//        String wordToSearch = scanner.next();
//        boolean wordFound = false;
//        for(int i=0;i<lineOfWords.length;i++){
//            if(lineOfWords[i].equals(wordToSearch)){
//                wordFound=true;
//                System.out.println(i+1);
//            }
//        }
//        if(!wordFound){
//            System.out.println("Not Found");


    }

    public static void find(String word, String[] lines) {
        int counter = 0;
        ArrayList<String> foundLines= new ArrayList<>();
        for(String line : lines){
            String[] words=line.split("\\s");
            int found = 0;
            for(String w:words){
                if(w.trim().toLowerCase().equals(word.toLowerCase())){
                    found++;break;
                }
            }
            if(found==1) {
                foundLines.add(line);
            }
        }

        if(foundLines.size()==0){
            System.out.println("unknown\nNo matching people found.");
        }else{
            System.out.println("Found people:");
            foundLines.forEach(System.out::println);
        }

    }
}
