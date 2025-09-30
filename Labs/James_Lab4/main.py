from die import *

def main():
    dice_1 = Die(6)
    dice_test = Die()
    print(dice_test.get_sides())
    dice_2 = Die(12)
    game_over = False
    winner = ""

    while game_over != True: 
        user_response = input()
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