package proj4;

import java.util.ArrayList;

/**
 * Tests the PokerHand comparison logic for different hand categories and tie scenarios.
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 * @author James Lin
 */
public class PokerComparisonTests {

    /**
     * Test that flush beats high card
     */
    public static void flushVsHighCard() {
        String mess = "Flush vs high card";
        ArrayList<Card> flushCards = new ArrayList<>();
        flushCards.add(new Card(2, "Hearts"));
        flushCards.add(new Card(5, "Hearts"));
        flushCards.add(new Card(9, "Hearts"));
        flushCards.add(new Card(13, "Hearts"));
        flushCards.add(new Card(14, "Hearts"));
        PokerHand flush = new PokerHand(flushCards);

        ArrayList<Card> highCardCards = new ArrayList<>();
        highCardCards.add(new Card(2, "Diamonds"));
        highCardCards.add(new Card(5, "Clubs"));
        highCardCards.add(new Card(7, "Spades"));
        highCardCards.add(new Card(9, "Diamonds"));
        highCardCards.add(new Card(11, "Clubs"));
        PokerHand highCard = new PokerHand(highCardCards);

        int actual = flush.compareTo(highCard);
        Testing.assertTrue(mess, actual > 0);
    }

    /**
     * Test that flush beats pair
     */
    public static void flushVsPair() {
        String mess = "Flush vs pair";
        ArrayList<Card> flushCards = new ArrayList<>();
        flushCards.add(new Card(2, "Diamonds"));
        flushCards.add(new Card(4, "Diamonds"));
        flushCards.add(new Card(6, "Diamonds"));
        flushCards.add(new Card(8, "Diamonds"));
        flushCards.add(new Card(10, "Diamonds"));
        PokerHand flush = new PokerHand(flushCards);

        ArrayList<Card> pairCards = new ArrayList<>();
        pairCards.add(new Card(14, "Hearts"));
        pairCards.add(new Card(14, "Diamonds"));
        pairCards.add(new Card(13, "Clubs"));
        pairCards.add(new Card(12, "Spades"));
        pairCards.add(new Card(11, "Hearts"));
        PokerHand pair = new PokerHand(pairCards);

        int actual = flush.compareTo(pair);
        Testing.assertTrue(mess, actual > 0);
    }

    /**
     * Test comparing two high card hands
     */
    public static void highCardVsHighCard() {
        String mess = "High card vs high card";
        ArrayList<Card> kingHighCards = new ArrayList<>();
        kingHighCards.add(new Card(2, "Hearts"));
        kingHighCards.add(new Card(4, "Diamonds"));
        kingHighCards.add(new Card(7, "Clubs"));
        kingHighCards.add(new Card(9, "Spades"));
        kingHighCards.add(new Card(13, "Hearts"));
        PokerHand kingHigh = new PokerHand(kingHighCards);

        ArrayList<Card> queenHighCards = new ArrayList<>();
        queenHighCards.add(new Card(2, "Diamonds"));
        queenHighCards.add(new Card(4, "Clubs"));
        queenHighCards.add(new Card(7, "Spades"));
        queenHighCards.add(new Card(9, "Diamonds"));
        queenHighCards.add(new Card(12, "Clubs"));
        PokerHand queenHigh = new PokerHand(queenHighCards);

        int actual = kingHigh.compareTo(queenHigh);
        Testing.assertTrue(mess, actual > 0);
    }

    /**
     * Test that same ranks but different suits are a tie
     */
    public static void identicalHandsTie() {
        String mess = "Same ranks but different suits";
        ArrayList<Card> hand1Cards = new ArrayList<>();
        hand1Cards.add(new Card(2, "Hearts"));
        hand1Cards.add(new Card(5, "Diamonds"));
        hand1Cards.add(new Card(9, "Clubs"));
        hand1Cards.add(new Card(13, "Spades"));
        hand1Cards.add(new Card(14, "Hearts"));
        PokerHand hand1 = new PokerHand(hand1Cards);

        ArrayList<Card> hand2Cards = new ArrayList<>();
        hand2Cards.add(new Card(2, "Diamonds"));
        hand2Cards.add(new Card(5, "Clubs"));
        hand2Cards.add(new Card(9, "Hearts"));
        hand2Cards.add(new Card(13, "Diamonds"));
        hand2Cards.add(new Card(14, "Clubs"));
        PokerHand hand2 = new PokerHand(hand2Cards);

        int actual = hand1.compareTo(hand2);
        Testing.assertEquals(mess, 0, actual);
    }

