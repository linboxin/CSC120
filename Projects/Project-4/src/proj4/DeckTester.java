package proj4;

/**
 * Tests the Deck class methods including shuffle, deal, size, isEmpty, gather, and toString.
 */
public class DeckTester {

    /**
     * Test Deck constructor creates 52 cards
     */
    public static void testDeckConstructor() {
        Testing.testSection("Testing Deck constructor");

        Deck deck = new Deck();
        Testing.assertEquals("New deck has 52 cards", 52, deck.size());
        Testing.assertFalse("New deck is not empty", deck.isEmpty());
    }

    /**
     * Test Deck size method
     */
    public static void testSize() {
        Testing.testSection("Testing size");

        Deck deck = new Deck();
        Testing.assertEquals("Initial size is 52", 52, deck.size());

        deck.deal();
        Testing.assertEquals("Size after dealing one card is 51", 51, deck.size());

        for (int i = 0; i < 5; i++) {
            deck.deal();
        }
        Testing.assertEquals("Size after dealing 6 cards total is 46", 46, deck.size());
    }

    /**
     * Test Deck isEmpty method
     */
    public static void testIsEmpty() {
        Testing.testSection("Testing isEmpty");
        Deck deck = new Deck();
        Testing.assertFalse("New deck is not empty", deck.isEmpty());

        for (int i = 0; i < 52; i++) {
            deck.deal();
        }
        Testing.assertTrue("Deck is empty after dealing all cards", deck.isEmpty());
        Card nullCard = deck.deal();
        Testing.assertEquals("Dealing from empty deck returns null", null, nullCard);
    }

    /**
     * Test Deck deal method
     */
    public static void testDeal() {
        Testing.testSection("Testing deal");

        Deck deck = new Deck();

        Card card1 = deck.deal();
        Testing.assertEquals("First card rank is 2", 2, card1.getRank());
        Testing.assertEquals("First card suit is Spades", "Spades", card1.getSuit());

        Testing.assertEquals("Size after one deal is 51", 51, deck.size());

        Card card2 = deck.deal();
        Testing.assertFalse("Second card is different from first", card1.getRank() == card2.getRank() && card1.getSuit().equals(card2.getSuit()));
    }

    /**
     * Test Deck gather method
     */
    public static void testGather() {
        Testing.testSection("Testing gather");

        Deck deck = new Deck();
        for (int i = 0; i < 10; i++) {
            deck.deal();
        }
        Testing.assertEquals("Size after dealing 10 cards is 42", 42, deck.size());

        deck.gather();
        Testing.assertEquals("Size after gather is 52", 52, deck.size());
        Testing.assertFalse("Deck is not empty after gather", deck.isEmpty());
    }

    /**
     * Test Deck shuffle method
     */
    public static void testShuffle() {
        Testing.testSection("Testing shuffle");

        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        Card[] unshuffled = new Card[5];
        for (int i = 0; i < 5; i++) {
            unshuffled[i] = deck1.deal();
        }

        deck2.shuffle();
        Card[] shuffled = new Card[5];
        for (int i = 0; i < 5; i++) {
            shuffled[i] = deck2.deal();
        }

        deck1.gather();
        deck1.shuffle();
        Testing.assertEquals("Shuffled deck still has 52 cards", 52, deck1.size());

        Card card = deck1.deal();
        Testing.assertFalse("Can still deal after shuffle", card == null);
    }

    /**
     * Test Deck toString method
     */
    public static void testToString() {
        Testing.testSection("Testing toString");

        Deck deck = new Deck();
        String deckStr = deck.toString();
        Testing.assertFalse("toString returns non-empty string", deckStr.isEmpty());
        Testing.assertTrue("toString contains card descriptions", deckStr.contains("of"));
        for (int i = 0; i < 10; i++) {
            deck.deal();
        }
        String shorterStr = deck.toString();
        Testing.assertTrue("toString is shorter after dealing cards", shorterStr.length() < deckStr.length());
    }


    public static void main(String[] args) {
        Testing.startTests();
        testDeckConstructor();
        testSize();
        testIsEmpty();
        testDeal();
        testGather();
        testShuffle();
        testToString();
        Testing.finishTests();
    }
}
