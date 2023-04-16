package Hw2_21002139_PhamNgocHai.ex6ex7;

import Hw2_21002139_PhamNgocHai.ex5.*;

public class Application {
    public static void main(String[] args) {
        // Ex 6:
        System.out.println("Ex6:");
        PokerCards pokerCards = new PokerCards();
        CompareCard compareCard = new CompareCard();
        // Tạo ra bộ bài 53 lá (1 lá poker và 52 lá thường)
        SortPokerCards<Card> sortPokerCards = new SortPokerCards<>();

        // Sử dụng Comparator so sánh 2 lá bài bất kỳ
        System.out.println("Compare pokerCards[45] vs pokerCards[32]: " + 
            compareCard.compare(pokerCards.pokerCards[45], pokerCards.pokerCards[32]));

        // Xáo bộ bài 100 lần và in ra trạng thái của bộ bài sau khi xáo
        pokerCards.shufflePokerCards(100);
        System.out.println("\nThe poker cards after shuffling");
        pokerCards.printPokerCards();

        // Sắp xếp bộ bài sau khi xáo bằng cách sử dụng Comparator
        System.out.println("\nSort by using Comparator");
        sortPokerCards.sort(pokerCards.pokerCards, compareCard);
        pokerCards.printPokerCards();

        // Sắp xếp bộ bài (sau khi xáo bộ bài 1000 lần) bằng cách sử dụng Comparable
        System.out.println("\nSort by using Comparable (also mean use Card implements Comparable<Card>): ");
        pokerCards.shufflePokerCards(1000);
        Sort<Card> sort = new BubbleSort<>(pokerCards.pokerCards);
        sort.sort();
        pokerCards.printPokerCards();

        // ---------------------------------------------------------------------------------------------------
        // Ex 7:
        // Sử dụng đối tượng Random, tạo dãy N số nguyên ngẫu nhiên, mỗi số <=M và
        // không có 2 số nào bằng nhau. (N < M). Từ đó tạo hàm trộn bộ bài

        // Hàm trộn (xáo) bộ bài được tạo ra trong class PokerCards
        // Sau đây ta sử dụng hàm shufflePokerCards() đã build để xáo bộ bài 90 lần
        System.out.println("\nEx7: Trộn bộ bài");
        pokerCards.shufflePokerCards(90);
        pokerCards.printPokerCards();
    }
}
