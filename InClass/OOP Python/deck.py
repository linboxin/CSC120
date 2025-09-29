"""defines a standard deck of 52 playing cards"""

from card import *

RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"]
SUITS = ["Clubs", "Diamonds", "Hearts", "Spades"]

class Deck:
    def __init__(self):
        self.__deck = []
        # self.suit = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"]
        # self.rank = ["Clubs", "Diamonds", "Hearts", "Spades"]

    def create(self):
        for rank in RANKS:
            for suit in SUITS:
                self.__deck.append(Card(rank, suit))

    def deal(self):
        if len(self.__deck) == 0:
            return None
        else:
            return self.__deck.pop(0)

    def __str__(self):
        # return str(self.__deck)

        # for i in range(len(self.__deck)):
        #     self.__deck[i] = str(self.__deck[i])
        # return str(self.__deck)
        cards = ""
        for card in self.__deck:
            cards += str(card) + "\n"

        return cards


def main():
    mydeck = Deck()
    mydeck.create()
    print(mydeck.deal())
    print(mydeck)

if __name__ == "__main__":
    main()