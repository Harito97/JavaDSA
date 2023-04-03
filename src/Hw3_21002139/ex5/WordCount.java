package Hw3_21002139.ex5;

import java.util.ArrayList;
import java.util.List;

public class WordCount {
    private static List<String> word = new ArrayList<>();
    private static List<Integer> count = new ArrayList<>();

    private static void haveOneMoreWord(int i) {
        count.set(i, count.get(i) + 1);
    }

    public static void countWords(String string) {
        String shortDocument = string;
        String[] words = shortDocument.replaceAll("[^a-zA-Z0-9\\p{L} ]", "").toLowerCase().split(" ");
        int n = words.length;
        int numberOfWord = 0;

        word.add(words[0]);
        int indexOfWord = 0;
        for (int i = 1; i < n; i++) {
            indexOfWord = word.indexOf(words[i]);
            if (indexOfWord >= 0 && indexOfWord < numberOfWord) {
                haveOneMoreWord(indexOfWord);
            } else {
                word.add(words[i]);
                count.add(1);
                ++numberOfWord;
            } 
        }

        System.out.println("Short Document has " + numberOfWord + " words");
        for (int i = 0; i < numberOfWord - 1; i++) {
            if (count.get(i) == 1) {
                System.out.println("Word: " + word.get(i) + " appear 1 time");
                continue;
            }
            System.out.println("Word: " + word.get(i) + " appear " + count.get(i) + " times");
        }
    }
}