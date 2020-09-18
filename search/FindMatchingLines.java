package search;

import java.util.ArrayList;

public  abstract class FindMatchingLines {
    String word="";
    ArrayList<String> lines ;

    protected abstract void find(String word, ArrayList<String> lines);
}
