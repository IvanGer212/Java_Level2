package Lesson3_HomeWork;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"money", "morning","apple", "rabbit", "go", "money", "door", "apple", "go", "apple", "door", "rabbit"};
        checkUniqueWords(words);


        }
     static void checkUniqueWords (String[] words){
         Set<String> uniqueWords = new HashSet<>();
         uniqueWords.addAll(Arrays.asList(words));
         System.out.println(uniqueWords);
         countWords(uniqueWords,words);
     }
     static void countWords (Set<String> uniqueWords, String[] words){
         Map<String, Integer> counter = new HashMap<>();
         for (int i = 0; i < words.length; i++) {
            if (counter.containsKey(words[i])) {
                 counter.put(words[i],counter.get(words[i])+1);
            } else
                counter.put(words[i],1);
         }
         System.out.println(counter);
    }

}




