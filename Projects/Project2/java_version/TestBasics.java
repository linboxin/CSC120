import java.util.ArrayList;

/**
 * Simple test program to verify basic functionality of Card, Deck, and PokerHand classes.
 * 
 * @author James Lin
 * @version 1.0
 */
public class TestBasics {
    public static void main(String[] args) {
        System.out.println("=== Testing Card Class ===");
        Card card1 = new Card(11, "Diamonds");
        Card card2 = new Card(7, "Hearts");
        Card card3 = new Card(14, "Spades");
        
        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
        System.out.println("Card 3: " + card3);
        System.out.println();
        
        System.out.println("=== Testing Deck Class ===");
        Deck deck = new Deck();
        System.out.println("Initial deck size: " + deck.size());
        System.out.println("Deck is empty? " + deck.isEmpty());
        
        System.out.println("\nShuffling deck...");
        deck.shuffle();
        
        System.out.println("\nDealing 5 cards:");
        for (int i = 0; i < 5; i++) {
            Card card = deck.deal();
            System.out.println((i + 1) + ". " + card);
        }
        
        System.out.println("\nCards remaining: " + deck.size());
        
        System.out.println("\nGathering cards back...");
        deck.gather();
        System.out.println("Deck size after gather: " + deck.size());
        System.out.println();
        
        System.out.println("=== Testing PokerHand Class ===");
        // Create a flush hand (all Hearts)
        ArrayList<Card> flushCards = new ArrayList<>();
        flushCards.add(new Card(2, "Hearts"));
        flushCards.add(new Card(5, "Hearts"));
        flushCards.add(new Card(9, "Hearts"));
        flushCards.add(new Card(13, "Hearts"));
        flushCards.add(new Card(14, "Hearts"));
        PokerHand flushHand = new PokerHand(flushCards);
        
        // Create a pair hand
        ArrayList<Card> pairCards = new ArrayList<>();
        pairCards.add(new Card(7, "Diamonds"));
        pairCards.add(new Card(7, "Clubs"));
        pairCards.add(new Card(3, "Spades"));
        pairCards.add(new Card(10, "Hearts"));
        pairCards.add(new Card(14, "Spades"));
        PokerHand pairHand = new PokerHand(pairCards);
        
        // Create a high card hand
        ArrayList<Card> highCardCards = new ArrayList<>();
        highCardCards.add(new Card(2, "Diamonds"));
        highCardCards.add(new Card(5, "Clubs"));
        highCardCards.add(new Card(8, "Spades"));
        highCardCards.add(new Card(11, "Hearts"));
        highCardCards.add(new Card(14, "Clubs"));
        PokerHand highCardHand = new PokerHand(highCardCards);
        
        System.out.println("Flush Hand:");
        System.out.print(flushHand);
        
        System.out.println("Pair Hand:");
        System.out.print(pairHand);
        
        System.out.println("High Card Hand:");
        System.out.print(highCardHand);
        
        System.out.println("=== Testing compareTo ===");
        int result1 = flushHand.compareTo(pairHand);
        System.out.println("Flush vs Pair: " + result1 + " (positive = flush wins)");
        
        int result2 = pairHand.compareTo(highCardHand);
        System.out.println("Pair vs High Card: " + result2 + " (positive = pair wins)");
        
        int result3 = highCardHand.compareTo(flushHand);
        System.out.println("High Card vs Flush: " + result3 + " (negative = flush wins)");
        
        System.out.println("\n=== All tests completed successfully! ===");
    }
}

