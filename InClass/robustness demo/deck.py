"""models a deck of playing cards"""

from constants import *
from card import *
import random

class Deck:

    def __init__(self):
        """constructor"""
        self.gather()

    def shuffle(self):
        """shuffle cards in place"""
        random.shuffle(self.__contents)

    def deal(self):
        """returns a single card or None if deck empty"""
        if self.is_empty():
            return None
        else:
            return self.__contents.pop(0)

    def is_empty(self):
        """returns True if deck has no more cards.  Else False."""
        return self.size() == 0

    def size(self):
        """returns the number of (undealt) cards left in the deck"""
        return len(self.__contents)

    def get_contents(self):
        """returns the list holding the cards"""
        return self.__contents

    def gather(self):
        values = range(MIN_RANK, MAX_RANK + 1)  # 1 = Ace
        self.__contents = []
        for suit in SUITS:
            for value in values:
                self.__contents.append(Card(value, suit))



    def __str__(self):
        """return deck in string format"""
        to_return = "DECK CONTAINS:\n"
        for card in self.__contents:
            to_return+=str(card) + "\n"
        return to_return


if __name__ == '__main__':
    my_deck = Deck()
    my_deck.shuffle()
    for i in range(10):

        print(my_deck.deal())

    print("Current Decks")
    print(my_deck)
    print("Current Decks Finished")

    print(my_deck.gather())
    print("all done")
