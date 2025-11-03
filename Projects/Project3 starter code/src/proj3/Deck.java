package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a standard 52-card deck of playing cards with shuffle and deal operations.
 */
public class Deck {

    private final int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};


    private ArrayList<Card> deck;
    private int nextToDeal;

    /**
     * Constructs a deck
     */
    public Deck() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (int rank : RANKS) {
                deck.add(new Card(rank, suit));
            }
        }
        nextToDeal = 0;
    }


    /**
     * Shuffles the deck by swapping each card with another at random index
     */
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }

    /**
     * Checks if there are any undealt cards remaining in the deck.
     *  @return false if there is else return true
     */
    public boolean isEmpty() {
        return deck.size() <= nextToDeal;
    }

    /**
     * Returns the number of undealt cards remaining in the deck
     * @return the number of undealt cards
     */
    public int size() {
        return deck.size() - nextToDeal;
    }

    /**
     * Deals the next undealt card from the deck.
     * Does not remove the card from the deck; instead tracks which cards have been dealt.
     * @return the next undealt card, or null if there are no undealt cards
     */
    public Card deal(){
        if (isEmpty()) return null;

        Card card =  deck.get(nextToDeal);
        nextToDeal++;
        return card;
    }

    /**
     * Returns all cards to an undealt state
     */
    public void gather(){
        nextToDeal = 0;
    }

    /**
     * Returns a string representation of all undealt cards in the deck
     * @return a string containing all undealt cards, one per line
     */
    public String toString() {
        String result = "";
        for (int i = nextToDeal; i < deck.size(); i++) {
            result += deck.get(i).toString() + "\n";
        }
        return result;
    }

}
