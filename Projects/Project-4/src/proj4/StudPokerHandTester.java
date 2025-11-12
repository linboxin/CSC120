package proj4;

import java.util.ArrayList;

public class StudPokerHandTester {

    public static void testConstructor() {
        Testing.testSection("Testing StudPokerHand constructor");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(2, "Hearts"));
        communityCards.add(new Card(5, "Spades"));
        communityCards.add(new Card(9, "Clubs"));
        communityCards.add(new Card(11, "Diamonds"));
        communityCards.add(new Card(14, "Hearts"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeCards = new ArrayList<>();
        holeCards.add(new Card(3, "Hearts"));
        holeCards.add(new Card(7, "Spades"));
        StudPokerHand hand = new StudPokerHand(ccs, holeCards);

        Testing.assertEquals("First hole card is 3 of Hearts", "3 of Hearts", hand.getIthCard(0).toString());
        Testing.assertEquals("Second hole card is 7 of Spades", "7 of Spades", hand.getIthCard(1).toString());
    }

    public static void testAddCard() {
        Testing.testSection("Testing addCard");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(2, "Hearts"));
        communityCards.add(new Card(5, "Spades"));
        communityCards.add(new Card(9, "Clubs"));
        communityCards.add(new Card(11, "Diamonds"));
        communityCards.add(new Card(14, "Hearts"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeCards = new ArrayList<>();
        holeCards.add(new Card(3, "Hearts"));
        StudPokerHand hand = new StudPokerHand(ccs, holeCards);

        hand.addCard(new Card(7, "Spades"));
        Testing.assertEquals("Second card added", "7 of Spades", hand.getIthCard(1).toString());

        hand.addCard(new Card(10, "Diamonds"));
        Testing.assertEquals("Third card not added", null, hand.getIthCard(2));
    }

    public static void testGetIthCard() {
        Testing.testSection("Testing getIthCard");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(2, "Hearts"));
        communityCards.add(new Card(5, "Spades"));
        communityCards.add(new Card(9, "Clubs"));
        communityCards.add(new Card(11, "Diamonds"));
        communityCards.add(new Card(14, "Hearts"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeCards = new ArrayList<>();
        holeCards.add(new Card(6, "Clubs"));
        holeCards.add(new Card(8, "Diamonds"));
        StudPokerHand hand = new StudPokerHand(ccs, holeCards);

        Testing.assertEquals("Get first card", "6 of Clubs", hand.getIthCard(0).toString());
        Testing.assertEquals("Get second card", "8 of Diamonds", hand.getIthCard(1).toString());
        Testing.assertEquals("Invalid index returns null", null, hand.getIthCard(2));
        Testing.assertEquals("Negative index returns null", null, hand.getIthCard(-1));
    }

    public static void testToString() {
        Testing.testSection("Testing toString");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(2, "Hearts"));
        communityCards.add(new Card(5, "Spades"));
        communityCards.add(new Card(9, "Clubs"));
        communityCards.add(new Card(11, "Diamonds"));
        communityCards.add(new Card(14, "Hearts"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeCards = new ArrayList<>();
        holeCards.add(new Card(6, "Spades"));
        holeCards.add(new Card(8, "Clubs"));
        StudPokerHand hand = new StudPokerHand(ccs, holeCards);

        String expected = "6 of Spades, 8 of Clubs";
        Testing.assertEquals("toString format", expected, hand.toString());
    }

    public static void testCompareTo() {
        Testing.testSection("Testing compareTo");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(12, "Spades"));
        communityCards.add(new Card(5, "Diamonds"));
        communityCards.add(new Card(2, "Spades"));
        communityCards.add(new Card(6, "Clubs"));
        communityCards.add(new Card(7, "Diamonds"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeA = new ArrayList<>();
        holeA.add(new Card(6, "Spades"));
        holeA.add(new Card(8, "Clubs"));
        StudPokerHand handA = new StudPokerHand(ccs, holeA);

        ArrayList<Card> holeB = new ArrayList<>();
        holeB.add(new Card(4, "Clubs"));
        holeB.add(new Card(8, "Spades"));
        StudPokerHand handB = new StudPokerHand(ccs, holeB);

        Testing.assertTrue("Hand A is better than Hand B", handA.compareTo(handB) > 0);

        ArrayList<Card> holeC = new ArrayList<>();
        holeC.add(new Card(13, "Hearts"));
        holeC.add(new Card(2, "Hearts"));
        StudPokerHand handC = new StudPokerHand(ccs, holeC);

        ArrayList<Card> holeD = new ArrayList<>();
        holeD.add(new Card(6, "Hearts"));
        holeD.add(new Card(11, "Spades"));
        StudPokerHand handD = new StudPokerHand(ccs, holeD);

        Testing.assertTrue("Hand D is better than Hand C", handD.compareTo(handC) > 0);
    }

    public static void testFlushBeatsAces() {
        Testing.testSection("Testing flush beats pair of aces");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(2, "Hearts"));
        communityCards.add(new Card(5, "Hearts"));
        communityCards.add(new Card(8, "Hearts"));
        communityCards.add(new Card(10, "Hearts"));
        communityCards.add(new Card(3, "Clubs"));
        CommunityCardSet ccs = new CommunityCardSet(communityCards);

        ArrayList<Card> holeA = new ArrayList<>();
        holeA.add(new Card(14, "Spades"));
        holeA.add(new Card(14, "Diamonds"));
        StudPokerHand handA = new StudPokerHand(ccs, holeA);

        ArrayList<Card> holeB = new ArrayList<>();
        holeB.add(new Card(7, "Hearts"));
        holeB.add(new Card(4, "Clubs"));
        StudPokerHand handB = new StudPokerHand(ccs, holeB);

        Testing.assertTrue("Hand B (flush) beats Hand A (pair of aces)", handB.compareTo(handA) > 0);
    }

    public static void main(String[] args) {
        Testing.startTests();
        testConstructor();
        testAddCard();
        testGetIthCard();
        testToString();
        testCompareTo();
        testFlushBeatsAces();
        Testing.finishTests();
    }
}
