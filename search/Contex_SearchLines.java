package search;

import java.util.ArrayList;

public class Contex_SearchLines {
    FindMatchingLines findMatchingLines;
    public Contex_SearchLines(FindMatchingLines findMatchingLines){
        this.findMatchingLines = findMatchingLines;
    }
    public void find(String word, ArrayList<String> lines){
        this.findMatchingLines.find(word,lines);
    }
}
