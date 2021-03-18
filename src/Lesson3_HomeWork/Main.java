package Lesson3_HomeWork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"money", "morning","apple", "rabbit", "go", "money", "door", "apple", "go", "apple", "door", "rabbit"};
        Set<String> uniqueWords = new HashSet<>();
        uniqueWords.addAll(Arrays.asList(words));
        System.out.println(uniqueWords);

        }

    }




