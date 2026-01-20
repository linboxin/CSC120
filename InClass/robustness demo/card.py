"""models a playing card"""

from constants import *

class Card:
    def __init__(self, rank=1, suit="Spades"):
        """
        constructor; defaults to Ace of Spades if no arguments given
        :param rank: int from 1-13 (Ace = 1)
        :param suit: string of suit completely spelled out
                     with initial letter capitalized (like "Spades")
        """
        if MIN_RANK <= rank <= MAX_RANK and suit in SUITS:
            self.__rank = rank
            self.__suit = suit
        else:
            self.__init__()

    def get_rank(self):
        """return MY rank as an int 1-13"""
        return self.__rank


    def get_suit(self):
        """return MY suit (like 'Spades')"""
        return self.__suit


    def __str__(self):
        """return MYSELF as a printable string"""
        rank = self.get_rank()
        if rank == 1:
            rank_string = "Ace"
        elif rank == 11:
            rank_string = "Jack"
        elif rank == 12:
            rank_string = "Queen"
        elif rank == 13:
            rank_string = "King"
        else:
            rank_string = str(rank)
        return rank_string + " of " + self.get_suit()


if __name__ == "__main__":
    card = Card()
    print(card)
    card2 = Card(3,"Hearts")
    print(card2)
    card3 = Card(0,"Clubs")
    print(card3)
    card4 = Card(2,"Ham")
    print(card4)