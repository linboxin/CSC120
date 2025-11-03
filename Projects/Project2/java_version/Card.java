import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single playing card with a rank and suit.
 * 
 * @author James Lin
 * @version 1.0
 */
public class Card {
    private int rank;      // Rank of the card (2-14, where 11=Jack, 12=Queen, 13=King, 14=Ace)
    private String suit;   // Suit of the card (fully spelled out: "Spades", "Hearts", "Diamonds", "Clubs")
    
    // Map for face card names
    private static final Map<Integer, String> RANK_NAMES = new HashMap<>();
    static {
        RANK_NAMES.put(11, "Jack");
        RANK_NAMES.put(12, "Queen");
        RANK_NAMES.put(13, "King");
        RANK_NAMES.put(14, "Ace");
    }
    
    /**
     * Constructs a Card with the specified rank and suit.
     * 
     * @param rank the rank of the card (2-14)
     * @param suit the suit of the card (fully spelled out)
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Gets the rank of this card.
     * 
     * @return the rank of the card
     */
    public int getRank() {
        return rank;
    }
    
    /**
     * Gets the suit of this card.
     * 
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * Returns a string representation of this card in readable format.
     * For example: "Jack of Clubs" or "7 of Hearts"
     * 
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        String rankStr = RANK_NAMES.getOrDefault(rank, String.valueOf(rank));
        return rankStr + " of " + suit;
    }
}

