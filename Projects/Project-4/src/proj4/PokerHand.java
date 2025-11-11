package proj4;

import java.util.*;

/**
 * Represents a poker hand of cards and can evaluate and compare it to other hands.
 */
public class PokerHand implements Comparable<PokerHand> {

    private ArrayList<Card> cards;

    private static final Map<String, Integer> CATEGORY_VALUE = Map.ofEntries(
            Map.entry("flush", 3),
            Map.entry("two pair", 2),
            Map.entry("pair", 1),
            Map.entry("high card", 0)
    );

    private static final Comparator<int[]> COMPARATOR = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        }
    };


    /**
     * Constructs a PokerHand with the given cards.
     * @param cardList the cards that should be in this poker hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        this.cards = new ArrayList<>(cardList);
    }

    /**
     * Add a card to the hand. Does nothing if the hand already has 5 cards.
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < 5) {
            cards.add(card);
        }
    }

    /**
     * Get the i-th card from the hand.
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
     * Check if this hand is a flush (all cards same suit).
     * @return true if the hand is a flush, else false
     */
    private boolean isFlush() {
        HashSet<String> suits = new HashSet<>();
        for (Card card : cards) {
            suits.add(card.getSuit());
        }
        return suits.size() == 1;
    }

    /**
     * Check if this hand is a straight (consecutive cards).
     * @return true if the hand is a straight, else false
     */
    private boolean isStraight() {
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
     * Count how many cards of each rank are in this hand.
     * @return a map with rank counts
     */
    private Map<Integer, Integer> rankCounts() {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Card card : cards) {
            int rank = card.getRank();
            counts.put(rank, counts.getOrDefault(rank, 0) + 1);
        }
        return counts;
    }

    /**
     * Check if this hand has four cards of the same rank.
     * @return true if the hand has four of a kind, else false
     */
    private boolean isFourOfAKind() {
        Map<Integer, Integer> counts = rankCounts();
        return counts.containsValue(4);
    }

    /**
     * Check if this hand has three of one rank and two of another.
     * @return true if the hand is a full house, else false
     */
    private boolean isFullHouse() {
        Map<Integer, Integer> counts = rankCounts();
        boolean hasThree = counts.containsValue(3);
        boolean hasTwo = counts.containsValue(2);
        return hasThree && hasTwo;
    }

    /**
     * Check if this hand has exactly three cards of the same rank.
     * @return true if the hand has three of a kind, else false
     */
    private boolean isThreeOfAKind() {
        Map<Integer, Integer> counts = rankCounts();
        return counts.containsValue(3) && !isFullHouse();
    }

    /**
     * Check if this hand has exactly n pairs.
     * Precondition: n is a positive integer and n <= 2
     * @param n number of pairs to check for
     * @return true if the hand has exactly n pairs, else false
     */
    private boolean hasPairs(int n) {
        Map<Integer, Integer> counts = rankCounts();
        int pairCount = 0;
        for (int count : counts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == n;
    }


    /**
     * Returns a string representation of this poker hand.
     * @return string representation of the hand
     */
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result += "  " + card.toString() + "\n";
        }
        return result;
    }

    /**
     * Evaluate this hand and return its category.
     * @return string representing the hand category
     */
    private String evaluate() {
        boolean flush = isFlush();
        boolean straight = isStraight();

        if (flush && straight) {
            return "flush";
        } else if (flush) {
            return "flush";
        } else if (isFourOfAKind() || isFullHouse() || hasPairs(2)) {
            return "two pair";
        } else if (isThreeOfAKind() || hasPairs(1)) {
            return "pair";
        } else {
            return "high card";
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
        String myCategory = this.evaluate();
        int myValue = CATEGORY_VALUE.get(myCategory);

        String otherCategory = other.evaluate();
        int otherValue = CATEGORY_VALUE.get(otherCategory);

        int categoryDiff = myValue - otherValue;
        if (categoryDiff != 0) {
            return categoryDiff;
        }

        Map<Integer, Integer> myCounts = this.rankCounts();
        Map<Integer, Integer> otherCounts = other.rankCounts();

        List<int[]> myList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : myCounts.entrySet()) {
            myList.add(new int[]{entry.getValue(), entry.getKey()});
        }

        List<int[]> otherList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : otherCounts.entrySet()) {
            otherList.add(new int[]{entry.getValue(), entry.getKey()});
        }

        Collections.sort(myList, COMPARATOR);
        Collections.sort(otherList, COMPARATOR);

        for (int i = 0; i < myList.size(); i++) {
            int myRank = myList.get(i)[1];
            int otherRank = otherList.get(i)[1];

            if (myRank != otherRank) {
                return myRank - otherRank;
            }
        }

        return 0;
    }



}