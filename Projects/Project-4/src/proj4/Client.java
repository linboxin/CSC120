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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        ArrayList<Card> communityCardList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            communityCardList.add(deck.deal());
        }
        CommunityCardSet communityCards = new CommunityCardSet(communityCardList);

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
            boolean correct = false;

            if (input.equals("a") && comparison > 0) {
                correct = true;
            } else if (input.equals("b") && comparison < 0) {
                correct = true;
            } else if (input.equals(" ") && comparison == 0) {
                correct = true;
            } else if (input.equals("") && comparison == 0) {
                correct = true;
            }

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
