"""
defines properties and behavior of a single playing card
"""

def create(rank, suit):
    """
    make a new card
    :param rank: single-character string: "A","2",...,"T","J","Q", or "K"
    :param suit: string; either "Clubs", "Diamonds", "Hearts", or "Spades"
    :return: a card of the given suit and rank
    """
    return (rank, suit)


def get_rank(card):
    """return the card's rank (like '5' or 'J')"""
    return card[0]


def get_suit(card):
    """return the card's suit (like 'Spades')"""
    return card[1]


def as_str(card):
    """return card as a printable string"""
    rank = get_rank(card)
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
    return rank_string + " of " + get_suit(card)