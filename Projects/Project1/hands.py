#  Poker Hands
# • Flush (includes normal, royal, and straight flushes)
# • Two pair (includes two pair, four-of-a-kind, and full house)
# • Pair (includes pair and three-of-a-kind)
# • High card (includes high card and straight). Ace has the highest rank and Two has the lowest.

def is_flush(hands):
    """
    Check if a hand is a flush, all cards same suit.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: a boolean value
    """
    suits = []
    for card in hands:
        suits.append(card[1])
    removed = set(suits)
    return len(removed) == 1


def is_straight(hands):
    """
    Check if a hand is a straight, consecutive cards.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: a boolean value
    """
    rank_order = {"2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9, "10": 10, "J": 11, "Q": 12, "K": 13, "A": 14}
    ranks = []
    for card in hands:
        rank = card[0]
        ranks.append(rank_order[rank])

    ranks.sort()
    for i in range(4):
        if ranks[i] + 1 != ranks[i + 1]:
            return False
    return True


def rank_counts(hands):
    """
    Count how many cards of each rank are in the hand.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: dictionary with rank counts
    {rank: count}
    {key: value}
    """
    counts = {}
    for card in hands:
        rank = card[0]
        if rank in counts:
            counts[rank] += 1
        else:
            counts[rank] = 1
    return counts


def is_four_of_a_kind(hands):
    """
    Check if a hand has four cards of the same rank.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: a boolean value
    """
    counts = rank_counts(hands)
    if 4 in counts.values():
        return True
    return False


def is_full_house(hands):
    """
    Check if a hand has three of one rank and two of another.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: a boolean value
    """
    counts = rank_counts(hands).values()
    three = False
    two = False

    for count in counts:
        if count == 3:
            three = True
        elif count == 2:
            two = True

    return three and two


def is_three_of_a_kind(hands):
    """
    Check if a hand has exactly three cards of the same rank.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: a boolean value
    """
    counts = rank_counts(hands).values()
    if 3 in counts and not is_full_house(hands):
        return True
    return False 


def has_pairs(hands, n):
    """
    Check if a hand has exactly n pairs.

    precondition: n is a positive integer and n <= 2
    :param hands: list of 5 cards as tuples (rank, suit)
    :param n: number of pairs to check
    :return: a boolean value
    """
    counts = rank_counts(hands)
    pair_count = 0
    for value in counts.values():
        if value == 2:
            pair_count += 1
    return pair_count == n


def evaluate(hands):
    """
    Evaluate a hand and return its category.
    Grouped into: flush, two pair, pair, or high card.
    :param hands: list of 5 cards as tuples (rank, suit)
    :return: string representing the hand category
    """
    flush = is_flush(hands)
    straight = is_straight(hands)

    if flush and straight:
        return "flush"  
    elif flush:
        return "flush"
    elif is_four_of_a_kind(hands) or is_full_house(hands) or has_pairs(hands, 2):
        return "two pair"
    elif is_three_of_a_kind(hands) or has_pairs(hands, 1):
        return "pair"
    else:
        return "high card"  




