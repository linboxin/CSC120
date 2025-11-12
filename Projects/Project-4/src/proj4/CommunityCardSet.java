package proj4;

import java.util.*;

/**
 * Represents a set of community cards shared by all players in a poker game.
 */
public class CommunityCardSet {

    public static final int MAX_CARD_NUM = 5;
    private ArrayList<Card> cards;

    /**
     * Constructs a community card set with the given cards
     * @param cards the cards in the community set
     */
    public CommunityCardSet(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Adds a card to the community set. Does nothing if the set already has 5 cards.
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < MAX_CARD_NUM) {
            cards.add(card);
        }
    }

    /**
     * Gets the i-th card from the community set.
     * @param i the index of the card to get
     * @return the card at index i, or null if i is invalid
     */
    public Card getIthCard(int i) {
        if (i >= 0 && i < cards.size()) {
            return cards.get(i);
        }
        return null;
    }

    /**
     * Returns the community cards as a single line separated by  | .
     * Example: "King of Spades | 6 of Clubs | 7 of Diamonds"
     */
    public String toString() {
        if (cards == null || cards.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < cards.size(); i++) {
            if (i > 0) {
                result += " | ";
            }
            result += cards.get(i).toString();
        }
        return result;
    }

}
