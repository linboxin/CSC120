"""
defines properties and behavior of a single playing card
"""
class Card:
    """all functions will be indented inside this class"""
    """functions are now methods"""

    def __init__(self, rank, suit):
        """
        construct a brand new card from given rank & suit
        :param suit: string written out like "Spades"
        :param rank: abbreviated like "A", "2", "J"
        """
        self.__rank = rank #self. prefix says instance var
        self.__suit = suit
        # self.__rank_suit = {"rank":rank, "suit":suit}

    def get_rank(self):
        """return card's rank"""
        return self.__rank

    def get_suit(self):
        """return card's suit"""
        return self.__suit

    def __str__(self):
        """returns card as printable string"""
        rank = self.get_rank()
        if rank == "A":
            rank_string = "Ace"
        elif rank == "T":
            rank_string = "Ten"
        elif rank == "J":
            rank_string = "Jack"
        elif rank == "Q":
            rank_string = "Queen"
        elif rank == "K":
            rank_string = "King"
        else:
            rank_string = rank
        return rank_string + " of " + self.get_suit()
