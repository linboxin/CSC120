package proj4;

/**
 * Tests the Card class methods including getRank, getSuit, and toString.
 */
public class CardTester {

    /**
     * Test Card constructor and getRank method
     */
    public static void testGetRank() {
        Testing.testSection("Testing getRank");

        Card card1 = new Card(2, "Hearts");
        Testing.assertEquals("Card rank 2", 2, card1.getRank());

        Card card2 = new Card(11, "Spades");
        Testing.assertEquals("Card rank 11 (Jack)", 11, card2.getRank());

        Card card3 = new Card(14, "Diamonds");
        Testing.assertEquals("Card rank 14 (Ace)", 14, card3.getRank());
    }

    /**
     * Test Card constructor and getSuit method
     */
    public static void testGetSuit() {
        Testing.testSection("Testing getSuit");

        Card card1 = new Card(5, "Hearts");
        Testing.assertEquals("Card suit Hearts", "Hearts", card1.getSuit());

        Card card2 = new Card(10, "Clubs");
        Testing.assertEquals("Card suit Clubs", "Clubs", card2.getSuit());

        Card card3 = new Card(13, "Diamonds");
        Testing.assertEquals("Card suit Diamonds", "Diamonds", card3.getSuit());

        Card card4 = new Card(7, "Spades");
        Testing.assertEquals("Card suit Spades", "Spades", card4.getSuit());
    }

    /**
     * Test Card toString method
     */
    public static void testToString() {
        Testing.testSection("Testing toString");

        Card card1 = new Card(2, "Hearts");
        Testing.assertEquals("2 of Hearts", "2 of Hearts", card1.toString());

        Card card2 = new Card(10, "Clubs");
        Testing.assertEquals("10 of Clubs", "10 of Clubs", card2.toString());

        Card card3 = new Card(11, "Spades");
        Testing.assertEquals("Jack of Spades", "Jack of Spades", card3.toString());

        Card card4 = new Card(12, "Diamonds");
        Testing.assertEquals("Queen of Diamonds", "Queen of Diamonds", card4.toString());

        Card card5 = new Card(13, "Hearts");
        Testing.assertEquals("King of Hearts", "King of Hearts", card5.toString());

        Card card6 = new Card(14, "Clubs");
        Testing.assertEquals("Ace of Clubs", "Ace of Clubs", card6.toString());
    }

    public static void testStringConstructor() {
        Testing.testSection("Testing String rank constructor");

        Card card1 = new Card("two", "Hearts");
        Testing.assertEquals("String 'two' creates rank 2", 2, card1.getRank());
        Testing.assertEquals("String constructor toString", "2 of Hearts", card1.toString());

        Card card2 = new Card("2", "Clubs");
        Testing.assertEquals("String '2' creates rank 2", 2, card2.getRank());

        Card card3 = new Card("jack", "Spades");
        Testing.assertEquals("String 'jack' creates rank 11", 11, card3.getRank());
        Testing.assertEquals("Jack toString", "Jack of Spades", card3.toString());

        Card card4 = new Card("QUEEN", "Diamonds");
        Testing.assertEquals("String 'QUEEN' case insensitive", 12, card4.getRank());
    }

    public static void testIntSuitConstructor() {
        Testing.testSection("Testing int suit constructor");

        Card card1 = new Card(5, 0);
        Testing.assertEquals("Suit 0 is Spades", "Spades", card1.getSuit());

        Card card2 = new Card(7, 1);
        Testing.assertEquals("Suit 1 is Hearts", "Hearts", card2.getSuit());

        Card card3 = new Card(9, 2);
        Testing.assertEquals("Suit 2 is Clubs", "Clubs", card3.getSuit());

        Card card4 = new Card(11, 3);
        Testing.assertEquals("Suit 3 is Diamonds", "Diamonds", card4.getSuit());
        Testing.assertEquals("Int suit toString", "Jack of Diamonds", card4.toString());
    }


    public static void main(String[] args) {
        Testing.startTests();
        testGetRank();
        testGetSuit();
        testToString();
        testStringConstructor();
        testIntSuitConstructor();
        Testing.finishTests();
    }
}