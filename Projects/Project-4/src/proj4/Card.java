

package proj4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a single playing card with a rank and suit.
 */
public class Card {

    private static final Map<Integer, String> RANK_NAMES = Map.ofEntries(
            Map.entry(11, "Jack"),
            Map.entry(12, "Queen"),
            Map.entry(13, "King"),
            Map.entry(14, "Ace")
    );

    private static final Map<String, Integer> STRING_TO_RANK = Map.ofEntries(
            Map.entry("two", 2),
            Map.entry("2", 2),
            Map.entry("three", 3),
            Map.entry("3", 3),
            Map.entry("four", 4),
            Map.entry("4", 4),
            Map.entry("five", 5),
            Map.entry("5", 5),
            Map.entry("six", 6),
            Map.entry("6", 6),
            Map.entry("seven", 7),
            Map.entry("7", 7),
            Map.entry("eight", 8),
            Map.entry("8", 8),
            Map.entry("nine", 9),
            Map.entry("9", 9),
            Map.entry("ten", 10),
            Map.entry("10", 10),
            Map.entry("jack", 11),
            Map.entry("queen", 12),
            Map.entry("king", 13),
            Map.entry("ace", 14)
    );

    private static final String[] SUIT_NAMES = {"Spades", "Hearts", "Clubs", "Diamonds"};

    private int rank;
    private String suit;

    /**
     * constructor
     * @param rank the rank of the card (2-14)
     * @param suit the suit of the card (fully spelled out)
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * constructor
     * @param rank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Case insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit) {
        String rankLower = rank.toLowerCase();
        int rankValue = STRING_TO_RANK.get(rankLower);
        this.rank = rankValue;
        this.suit = suit;
    }

    /**
     * constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = SUIT_NAMES[suit];
    }

    /**
     * Gets the rank of this card.
     * @return the rank of the card
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets the suit of this card.
     * @return the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Returns a string representation of this card.
     * @return a string representation of the card
     */
    public String toString() {
        String rankStr = RANK_NAMES.getOrDefault(rank, String.valueOf(rank));
        return rankStr + " of " + suit;
    }
}