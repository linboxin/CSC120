import random
from card import Card

RANKS = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
SUITS = ["S", "C", "H", "D"]

class Deck:

    def __init__(self):
        self.__deck = []
        for suit in SUITS:
            for rank in RANKS:
                self.__deck.append(Card(rank, suit))

    def shuffle(self):
        random.shuffle(self.__deck)

    def deal(self):
        if len(self.__deck) == 0:
            return None
        else:
            return self.__deck.pop(0)

    def size(self):
        return len(self.__deck)

    def __str__(self):
        s = ""
        for card in self.__deck:
            s += str(card) + "\n"
        return s

# if __name__ == "__main__":
#     deck = Deck()
#     print(deck.size())
#     print(deck)