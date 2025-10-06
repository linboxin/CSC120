"""
Unit testing suite for PokerHand compare_to method
"""

from card import Card
from poker_hand import PokerHand
from testing import *


def test_different_categories():
    """Test comparing hands from different categories"""
    print("Testing different categories: ")
    print('-'*20)
    flush_vs_high_card()
    flush_vs_pair()


def test_same_category():
    """Test comparing hands within the same category"""
    print("Testing same category: ")
    print('-'*20)
    flush_vs_flush()
    high_card_vs_high_card()
    two_pair_vs_two_pair()


def test_ties():
    """Test hands that should tie"""
    print("Testing ties: ")
    print('-'*20)
    identical_hands_tie()
    same_pair_same_other_cards_tie()


def test_complex_same_category():
    """Test complex cases within same category such as two pair includes full house and four-of-a-kind"""
    print("Testing complex same category: ")
    print('-'*20)
    full_house_vs_two_pair()
    four_kind_vs_full_house()


def test_compare_to():
    """Main test function that runs all compare_to tests"""
    start_tests("Testing compare_to")
    test_different_categories()
    test_same_category()
    test_ties()
    test_complex_same_category()
    finish_tests()


"""
Individual unit tests start here
"""

def flush_vs_high_card():
    """Test that flush beats high card"""
    mess = "Flush vs high card "
    flush = PokerHand([Card(2, "H"), Card(5, "H"), Card(9, "H"), Card(13, "H"), Card(14, "H")])
    high_card = PokerHand([Card(2, "D"), Card(5, "C"), Card(7, "S"), Card(9, "D"), Card(11, "C")])
    actual = flush.compare_to(high_card)
    expected = "positive"
    
    if actual > 0:
        actual = "positive"
    
    assert_equals(mess, expected, actual)


def flush_vs_pair():
    """Test that flush beats pair"""
    mess = "Flush vs pair "
    flush = PokerHand([Card(2, "D"), Card(4, "D"), Card(6, "D"), Card(8, "D"), Card(10, "D")])
    pair = PokerHand([Card(14, "H"), Card(14, "D"), Card(13, "C"), Card(12, "S"), Card(11, "H")])
    actual = flush.compare_to(pair)
    expected = "positive"
    
    if actual > 0:
        actual = "positive"
    
    assert_equals(mess, expected, actual)


def flush_vs_flush():
    """Test comparing two flushes"""
    mess = "FLush vs flush"
    ace_flush = PokerHand([Card(2, "H"), Card(5, "H"), Card(9, "H"), Card(13, "H"), Card(14, "H")])
    queen_flush = PokerHand([Card(2, "D"), Card(5, "D"), Card(9, "D"), Card(12, "D"), Card(13, "D")])
    actual = ace_flush.compare_to(queen_flush)
    expected = "positive"
    
    if actual > 0:
        actual = "positive"
    
    assert_equals(mess, expected, actual)


def high_card_vs_high_card():
    """Test comparing two high card hands"""
    mess = "High card vs high card"
    king_high = PokerHand([Card(2, "H"), Card(4, "D"), Card(7, "C"), Card(9, "S"), Card(13, "H")])
    queen_high = PokerHand([Card(2, "D"), Card(4, "C"), Card(7, "S"), Card(9, "D"), Card(12, "C")])
    actual = king_high.compare_to(queen_high)
    expected = "positive"
    
    if actual > 0:
        actual = "positive"
    
    assert_equals(mess, expected, actual)


def identical_hands_tie():
    """Test that same ranks but different suits are a tie"""
    mess = "Same ranks but different suits"
    hand1 = PokerHand([Card(2, "H"), Card(5, "D"), Card(9, "C"), Card(13, "S"), Card(14, "H")])
    hand2 = PokerHand([Card(2, "D"), Card(5, "C"), Card(9, "H"), Card(13, "D"), Card(14, "C")])
    actual = hand1.compare_to(hand2)
    expected = 0
    
    assert_equals(mess, expected, actual)


def same_pair_same_other_cards_tie():
    """Test that same pair with same other cards are a tie"""
    mess = "Same pair, same other cards"
    hand1 = PokerHand([Card(10, "H"), Card(10, "D"), Card(5, "C"), Card(3, "S"), Card(2, "H")])
    hand2 = PokerHand([Card(10, "C"), Card(10, "S"), Card(5, "D"), Card(3, "H"), Card(2, "C")])
    actual = hand1.compare_to(hand2)
    expected = 0
    
    assert_equals(mess, expected, actual)


def two_pair_vs_two_pair():
    """Test comparing two two pair hands"""
    mess = "Two pair vs two pair"
    two_pair1 = PokerHand([Card(9, "H"), Card(9, "D"), Card(8, "C"), Card(8, "S"), Card(3, "H")])
    two_pair2 = PokerHand([Card(9, "C"), Card(9, "S"), Card(7, "D"), Card(7, "H"), Card(3, "C")])
    actual = two_pair1.compare_to(two_pair2)
    expected = "positive"
    
    if actual > 0:
        actual = "positive"
    
    assert_equals(mess, expected, actual)


def full_house_vs_two_pair():
    """Test that full house beats two pair"""
    mess = "Full house vs two pair"
    full_house = PokerHand([Card(5, "H"), Card(5, "D"), Card(5, "C"), Card(7, "S"), Card(7, "H")])
    two_pair = PokerHand([Card(7, "D"), Card(7, "C"), Card(6, "S"), Card(6, "H"), Card(3, "D")])
    actual = full_house.compare_to(two_pair)
    expected = "negative"
    
    if actual < 0:
        actual = "negative"
    
    assert_equals(mess, expected, actual)


def four_kind_vs_full_house():
    """Test four of a kind vs full house"""
    mess = "Four of a kind vs full house"
    four_kind = PokerHand([Card(13, "H"), Card(13, "D"), Card(13, "C"), Card(13, "S"), Card(2, "H")])
    full_house = PokerHand([Card(14, "H"), Card(14, "D"), Card(14, "C"), Card(3, "S"), Card(3, "H")])
    actual = four_kind.compare_to(full_house)
    expected = "negative"
    
    if actual < 0:
        actual = "negative"
    
    assert_equals(mess, expected, actual)


"""
Individual unit tests end here
"""

if __name__ == "__main__":
    test_compare_to()

