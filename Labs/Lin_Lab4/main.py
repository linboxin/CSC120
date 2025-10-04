from die import *


def main():
    """
    Runs a die game with a D6 and D12.
    
    The game continues until one die is twice the value of the other. The game will continue to roll when users press Enter
    """
    dice_1 = Die()  
    dice_2 = Die(12)
    game_over = False
    winner = ""

    while not game_over: 
        user_response = input("Press Enter to roll the dice: ")
        if user_response == "":
            dice_1.roll()
            dice_2.roll()

            if (dice_1.get_value() * 2) == dice_2.get_value():
                winner = "Die 2"
                game_over = True
            elif (dice_2.get_value() * 2) == dice_1.get_value():
                winner = "Die 1"
                game_over = True

            print("Dice Rolled: ", dice_1.get_value(), dice_2.get_value())

            if winner:
                print(f"Winner is {winner}")


        

if __name__ == "__main__":
    main()