    /**
     * Test that same pair with same other cards are a tie
     */
    public static void samePairSameOtherCardsTie() {
        String mess = "Same pair, same other cards";
        ArrayList<Card> hand1Cards = new ArrayList<>();
        hand1Cards.add(new Card(10, "Hearts"));
        hand1Cards.add(new Card(10, "Diamonds"));
        hand1Cards.add(new Card(5, "Clubs"));
        hand1Cards.add(new Card(3, "Spades"));
        hand1Cards.add(new Card(2, "Hearts"));
        PokerHand hand1 = new PokerHand(hand1Cards);

        ArrayList<Card> hand2Cards = new ArrayList<>();
        hand2Cards.add(new Card(10, "Clubs"));
        hand2Cards.add(new Card(10, "Spades"));
        hand2Cards.add(new Card(5, "Diamonds"));
        hand2Cards.add(new Card(3, "Hearts"));
        hand2Cards.add(new Card(2, "Clubs"));
        PokerHand hand2 = new PokerHand(hand2Cards);

        int actual = hand1.compareTo(hand2);
        Testing.assertEquals(mess, 0, actual);
    }

    /**
     * Test comparing two two pair hands
     */
    public static void twoPairVsTwoPair() {
        String mess = "Two pair vs two pair";
        ArrayList<Card> twoPair1Cards = new ArrayList<>();
        twoPair1Cards.add(new Card(9, "Hearts"));
        twoPair1Cards.add(new Card(9, "Diamonds"));
        twoPair1Cards.add(new Card(8, "Clubs"));
        twoPair1Cards.add(new Card(8, "Spades"));
        twoPair1Cards.add(new Card(3, "Hearts"));
        PokerHand twoPair1 = new PokerHand(twoPair1Cards);

        ArrayList<Card> twoPair2Cards = new ArrayList<>();
        twoPair2Cards.add(new Card(9, "Clubs"));
        twoPair2Cards.add(new Card(9, "Spades"));
        twoPair2Cards.add(new Card(7, "Diamonds"));
        twoPair2Cards.add(new Card(7, "Hearts"));
        twoPair2Cards.add(new Card(3, "Clubs"));
        PokerHand twoPair2 = new PokerHand(twoPair2Cards);

        int actual = twoPair1.compareTo(twoPair2);
        Testing.assertTrue(mess, actual > 0);
    }

    /**
     * Test that full house beats two pair
     */
    public static void fullHouseVsTwoPair() {
        String mess = "Full house vs two pair";
        ArrayList<Card> fullHouseCards = new ArrayList<>();
        fullHouseCards.add(new Card(5, "Hearts"));
        fullHouseCards.add(new Card(5, "Diamonds"));
        fullHouseCards.add(new Card(5, "Clubs"));
        fullHouseCards.add(new Card(7, "Spades"));
        fullHouseCards.add(new Card(7, "Hearts"));
        PokerHand fullHouse = new PokerHand(fullHouseCards);

        ArrayList<Card> twoPairCards = new ArrayList<>();
        twoPairCards.add(new Card(7, "Diamonds"));
        twoPairCards.add(new Card(7, "Clubs"));
        twoPairCards.add(new Card(6, "Spades"));
        twoPairCards.add(new Card(6, "Hearts"));
        twoPairCards.add(new Card(3, "Diamonds"));
        PokerHand twoPair = new PokerHand(twoPairCards);

        int actual = fullHouse.compareTo(twoPair);
        Testing.assertTrue(mess, actual < 0);
    }

    /**
     * Test four of a kind vs full house
     */
    public static void fourKindVsFullHouse() {
        String mess = "Four of a kind vs full house";
        ArrayList<Card> fourKindCards = new ArrayList<>();
        fourKindCards.add(new Card(13, "Hearts"));
        fourKindCards.add(new Card(13, "Diamonds"));
        fourKindCards.add(new Card(13, "Clubs"));
        fourKindCards.add(new Card(13, "Spades"));
        fourKindCards.add(new Card(2, "Hearts"));
        PokerHand fourKind = new PokerHand(fourKindCards);

        ArrayList<Card> fullHouseCards = new ArrayList<>();
        fullHouseCards.add(new Card(14, "Hearts"));
        fullHouseCards.add(new Card(14, "Diamonds"));
        fullHouseCards.add(new Card(14, "Clubs"));
        fullHouseCards.add(new Card(3, "Spades"));
        fullHouseCards.add(new Card(3, "Hearts"));
        PokerHand fullHouse = new PokerHand(fullHouseCards);

        int actual = fourKind.compareTo(fullHouse);
        Testing.assertTrue(mess, actual < 0);
    }

    /**
     * Test comparing hands from different categories
     */
    public static void testDifferentCategories() {
        Testing.testSection("Testing different categories");
        flushVsHighCard();
        flushVsPair();
    }

    /**
     * Test comparing hands within the same category
     */
    public static void testSameCategory() {
        Testing.testSection("Testing same category");
        highCardVsHighCard();
        twoPairVsTwoPair();
    }

    /**
     * Test hands that should tie
     */
    public static void testTies() {
        Testing.testSection("Testing ties");
        identicalHandsTie();
        samePairSameOtherCardsTie();
    }

    /**
     * Test complex cases within same category
     */
    public static void testComplexSameCategory() {
        Testing.testSection("Testing complex same category");
        fullHouseVsTwoPair();
        fourKindVsFullHouse();
    }


    public static void main(String[] args) {
        Testing.startTests();
        testDifferentCategories();
        testSameCategory();
        testTies();
        testComplexSameCategory();
        Testing.finishTests();
    }
}
