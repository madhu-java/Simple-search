package search;

import java.util.*;

public class InvertedIndexFind extends FindMatchingLines {
    //inverted index
    public void find(String searchWord ,ArrayList<String> lines){
        //checking for correct output
//        System.out.println("word "+searchWord);
//        System.out.println("lines:");
//        for(int x=0;x<lines.size();x++){
//            System.out.println(x+ " "+lines.get(x));
//        }
        Map<String,ArrayList<Integer>> map = new HashMap<>(findIndexMap(lines));
        //checking correct output
//        map.forEach((key,value)->{
//            System.out.print("word "+key+" occurance:"+value );
//            System.out.println();
//        });
        map.forEach((word,list)->{
            if(word.equals(searchWord.toLowerCase())){
                if(list.size()==0){
                    System.out.println("No matching people found.");
                }else{
                    for(int i=0;i<list.size();i++){
                        System.out.println(lines.get(list.get(i)));
                    }
                }
            }
        });

    }

    //get word and its associated inverted index
    public Map<String,ArrayList<Integer>> findIndexMap(ArrayList<String> lines) {
        Map<String, ArrayList<Integer>> invertedIndexMap = new HashMap<>();
        Set<String> allWords = new TreeSet<>();
        //get allwords into a set
        lines.forEach(line -> {
            String[] wordArray = line.split("\\s");
            for (String word : wordArray) {
                allWords.add(word.trim().toLowerCase());
            }
        });
        //finding index of occurance words
        for (String word : allWords) {
            ArrayList<Integer> invertedIndesArray = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).toLowerCase().contains(word)) {
                    invertedIndesArray.add(i);
                }
            }
            //store word and corresponding invertedindex array in map
            invertedIndexMap.put(word, invertedIndesArray);
        }
return invertedIndexMap;
    }
}