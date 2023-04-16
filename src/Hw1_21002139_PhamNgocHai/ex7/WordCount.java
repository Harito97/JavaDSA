package Hw1_21002139_PhamNgocHai.ex7;


import java.util.ArrayList;
import java.util.List;

public class WordCount {
    List<String> word = new ArrayList<>();
    List<Integer> count = new ArrayList<>();

    public void haveOneMoreWord(int i) {
        count.set(i, count.get(i) + 1);
    }

    public static void main(String[] args) {
        String shortDocument = "Tạo đối tượng là WordCount gồm 2 thuộc tính là word và count. " +
            "Đối tượng WordCount nạp chồng phương thức equals(Object o) để có thể sử dụng " +
            "phương thức isContain đã xây dựng ở các cấu trúc dữ liệu trên, hoặc có thể " +
            "sử dụng phương thức indexOf của các đối tượng cài đặt giao diện List.";
        String[] words = shortDocument.toLowerCase().split(" ");
        int n = words.length;
        int numberOfWord = 0;

        WordCount wordCounts = new WordCount(); 
        wordCounts.word.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (wordCounts.word.indexOf(words[i]) < numberOfWord && wordCounts.word.indexOf(words[i]) >= 0) {
                wordCounts.haveOneMoreWord(wordCounts.word.indexOf(words[i]));
            } else {
                wordCounts.word.add(words[i]);
                wordCounts.count.add(1);
                numberOfWord++;
            } 
        }

        System.out.println("Short Document has " + numberOfWord + " words");
        for (int i = 0; i < numberOfWord - 1; i++) {
            if (wordCounts.count.get(i) == 1) {
                System.out.println("Word: " + wordCounts.word.get(i) + " appear 1 time");
                continue;
            }
            System.out.println("Word: " + wordCounts.word.get(i) + " appear " + wordCounts.count.get(i) + " times");
        }
    }
}