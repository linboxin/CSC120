/**
 * Author: James Lin
 * Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */


import java.util.Scanner;

class Client{
    /**
     * Plays a simple dice game:
     * 1) Uses a D6 and a D12.
     * 2) On each turn, rolls both dice and displays the results.
     * 3) The game is won when one die shows a value exactly twice the other;
     *    otherwise, roll again.
     */
    public static void main(String[] args) {
        Die diceOne = new Die();
        Die diceTwo = new Die(12);
        Scanner sc = new Scanner(System.in);

        boolean gameOver = false;
        String winner = "";

        while (!gameOver) {
            System.out.println("Press Enter to Continue");
            String userResponse = sc.nextLine();
            if  (userResponse.isEmpty()) {
                diceOne.roll();
                diceTwo.roll();

                if (diceOne.getValue()*2 == diceTwo.getValue()) {
                    gameOver = true;
                    winner = "Die 2";
                }else if (diceTwo.getValue()*2 == diceOne.getValue()) {
                    gameOver = true;
                    winner = "Die 1";
                }

                System.out.printf("Dice Rolled: %d, %d \n", diceOne.getValue(), diceTwo.getValue());

                if (winner != "") {
                    System.out.printf("Winner is: %s\n", winner);
                }
            }
        }
        sc.close();


    }
}