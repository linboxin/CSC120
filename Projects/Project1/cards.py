"""
For this project, I first thought of using list of strings as card representation, because I thought that it would save me more time to write but then as i work more into this project
I realized that string isn't really the best choice. I thought of using a dictionary, but that would've been a hassle for me, so the best option I had was to go with tuples.
And I now believe tuples is a better option to go with for this project, it could clearly separate the rank and suits, it is also easy for me access the rank and suits at any time.

One part of the code that required significant refactoring was in hands.py. At first, I tried to write just four functions to handle Flush, Two Pair, One Pair, and High Card.
But this approach quickly became complicated, especially since Flush includes multiple variations like regular Flush, Straight Flush, and Royal Flush. So instead of forcing
those four functions, I wrote a bunch of different functions to identify the hands and evaluate them into these 4 groups.
"""

import random

ranks = ["2","3","4","5","6","7","8","9","10","J","Q","K","A"]
suits = ["Spades","Clubs","Hearts","Diamonds"]

def create():
    """
    Create a list of cards in tuple form and returns them.
    :return: a list of tuples that represent cards
    """
    deck = []
    for rank in ranks:
        for suit in suits:
            deck.append((rank, suit))
    return deck


def shuffle(deck):
    """"
    Shuffles the deck.
    :param deck: a list of tuples that represent cards
    """
    random.shuffle(deck)

def deal(deck, n):
    """
    Deals n cards from the deck.
    :param deck: a list of tuples that represent cards
    :param n: the number of cards to deal
    :return: the dealed cards
    """
    hands = []
    for _ in range(n):
        hands.append(deck.pop(0))
    return hands
