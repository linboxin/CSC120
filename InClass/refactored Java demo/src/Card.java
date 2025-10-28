/**
 * models a playing card
 */
public class Card {

    // constants use the keyword 'final'
    private final String[] SUITS = {
        "Hearts", "Clubs", "Spades", "Diamonds"
    };
    private final int DEFAULT_RANK = 14;
    private final String DEFAULT_SUIT = "Hearts";

    private final int ACE = 14;
    private final int KING = 13;
    private final int QUEEN = 12;
    private final int JACK = 11;

    private final int HEARTS = 0;
    private final int CLUBS = 1;
    private final int SPADES = 2;
    private final int DIAMONDS = 3;

    private final int RANK = 0;
    private final int SUIT = 1;

    // DECLARE instance variables

//    private int rank;    // 2-14
//    private String suit; // "Clubs", etc.
    private int[] card_info;

    /**
     * non default-constructor == constructor with params
     *
     * @param newRank int in range 2-14
     * @param newSuit String spelled out like "Clubs"
     */
    public Card(int newRank, String newSuit) {
        card_info = new int[2];
        card_info[RANK] = newRank;
        card_info[SUIT] = stringSuitToInt(newSuit);
    }

    /**
     * default constructor == constructor with no parameters
     */
    public Card() {
        card_info = new int[2];
        card_info[RANK] = DEFAULT_RANK;
        card_info[SUIT] = stringSuitToInt(DEFAULT_SUIT);
    }

    /**
     * non-default constructor
     *
     * @param newSuit suit spelled out like "Clubs"
     */
    public Card(String newSuit) {
        card_info = new int[2];
        card_info[RANK] = DEFAULT_RANK;
        card_info[SUIT] = stringSuitToInt(newSuit);

//        this.rank = DEFAULT_RANK;
//        this.suit = newSuit;
    }

    /**
     * getter for the rank
     *
     * @return int from 2-14
     */
    public int getRank() {
        return card_info[RANK];
    }

    /**
     * getter for suit
     *
     * @return String denoting full suit like "Spades"
     */
    public String getSuit() {
        return SUITS[card_info[SUIT]];
//        return suit;
    }

    /**
     * return this Card as a printable string
     *
     * @return card's full name like "Ace of Hearts"
     */
    public String toString() {
        int rank = this.getRank();
        String rankToPrint;
        if (rank == ACE) {
            rankToPrint = "Ace";
        }
        else if (rank == KING) {
            rankToPrint = "King";
        }
        else if (rank == QUEEN) {
            rankToPrint = "Queen";
        }
        else if (rank == JACK) {
            rankToPrint = "Jack";
        }
        else {
            rankToPrint = "" + rank;
        }
        return rankToPrint + " of " + getSuit();
    }

    private int stringSuitToInt(String suit) {
        if (suit == "HEARTS"){
            return HEARTS;
        }else if (suit == "SPADES"){
            return SPADES;
        }else if (suit == "DIAMONDS"){
            return DIAMONDS;
        } else if (suit == "CLUBS") {
            return CLUBS;
        }else{
            return -1;
        }
    }
}
