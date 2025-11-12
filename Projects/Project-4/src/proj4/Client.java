/**
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 * @author: James Lin
 */



package proj4;

import java.util.ArrayList;
import java.util.Scanner;

//1. Draw two new 2-card hands from a given deck. These are the hole cards.
//2. Print the community cards and the hands.
//3. Ask the user who the winner is (or if there's a tie), taking into account the community cards.
//4. If the player is correct, they get one point and the game continues.
//5. If the player is incorrect, the game ends and the player's total points should be displayed.
//6. The game is also over if there are not enough cards left in the deck to play another round.

public class Client {


    /**
     * Deals 5 community cards from the deck and creates a community card set.
     * @param deck the deck to deal from
     * @return a community card set with 5 cards
     */
    private static CommunityCardSet dealCommunityCards(Deck deck) {
        ArrayList<Card> communityCardList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            communityCardList.add(deck.deal());
        }
        return new CommunityCardSet(communityCardList);
    }

    /**
     * Checks if the users input correctly identifies the winner.
     * @param input the users input ("a", "b", or " ")
     * @param comparison the result of handA.compareTo(handB)
     * @return true if they are acutally equal, false otherwise
     */
    private static boolean isCorrectGuess(String input, int comparison) {
        if (input.equals("a")) {
            return comparison > 0;
        } else if (input.equals("b")) {
            return comparison < 0;
        } else if (input.equals(" ") || input.equals("")) {
            return comparison == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        CommunityCardSet communityCards = dealCommunityCards(deck);

        int score = 0;
        boolean playing = true;

        while (playing) {
            if (deck.size() < 4) {
                System.out.println("Not enough cards left in the deck!");
                break;
            }

            ArrayList<Card> holeA = new ArrayList<>();
            holeA.add(deck.deal());
            holeA.add(deck.deal());
            StudPokerHand handA = new StudPokerHand(communityCards, holeA);

            ArrayList<Card> holeB = new ArrayList<>();
            holeB.add(deck.deal());
            holeB.add(deck.deal());
            StudPokerHand handB = new StudPokerHand(communityCards, holeB);

            System.out.println("The community cards are:");
            System.out.println(communityCards.toString());
            System.out.println();
            System.out.println("Which of the following hands is worth more?");
            System.out.println("Hand a:");
            System.out.println(handA.toString());
            System.out.println("or");
            System.out.println("Hand b:");
            System.out.println(handB.toString());
            System.out.println("Enter a or b (or SPACE to indicate they are of equal value)");

            String input = scanner.nextLine();
            System.out.println("got input: " + input);

            int comparison = handA.compareTo(handB);
            boolean correct = isCorrectGuess(input, comparison);

            if (correct) {
                System.out.println("CORRECT!!!");
                score++;
                System.out.println("-----------------------------------------------");
            } else {
                System.out.println("INCORRECT!");
                playing = false;
            }
        }

        System.out.println("Game over! Your final score: " + score);
        scanner.close();
    }
}
