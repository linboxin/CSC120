package proj3;

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


    public static void main(String[] args) {
        Testing.startTests();
        testGetRank();
        testGetSuit();
        testToString();
        Testing.finishTests();
    }
}

