package Hw2_21002139_PhamNgocHai.ex6ex7;

public class Card implements Comparable<Card> {
    /*
     * rank is one of these data {0, 1, 2, ..., 13}
     * suit is one of these data {0, 1, 2, 3, 4}
     */
    int rank;
    int suit;

    /*
     * Ascending order of comparison is:
     * ------------------------------------
     * 0: poker     1: ace      2: two
     * ...
     * 11: jack     12: queen   13: king
     * ------------------------------------
     * 0: poker
     * 1: spade - bích
     * 2: club - nhép / chuồn
     * 3: diamond - rô
     * 4: heart - tim
     * ------------------------------------
     * One poker cards includes poker card & 52 cards (13 rank x 4 suit)
     */
    final String[] RANK_ENCODE = {"poker", "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
        "ten", "jack", "queen", "king"};
    final String[] SUIT_ENCODE = {"poker", "spade",  "club", "diamond", "heart"};
    
    /*
     * This constructor will create one of 52 cards 
     * (defined by matching rank and suit data)
     * 
     * If the input data doesn't satisfy the rank and suit already,
     * then a poker card be created.
     */
    public Card(int rank, int suit) {
        if ((rank <= 0 || rank > 13) && (suit <= 0 || suit > 4)) {
            return;
        }
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    /*
     * Write attributes of the card
     */
    public String toString() {
        return RANK_ENCODE[rank] + " " + SUIT_ENCODE[suit];
    }

    /*
     * Override to use Comparable 
     */
    @Override
    public int compareTo(Card o) {
        if (this.getRank() == o.getRank()) {
            return this.getSuit() - o.getSuit();
        }
        return this.getRank() - o.getRank();
    }
}
