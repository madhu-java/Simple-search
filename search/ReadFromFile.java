package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {
    String[] args;
    String fileName="";
    ArrayList<String> lines = new ArrayList<>();
    ReadFromFile(String[] args){
        this.args=args.clone();
    }
   public void readFile(){
        if(args[0]=="--data"){
            fileName = args[1];
        }
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)) {


            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}
