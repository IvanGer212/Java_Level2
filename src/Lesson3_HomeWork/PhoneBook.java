package Lesson3_HomeWork;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String number){
        //if (book.containsKey(name)){
        //    book.get(name).add(number);
        //}
        //else {
        //    Set<String> numbers = new HashSet<>();
        //    numbers.add(number);
        //    book.put(name,numbers);
        //}
        Set<String> numbers = book.getOrDefault(name, new HashSet<>());
        numbers.add(number);
        book.putIfAbsent(name,numbers);

    }
    public Set<String> get(String name){
        return book.get(name);

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "book=" + book +
                '}';
    }
}
