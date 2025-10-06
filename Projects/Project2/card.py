RANK_NAMES = {
    11: "Jack",
    12: "Queen",
    13: "King",
    14: "Ace"
}

SUIT_NAMES = {
    "H": "Hearts",
    "D": "Diamonds",
    "C": "Clubs",
    "S": "Spades"
}

class Card:
    def __init__(self, rank, suit):
        self.__card = {"rank": rank, "suit": suit} 

    def get_rank(self):
        """
        Get the rank of the card.
        :return: the rank of the card
        """
        return self.__card["rank"]

    def get_suit(self):
        """
        Get the suit of the card.
        :return: the suit of the card
        """
        return self.__card["suit"]

    def __str__(self):
        """
        Return a string representation of the card.
        :return: a string representation of the card
        """
        rank_str = RANK_NAMES.get(self.get_rank(), str(self.get_rank()))
        suit_str = SUIT_NAMES.get(self.get_suit(), self.get_suit())
        return f"{rank_str} of {suit_str}"



# if __name__ == "__main__":
#     card1 = Card(12, "D")
#     card2 = Card(10, "S")
#     print(card1)  
#     print(card2)  