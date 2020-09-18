package search;

import java.util.ArrayList;

public class NormalSerachFind  extends FindMatchingLines{
    public  void find(String word, ArrayList<String> lines) {
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
            System.out.println(foundLines.size()+" persons found:");
            foundLines.forEach(System.out::println);
            System.out.println();
        }

    }
}
