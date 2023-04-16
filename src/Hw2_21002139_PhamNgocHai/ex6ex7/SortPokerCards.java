package Hw2_21002139_PhamNgocHai.ex6ex7;

import java.util.Arrays;
import java.util.Comparator;

public class SortPokerCards<T> {
    public void sort(T[] pokerCards, Comparator<? super T> compareCard) {
        Arrays.sort(pokerCards, 0, pokerCards.length, compareCard);
    }
}
