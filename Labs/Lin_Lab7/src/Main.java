import java.util.Scanner;

class Main{
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