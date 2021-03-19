package Lesson3_HomeWork;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"money", "morning","apple", "rabbit", "go", "money", "door", "apple", "go", "apple", "door", "rabbit"};
        checkUniqueWords(words);
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.add("Smirnov", "+125487");
        phoneBook1.add("Petrov", "+232643");
        phoneBook1.add("Ivanov", "+125899723");
        phoneBook1.add("Smirnov","+125788");
        System.out.println(phoneBook1.get("Smirnov"));


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




