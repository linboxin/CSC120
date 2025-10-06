"""
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

from deck import Deck

from poker_hand import PokerHand

HAND_SIZE = 5

def deal_two_hands(deck):
    cards1 = []
    cards2 = []
    for _ in range(HAND_SIZE):
        cards1.append(deck.deal())
    for _ in range(HAND_SIZE):
        cards2.append(deck.deal())
    return cards1, cards2


def main():
    """
    1. Draws two new hands from a given deck.
    2. Shows the hands to the player, asking them who the winner is (or if there's a tie)
    3. Tells if the player is correct or incorrect. Go to step 1.
    4. The game is over if there are not enough cards left to play another round.
    """ 

    deck = Deck()
    deck.shuffle()
    game_count = 1

    
    while deck.size() >= HAND_SIZE * 2:
        print(f"Round {game_count}")
        print("-" * 50)
        
        cards1, cards2 = deal_two_hands(deck)
        hand1 = PokerHand(cards1)
        hand2 = PokerHand(cards2)

        print("Hand 1:")
        print(hand1)
        print("Hand 2:")
        print(hand2)

        player_guess = input("Who wins? (1 for Hand 1, 2 for Hand 2, 0 for Tie): ")
        
        comparison = hand1.compare_to(hand2)
        
        if comparison > 0:
            actual_winner = 1
            result_msg = "Hand 1 wins!"
        elif comparison < 0:
            actual_winner = 2
            result_msg = "Hand 2 wins!"
        else:
            actual_winner = 0
            result_msg = "It's a tie!"
        

        player_guess = int(player_guess)
        if player_guess == actual_winner:
            print(f"Correct! {result_msg}")
        else:
            print(f"Incorrect. {result_msg}")

        
        print(f"Cards remaining: {deck.size()}")
        print()
        
        game_count += 1
    
    print("=" * 50)
    print(f"Game Over! Not enough cards left to play another round.")
    print(f"You played {game_count - 1} rounds.")
        




if __name__ == "__main__":
    main()