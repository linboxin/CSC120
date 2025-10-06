# • Flush (includes normal, royal, and straight flushes)
# • Two pair (includes two pair, four-of-a-kind, and full house)
# • Pair (includes pair and three-of-a-kind)
# • High card (includes high card and straight). Ace has the highest rank and Two has the lowest.


from card import Card


CATEGORY_VALUE = {
    "flush": 3,
    "two pair": 2,
    "pair": 1,
    "high card": 0,
}

class PokerHand:
    def __init__(self, cards):
        self.cards = cards.copy() 

    def add_card(self, card):
        self.cards.append(card)

    def get_ith_card(self, i):
        if 0 <= i < len(self.cards):
            return self.cards[i]
        return None

    def __str__(self):
        s = ""
        for card in self.cards:
            s += str(card) + "\n"
        return s

    def __is_flush(self):
        """
        Check if this hand is a flush, all cards same suit.
        :return: a boolean value
        """
        suits = []
        for card in self.cards:
            suits.append(card.get_suit())
        removed = set(suits)
        return len(removed) == 1


    def __is_straight(self):
        """
        Check if this hand is a straight, consecutive cards.
        :return: a boolean value
        """
        ranks = []
        for card in self.cards:
            ranks.append(card.get_rank())

        ranks.sort()
        for i in range(4):
            if ranks[i] + 1 != ranks[i + 1]:
                return False
        return True


    def __rank_counts(self):
        """
        Count how many cards of each rank are in this hand.
        :return: dictionary with rank counts
        {rank: count}
        {key: value}
        """
        counts = {}
        for card in self.cards:
            rank = card.get_rank()
            if rank in counts:
                counts[rank] += 1
            else:
                counts[rank] = 1
        return counts


    def __is_four_of_a_kind(self):
        """
        Check if this hand has four cards of the same rank.
        :return: a boolean value
        """
        counts = self.__rank_counts()
        if 4 in counts.values():
            return True
        return False


    def __is_full_house(self):
        """
        Check if this hand has three of one rank and two of another.
        :return: a boolean value
        """
        counts = self.__rank_counts().values()
        three = False
        two = False

        for count in counts:
            if count == 3:
                three = True
            elif count == 2:
                two = True

        return three and two


    def __is_three_of_a_kind(self):
        """
        Check if this hand has exactly three cards of the same rank.
        :return: a boolean value
        """
        counts = self.__rank_counts().values()
        if 3 in counts and not self.__is_full_house():
            return True
        return False 


    def __has_pairs(self, n):
        """
        Check if this hand has exactly n pairs.

        precondition: n is a positive integer and n <= 2
        :param n: number of pairs to check
        :return: a boolean value
        """
        counts = self.__rank_counts()
        pair_count = 0
        for value in counts.values():
            if value == 2:
                pair_count += 1
        return pair_count == n


    def __evaluate(self):
        """
        Evaluate this hand and return its category.
        Grouped into: flush, two pair, pair, or high card.
        :return: string representing the hand category
        """
        flush = self.__is_flush()
        straight = self.__is_straight()

        if flush and straight:
            return "flush"  
        elif flush:
            return "flush"
        elif self.__is_four_of_a_kind() or self.__is_full_house() or self.__has_pairs(2):
            return "two pair"
        elif self.__is_three_of_a_kind() or self.__has_pairs(1):
            return "pair"
        else:
            return "high card"  


    def __get_rank_values(self):
        """
        Get numeric rank values for all cards in this hand, sorted descending.
        :return: list of numeric rank values
        """
        ranks = []
        for card in self.cards:
            ranks.append(card.get_rank())
        ranks.sort(reverse=True)
        return ranks

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
   
        my_category = self.__evaluate()
        my_value = CATEGORY_VALUE[my_category]
    
        other_category = other_hand.__evaluate()
        other_value = CATEGORY_VALUE[other_category]
      

        category_diff = my_value - other_value
        if category_diff != 0:
            return category_diff
        
        my_ranks = self.__get_rank_values()
        other_ranks = other_hand.__get_rank_values()
        
        for i in range(len(my_ranks)):
            if my_ranks[i] != other_ranks[i]:
                return my_ranks[i] - other_ranks[i]
     
        return 0



# if __name__ == "__main__":
#     flush_hand = [Card("2", "H"), Card("5", "H"), Card("9", "H"), Card("K", "H"), Card("A", "H")]
#     hand1 = PokerHand(flush_hand)
#     result1 = hand1._PokerHand__evaluate() 
#     print(f"Flush test: {result1}")

#     full_house_hand = [Card("7", "H"), Card("7", "D"), Card("7", "C"), Card("K", "S"), Card("K", "H")]
#     hand8 = PokerHand(full_house_hand)
#     result8 = hand8._PokerHand__evaluate()
#     print(f"Full house test: {result8}")

#     high_card_hand = [Card("2", "D"), Card("5", "C"), Card("7", "H"), Card("9", "S"), Card("J", "D")]
#     hand_high = PokerHand(high_card_hand)
#     comparison = hand1.compare_to(hand_high)
#     print(f"Compare flush to high card: {comparison} (positive means flush wins)")
