package search;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromStdIn {
    Scanner scanner= new Scanner(System.in) ;
    ArrayList<String> lines = new ArrayList<>();


    public ArrayList<String> getLines() {
        return lines;
    }

    public void readFromInput()
    {
    System.out.println("Enter the number of people:");
    int numberOfLines = scanner.nextInt();
    ArrayList<String> lines = new ArrayList<>();
        scanner.nextLine();
        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfLines; i++) {
            lines.add(scanner.nextLine());
        }
    }

}
