

class PokerHand:
    def __init__(self, cards):
        self.cards = cards.copy() 

    def add_card(self, card):
        self.cards.append(card)

    def get_ith_card(self, i):
        if 0 <i < len(self.cards):
            return self.cards[i]
        return None

    def __str__(self):
        s = ""
        for card in self.cards:
            s += str(card) + "\n"
        return s

    def compare_to(self, other_hand):
        """
        Determines which of two poker hands is worth more. Returns an int
        which is either positive, negative, or zero depending on the comparison.
        :param self: The first hand to compare
        :param other_hand: The second hand to compare
        :return: a negative number if self is worth LESS than other_hand,
        zero if they are worth the SAME (a tie), and a positive number if
        self is worth MORE than other_hand.
        """
