package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        String[] lineOfWords = scanner.nextLine().split("\\s");
        String wordToSearch = scanner.next();
        boolean wordFound = false;
        for(int i=0;i<lineOfWords.length;i++){
            if(lineOfWords[i].equals(wordToSearch)){
                wordFound=true;
                System.out.println(i+1);
            }
        }
        if(!wordFound){
            System.out.println("Not Found");
        }

    }
}
