package proj4;

import java.util.ArrayList;

public class StudPokerHand{

    private final int HOLECARDS_NUM = 2;
    private final int TOTAL_CARDS = 7;
    private final int POKER_HAND_SIZE = 5;
    private ArrayList<Card> holeCards;
    private CommunityCardSet communityCardSets;



    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        this.communityCardSets = cc;
        this.holeCards = cardList;
    }

    /**
     * Add a card to the hand. Does nothing if the hand already has 2 cards.
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (holeCards.size() < HOLECARDS_NUM) {
            holeCards.add(card);
        }
    }

    /**
     * Get the i-th card from the hand.
     * @param i the index of the card to get
     * @return the card at index i, or null if i is invalid
     */
    public Card getIthCard(int i) {
        if (i >= 0 && i < holeCards.size()) {
            return holeCards.get(i);
        }else{
            return null;
        }
    }

    private ArrayList<Card> getAllSevenCards() {
        ArrayList<Card> allCards = new ArrayList<>();

        for (int i = 0; i < HOLECARDS_NUM; i++) {
            allCards.add(holeCards.get(i));
        }

        for (int i = 0; i < CommunityCardSet.MAX_CARD_NUM; i++) {
            Card c = communityCardSets.getIthCard(i);
            allCards.add(c);
        }

        return allCards;
    }

    private ArrayList<PokerHand> getAllFiveCardHands() {
        ArrayList<Card> sevenCards = getAllSevenCards();
        ArrayList<PokerHand> hands = new ArrayList<>();

        for (int i = 0; i < TOTAL_CARDS; i++) {
            for (int j = i + 1; j < TOTAL_CARDS; j++) {
                ArrayList<Card> fiveCards = new ArrayList<>();
                for (int k = 0; k < TOTAL_CARDS; k++) {
                    fiveCards.add(sevenCards.get(k));
                }
                fiveCards.remove(j);
                fiveCards.remove(i);
                hands.add(new PokerHand(fiveCards));
            }
        }

        return hands;
    }

    private PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }


    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {
        if (other == null) {
            return -1;
        }
        PokerHand thisBest = this.getBestFiveCardHand();
        PokerHand otherBest = other.getBestFiveCardHand();

        return thisBest.compareTo(otherBest);
    }


    
    /**
     * Returns the hole cards separated by comma and space.
     * Example: "4 of Clubs, 8 of Spades"
     */
    public String toString() {
        if (holeCards == null || holeCards.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < holeCards.size(); i++) {
            if (i > 0) {
                result += ", ";
            }
            result += holeCards.get(i).toString();
        }
        return result;
    }

}