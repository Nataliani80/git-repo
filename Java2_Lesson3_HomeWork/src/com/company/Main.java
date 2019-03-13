package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> wordsArray = new ArrayList<>();
        wordsArray.add("home");
        wordsArray.add("love");
        wordsArray.add("family");
        wordsArray.add("mother");
        wordsArray.add("home");
        wordsArray.add("husband");
        wordsArray.add("love");
        wordsArray.add("happy");
        wordsArray.add("travel");
        wordsArray.add("world");
        wordsArray.add("love");
        wordsArray.add("happy");
        wordsArray.add("sea");
        wordsArray.add("husband");
        wordsArray.add("together");
        wordsArray.add("forever");
        wordsArray.add("travel");
        wordsArray.add("java");
        wordsArray.add("summer");

        System.out.println(wordsArray);

        HashSet<String> wordSet = new HashSet<>(wordsArray);
        System.out.print("Список уникальных слов: ");
        for (String word : wordSet) {
            System.out.print(word + ", ");
        }
        System.out.println();

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : wordsArray) {
            Integer frequency = wordCountMap.get(word);
            wordCountMap.put(word, frequency == null ? 1 : frequency + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println("Частота посторений слова: " + entry.getKey() + " = " + entry.getValue() );
        }

        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Иванов", "+79155556771");
        phonebook.add("Петров", "+79101111111");
        phonebook.add("Иванов", "89202112222");
        phonebook.add("Сидоров", "+79032112121");
        phonebook.add("Васильев", "89055667678");
        phonebook.add("Петров", "8-902-000-03-02");
        phonebook.add("Уваров", "+79103334455");
        phonebook.add("Иванов", "8-920-203-00-00");

        String surname = "Иванов";
        System.out.println("Номер телефона для фамилии " + surname + phonebook.get(surname));
    }
}
