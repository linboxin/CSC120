import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

/**
 * Represents a poker hand of up to 5 cards.
 * Provides methods to evaluate and compare poker hands.
 * 
 * Hand categories (from best to worst):
 * - Flush (includes royal flush and straight flush)
 * - Two pair (includes two pair, four-of-a-kind, and full house)
 * - Pair (includes pair and three-of-a-kind)
 * - High card (includes high card and straight)
 * 
 * @author James Lin
 * @version 1.0
 */
public class PokerHand {
    private ArrayList<Card> cards;
    
    private static final int FLUSH_VALUE = 3;
    private static final int TWO_PAIR_VALUE = 2;
    private static final int PAIR_VALUE = 1;
    private static final int HIGH_CARD_VALUE = 0;
    
    /**
     * Constructs a poker hand from the given list of cards.
     * 
     * @param cardList the list of cards to include in the hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        this.cards = new ArrayList<>(cardList);
    }
    
    /**
     * Adds a card to this hand.
     * Does nothing if the hand already contains 5 cards.
     * 
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < 5) {
            cards.add(card);
        }
    }
    
    /**
     * Gets the card at the specified index.
     * 
     * @param i the index of the card to retrieve (0-based)
     * @return the card at index i, or null if the index is invalid
     */
    public Card getIthCard(int i) {
        if (i >= 0 && i < cards.size()) {
            return cards.get(i);
        }
        return null;
    }
    
    /**
     * Returns a string representation of this hand.
     * 
     * @return a string containing all cards in the hand, one per line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Checks if all cards in this hand have the same suit.
     * 
     * @return true if this is a flush, false otherwise
     */
    private boolean isFlush() {
        if (cards.isEmpty()) {
            return false;
        }
        String firstSuit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if the cards in this hand form a straight (consecutive ranks).
     * 
     * @return true if this is a straight, false otherwise
     */
    private boolean isStraight() {
        if (cards.size() != 5) {
            return false;
        }
        
        ArrayList<Integer> ranks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(card.getRank());
        }
        Collections.sort(ranks);
        
        for (int i = 0; i < 4; i++) {
            if (ranks.get(i) + 1 != ranks.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Counts how many cards of each rank are in this hand.
     * 
     * @return a map from rank to count
     */
    private HashMap<Integer, Integer> getRankCounts() {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Card card : cards) {
            int rank = card.getRank();
            counts.put(rank, counts.getOrDefault(rank, 0) + 1);
        }
        return counts;
    }
    
    /**
     * Checks if this hand contains four cards of the same rank.
     * 
     * @return true if this hand has four of a kind, false otherwise
     */
    private boolean isFourOfAKind() {
        HashMap<Integer, Integer> counts = getRankCounts();
        return counts.containsValue(4);
    }
    
    /**
     * Checks if this hand contains three cards of one rank and two cards of another rank.
     * 
     * @return true if this hand is a full house, false otherwise
     */
    private boolean isFullHouse() {
        HashMap<Integer, Integer> counts = getRankCounts();
        boolean hasThree = false;
        boolean hasTwo = false;
        
        for (int count : counts.values()) {
            if (count == 3) {
                hasThree = true;
            } else if (count == 2) {
                hasTwo = true;
            }
        }
        
        return hasThree && hasTwo;
    }
    
    /**
     * Checks if this hand contains exactly three cards of the same rank (not a full house).
     * 
     * @return true if this hand has three of a kind, false otherwise
     */
    private boolean isThreeOfAKind() {
        HashMap<Integer, Integer> counts = getRankCounts();
        return counts.containsValue(3) && !isFullHouse();
    }
    
    /**
     * Checks if this hand contains exactly n pairs.
     * 
     * @param n the number of pairs to check for
     * @return true if this hand has exactly n pairs, false otherwise
     */
    private boolean hasPairs(int n) {
        HashMap<Integer, Integer> counts = getRankCounts();
        int pairCount = 0;
        
        for (int count : counts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        
        return pairCount == n;
    }
    
    /**
     * Evaluates this hand and returns its category value.
     * 
     * @return the value of this hand's category (3=flush, 2=two pair, 1=pair, 0=high card)
     */
    private int evaluate() {
        boolean flush = isFlush();
        boolean straight = isStraight();
        
        if (flush && straight) {
            return FLUSH_VALUE;  // Straight flush
        } else if (flush) {
            return FLUSH_VALUE;
        } else if (isFourOfAKind() || isFullHouse() || hasPairs(2)) {
            return TWO_PAIR_VALUE;
        } else if (isThreeOfAKind() || hasPairs(1)) {
            return PAIR_VALUE;
        } else {
            return HIGH_CARD_VALUE;  // Includes high card and straight
        }
    }
    
    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other) {
        int myValue = this.evaluate();
        int otherValue = other.evaluate();
        
        // First compare by category
        int categoryDiff = myValue - otherValue;
        if (categoryDiff != 0) {
            return categoryDiff;
        }
        
        // If categories are the same, compare by rank counts
        HashMap<Integer, Integer> myCounts = this.getRankCounts();
        HashMap<Integer, Integer> otherCounts = other.getRankCounts();
        
        // Create lists of (count, rank) pairs
        ArrayList<CountRankPair> myList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : myCounts.entrySet()) {
            myList.add(new CountRankPair(entry.getValue(), entry.getKey()));
        }
        
        ArrayList<CountRankPair> otherList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : otherCounts.entrySet()) {
            otherList.add(new CountRankPair(entry.getValue(), entry.getKey()));
        }
        
        // Sort by count (descending), then by rank (descending)
        Collections.sort(myList);
        Collections.sort(otherList);
        
        // Compare ranks in order of their counts
        for (int i = 0; i < myList.size() && i < otherList.size(); i++) {
            int myRank = myList.get(i).rank;
            int otherRank = otherList.get(i).rank;
            
            if (myRank != otherRank) {
                return myRank - otherRank;
            }
        }
        
        return 0;  // Hands are equal
    }
    
    /**
     * Helper class to pair a count with a rank for sorting purposes.
     */
    private static class CountRankPair implements Comparable<CountRankPair> {
        int count;
        int rank;
        
        CountRankPair(int count, int rank) {
            this.count = count;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(CountRankPair other) {
            // Sort by count descending, then by rank descending
            if (this.count != other.count) {
                return other.count - this.count;  // Descending order
            }
            return other.rank - this.rank;  // Descending order
        }
    }
}

