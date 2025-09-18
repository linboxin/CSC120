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

# print(create())

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

cards = create()
print(cards, len(cards))
shuffle(cards)
deal(cards, 2)
print(cards, len(cards))