package Hw2_21002139_PhamNgocHai.ex6ex7;

import java.util.Random;

public class PokerCards {
    Card[] pokerCards;

    /*
     * The constructor create a poker cards 
     * (1 poker card & 52 normal cards)
     */
    public PokerCards() {
        pokerCards = createNewPokerCards();
    }

    /*
     * This function creates 53 cards difference 
     * Also mean that it creates one poker cards includes 53 cards
     * (1 poker card & 52 normal cards)
     */
    public Card[] createNewPokerCards() {
        Card[] pokerCards = new Card[53];
        // Create a poker card
        int index = 0;
        pokerCards[index] = new Card(0, 0);
        // Generate 52 normal cards
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                index++;
                pokerCards[index] = new Card(i, j);
            }
        }
        return pokerCards;
    }

    /*
     * Print state of poker cards
     */
    public void printPokerCards() {
        for (int i = 0; i < pokerCards.length; i++) {
            System.out.println("Card " + i + ": " + pokerCards[i].toString());
        }
    }

    /*
     * Shuffle the poker cards
     * @param n: number of times do shuffle
     */
    public void shufflePokerCards(int n) {
        // Generate 2 index difference to do 1 time shuffle
        if (n <= 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            int[] randomIndex = randomTwoIndexDifference();
            swapTwoCards(randomIndex[0], randomIndex[1]);
        }
    }

    private int[] randomTwoIndexDifference() {
        Random random = new Random();
        int[] result = new int[2];
        result[0] = random.nextInt(0, pokerCards.length);
        result[1] = random.nextInt(0, pokerCards.length);
        while (result[1] == result[0]) {
            result[1] = random.nextInt(0, pokerCards.length);
        }
        return result;
    }

    private void swapTwoCards(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            return;
        }
        Card temp = pokerCards[firstIndex];
        pokerCards[firstIndex] = pokerCards[secondIndex];
        pokerCards[secondIndex] = temp;
    }
}
