import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a deck of playing cards.
 * Supports dealing cards without removing them from the deck by tracking
 * the index of the next card to deal.
 * 
 * @author James Lin
 * @version 1.0
 */
public class Deck {
    private ArrayList<Card> deck;
    private int nextCardIndex;  // Index of the next card to deal
    
    private static final int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
    
    /**
     * Constructs a standard 52-card deck.
     * The deck is initially unshuffled.
     */
    public Deck() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (int rank : RANKS) {
                deck.add(new Card(rank, suit));
            }
        }
        nextCardIndex = 0;
    }
    
    /**
     * Shuffles the deck by swapping each card with a card at a random index.
     * Uses ThreadLocalRandom for random number generation.
     */
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            // Get random index from 0 to deck.size()-1
            int randomIndex = ThreadLocalRandom.current().nextInt(deck.size());
            
            // Swap card at index i with card at randomIndex
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }
    
    /**
     * Deals the next undealt card from the deck.
     * Does not remove the card from the deck; instead tracks which cards have been dealt.
     * 
     * @return the next undealt card, or null if there are no undealt cards
     */
    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        Card card = deck.get(nextCardIndex);
        nextCardIndex++;
        return card;
    }
    
    /**
     * Checks if there are any undealt cards remaining in the deck.
     * 
     * @return true if all cards have been dealt, false otherwise
     */
    public boolean isEmpty() {
        return nextCardIndex >= deck.size();
    }
    
    /**
     * Returns the number of undealt cards remaining in the deck.
     * 
     * @return the number of undealt cards
     */
    public int size() {
        return deck.size() - nextCardIndex;
    }
    
    /**
     * Returns all cards to an undealt state.
     * The deck does not need to be unshuffled.
     */
    public void gather() {
        nextCardIndex = 0;
    }
    
    /**
     * Returns a string representation of all undealt cards in the deck.
     * 
     * @return a string containing all undealt cards, one per line
     */
    public String toString() {
        String result = "";
        for (int i = nextCardIndex; i < deck.size(); i++) {
            result += deck.get(i).toString() + "\n";
        }
        return result;
    }
}

