package Hw3_21002139.ex5;

public class Application {
    public static void main(String[] args) {
        String document = "Tạo đối tượng là WordCount gồm 2 thuộc tính là word và count. " +
            "Đối tượng WordCount nạp chồng phương thức equals(Object o) để có thể sử dụng " +
            "phương thức isContain đã xây dựng ở các cấu trúc dữ liệu trên, hoặc có thể " +
            "sử dụng phương thức indexOf của các đối tượng cài đặt giao diện List.";

        WordCount.countWords(document);
    }
}