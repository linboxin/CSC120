"""
defines a standard deck of 52 playing cards
"""

import old_card as c

RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"]
SUITS = ["Clubs", "Diamonds", "Hearts", "Spades"]

def create():
    """build a deck"""
    contents = []
    for rank in RANKS:
        for suit in SUITS:
            contents.append(c.create(rank, suit))
    return contents

def deal(deck):
    """remove and return top card"""
    if len(deck) == 0:
        return None
    else:
        return deck.pop(0)