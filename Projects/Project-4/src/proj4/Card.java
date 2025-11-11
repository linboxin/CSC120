package proj4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
// Constructor, getRank, getSuit, __str__

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

    private int rank;
    private String suit;

    /**
     * Constructs a Card with the specified rank and suit.
     * @param rank the rank of the card (2-14)
     * @param suit the suit of the card (fully spelled out)
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
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