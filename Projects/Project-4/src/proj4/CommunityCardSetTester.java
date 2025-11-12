package proj4;

import java.util.ArrayList;

public class CommunityCardSetTester {

    public static void testConstructor() {
        Testing.testSection("Testing CommunityCardSet constructor");

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "Hearts"));
        cards.add(new Card(10, "Spades"));
        cards.add(new Card(14, "Diamonds"));

        CommunityCardSet ccs = new CommunityCardSet(cards);
        Testing.assertEquals("First card is 2 of Hearts", "2 of Hearts", ccs.getIthCard(0).toString());
        Testing.assertEquals("Second card is 10 of Spades", "10 of Spades", ccs.getIthCard(1).toString());
        Testing.assertEquals("Third card is Ace of Diamonds", "Ace of Diamonds", ccs.getIthCard(2).toString());
    }


    public static void testAddCard() {
        Testing.testSection("Testing addCard");

        ArrayList<Card> cards = new ArrayList<>();
        CommunityCardSet ccs = new CommunityCardSet(cards);

        ccs.addCard(new Card(5, "Clubs"));
        Testing.assertEquals("First card added", "5 of Clubs", ccs.getIthCard(0).toString());

        ccs.addCard(new Card(11, "Hearts"));
        ccs.addCard(new Card(2, "Spades"));
        ccs.addCard(new Card(3, "Spades"));
        ccs.addCard(new Card(4, "Spades"));
        Testing.assertEquals("Fifth card added", "4 of Spades", ccs.getIthCard(4).toString());

        ccs.addCard(new Card(10, "Diamonds"));
        Testing.assertEquals("Sixth card not added", null, ccs.getIthCard(5));
    }

    public static void testGetIthCard() {
        Testing.testSection("Testing getIthCard");

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(7, "Hearts"));
        cards.add(new Card(9, "Clubs"));
        cards.add(new Card(13, "Spades"));

        CommunityCardSet ccs = new CommunityCardSet(cards);

        Testing.assertEquals("Get card at index 0", "7 of Hearts", ccs.getIthCard(0).toString());
        Testing.assertEquals("Get card at index 1", "9 of Clubs", ccs.getIthCard(1).toString());
        Testing.assertEquals("Get card at index 2", "King of Spades", ccs.getIthCard(2).toString());
        Testing.assertEquals("Invalid index returns null", null, ccs.getIthCard(3));
        Testing.assertEquals("Negative index returns null", null, ccs.getIthCard(-1));
    }

    public static void testToString() {
        Testing.testSection("Testing toString");

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(12, "Spades"));
        cards.add(new Card(5, "Diamonds"));
        cards.add(new Card(2, "Spades"));
        cards.add(new Card(6, "Clubs"));
        cards.add(new Card(7, "Diamonds"));

        CommunityCardSet ccs = new CommunityCardSet(cards);
        String expected = "Queen of Spades | 5 of Diamonds | 2 of Spades | 6 of Clubs | 7 of Diamonds";
        Testing.assertEquals("toString format", expected, ccs.toString());

        ArrayList<Card> oneCard = new ArrayList<>();
        oneCard.add(new Card(14, "Hearts"));
        CommunityCardSet ccs2 = new CommunityCardSet(oneCard);
        Testing.assertEquals("toString with one card", "Ace of Hearts", ccs2.toString());

        ArrayList<Card> empty = new ArrayList<>();
        CommunityCardSet ccs3 = new CommunityCardSet(empty);
        Testing.assertEquals("toString with empty set", "", ccs3.toString());
    }

    public static void main(String[] args) {
        Testing.startTests();
        testConstructor();
        testAddCard();
        testGetIthCard();
        testToString();
        Testing.finishTests();
    }
}