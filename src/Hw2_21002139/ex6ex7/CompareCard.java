package Hw2_21002139.ex6ex7;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {

    /*
     * return a number bigger than 0 if:
     *      Case 1: firstCard has the rank bigger
     *      Case 2: firstCard has the rank equals but the suit bigger
     * return a number small than 0 if:
     *      Case 1: firstCard has the rank smaller
     *      Case 2: firstCard has the rank equals but the suit smaller
     * return 0 if:
     *      Both firstCard & secondCard has the same rank & suit
     */
    @Override
    public int compare(Card firstCard, Card secondCard) {
        if (compareRank(firstCard, secondCard) == 0) {
            return compareSuit(firstCard, secondCard);
        }
        return compareRank(firstCard, secondCard);
    }

    /*
     * return true if:
     *      2 cards have the same rank & suit
     * else return false
     */
    public boolean equals(Card firstCard, Card secondCard) {
        return (compareRank(firstCard, secondCard) == 0 && compareSuit(firstCard, secondCard) == 0);
    }

    private int compareRank(Card firstCard, Card secondCard) {
        return firstCard.getRank() - secondCard.getRank();
    }

    private int compareSuit(Card firstCard, Card secondCard) {
        return firstCard.getSuit() - secondCard.getSuit();
    }
}