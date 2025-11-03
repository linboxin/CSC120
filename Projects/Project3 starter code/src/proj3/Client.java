package proj3;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A poker game client where players guess which hand wins in multiple rounds.
 */
public class Client {

    /**
     * Deals a single 5 card poker hand from the deck.
     * @param deck the deck to deal from
     * @return a PokerHand containing 5 cards
     */
    public static PokerHand dealHand(Deck deck) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cards.add(deck.deal());
        }
        return new PokerHand(cards);
    }

    /**
     * Runs the poker guessing game where players predict which hand wins.
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Scanner scanner = new Scanner(System.in);
        int roundNumber = 1;
        int correctGuesses = 0;

        while (deck.size() >= 10) {
            System.out.println("Round " + roundNumber);

            PokerHand hand1 = dealHand(deck);
            PokerHand hand2 = dealHand(deck);

            System.out.println("Hand 1:");
            System.out.print(hand1);
            System.out.println("Hand 2:");
            System.out.print(hand2);

            System.out.print("Who wins? (1 for Hand 1, 2 for Hand 2, 0 for Tie): ");
            int playerGuess = scanner.nextInt();

            int comparison = hand1.compareTo(hand2);
            int actualWinner;
            String result;

            if (comparison > 0) {
                actualWinner = 1;
                result = "Hand 1 wins!";
            } else if (comparison < 0) {
                actualWinner = 2;
                result = "Hand 2 wins!";
            } else {
                actualWinner = 0;
                result = "It's a tie!";
            }

            if (playerGuess == actualWinner) {
                System.out.println("Correct! " + result);
                correctGuesses++;
            } else {
                System.out.println("Incorrect. " + result);
            }

            System.out.println("Cards remaining: " + deck.size());
            System.out.println();

            roundNumber++;
        }

        System.out.println("Game Over! Not enough cards left to play another round.");
        System.out.println("You played " + (roundNumber - 1) + " rounds and won " + correctGuesses + " times");

        scanner.close();
    }
}

