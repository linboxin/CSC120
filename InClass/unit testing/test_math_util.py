"""testing suite for math_util module"""

from math_util import *
from testing import *

def test_total():
    start_tests("Start testing")
    two_pos()
    two_neg()
    both_pos_neg()
    finish_tests()

def test_product():
    pass

"""
Individual unit tests start here
"""
def two_pos():
    mess = "Total of two positive numbers"
    actual = total(4,6)
    expected = 10

    assert_equals(mess, actual, expected)

def two_neg():
    mess = "Total of two negative numbers"
    actual = total(-1,-6)
    expected = -7

    assert_equals(mess, actual, expected)

def both_pos_neg():
    mess = "Total of both positive and negative numbers"
    actual = total(-2,2)
    expected = 0

    assert_equals(mess, actual, expected)

"""
Individual unit tests end here
"""
if __name__=="__main__":
    test_total()
    test_product()
