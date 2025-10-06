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
        """
        Add a card to the hand.
        :param card: the card to add
        """
        self.cards.append(card)

    def get_ith_card(self, i):
        """
        Get the i-th card from the hand.
        :param i: the index of the card to get
        :return: the card at index i
        """
        if 0 <= i < len(self.cards):
            return self.cards[i]
        return None

    def __str__(self):
        """
        Return a string representation of the hand.
        :return: a string representation of the hand 
        """
        s = ""
        for card in self.cards:
            s += str(card) + "\n"
        return s

    def __is_flush(self):
        """
        Check if this hand is a flush, all cards same suit.
        :return: a boolean value indicating if the hand is a flush
        """
        suits = []
        for card in self.cards:
            suits.append(card.get_suit())
        removed = set(suits)
        return len(removed) == 1


    def __is_straight(self):
        """
        Check if this hand is a straight, consecutive cards.
        :return: a boolean value indicating if the hand is a straight
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
        :return: a boolean value indicating if the hand has four cards of the same rank
        """
        counts = self.__rank_counts()
        if 4 in counts.values():
            return True
        return False


    def __is_full_house(self):
        """
        Check if this hand has three of one rank and two of another.
        :return: a boolean value indicating if the hand has three of one rank and two of another
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
        :return: a boolean value indicating if the hand has exactly three cards of the same rank
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
        :return: a boolean value indicating if the hand has exactly n pairs
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
        
        my_counts = self.__rank_counts()
        other_counts = other_hand.__rank_counts()
        
        my_list = []
        for rank in my_counts:
            my_list.append((my_counts[rank], rank))
        
        other_list = []
        for rank in other_counts:
            other_list.append((other_counts[rank], rank))
        
        my_list.sort(reverse=True)
        other_list.sort(reverse=True)
        
        for i in range(len(my_list)):
            my_rank = my_list[i][1]
            other_rank = other_list[i][1]
            
            if my_rank != other_rank:
                return my_rank - other_rank
     
        return 0



# if __name__ == "__main__":
#     flush_hand = [Card("2", "H"), Card("5", "H"), Card("9", "H"), Card("K", "H"), Card("A", "H")]
#     hand1 = PokerHand(flush_hand)
#     result1 = hand1._PokerHand__evaluate() 
#     print(result1)
