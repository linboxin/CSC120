"""
:author: James Lin 
"""

from tictactoe_board import *
from testing import *


def test_get_winner():
    start_tests("Tests for tictactoe_board.get_winner()")

    test_get_winner_horiz_X()
    test_get_winner_horiz_mid()
    test_get_winner_horiz_O()
    test_get_winner_vertical_O()
    test_get_winner_incomplete_board()
    test_get_winner_empty()
    test_get_winner_diagnol_O()
    test_get_winner_diagnol_X()

    finish_tests()

"""
Individual unit tests start here
"""

def test_get_winner_horiz_X():
    a_board = Tictactoe_board(['XXX',
                               'OOX',
                               'XOO'])
    assert_equals(str(a_board) + "Three Xs in a row horizontally",
                  'X',
                  a_board.get_winner())

def test_get_winner_horiz_O():
    a_board = Tictactoe_board(['XOX',
                               'XXO',
                               'OOO'])
    assert_equals(str(a_board) + "Three Os in a row horizontally",
                  'O',
                  a_board.get_winner())

def test_get_winner_horiz_mid():
    a_board = Tictactoe_board(['XOX',
                               'OOO',
                               'XOX'])
    assert_equals(str(a_board) + "Three Os in a row horizontally",
                  'O',
                  a_board.get_winner())

def test_get_winner_vertical_O():
    a_board = Tictactoe_board(['OOX',
                               'OXO',
                               'OXX'])
    assert_equals(str(a_board) + "Three Os in a row vertically",'O', a_board.get_winner())


def test_get_winner_incomplete_board():
    a_board = Tictactoe_board(['XXX',
                               'OOX',
                               'XOO'])
    a_board.clear_cell(0, 0)
    assert_equals(str(a_board) + "Incomplete board, no winner yet",
                  None,
                  a_board.get_winner())


def test_get_winner_empty():
    a_board = Tictactoe_board(None)
    assert_equals(str(a_board) + "Empty board, no winner yet",
                  None,
                  a_board.get_winner())

def test_get_winner_diagnol_X():
    a_board = Tictactoe_board(['XOX',
                               'OXX',
                               'XOO'])
    assert_equals(str(a_board) + "Diagnol, X wins ", 'X', a_board.get_winner())

def test_get_winner_diagnol_O():
    a_board = Tictactoe_board(['XOO',
                               'XOX',
                               'OXX'])
    assert_equals(str(a_board) + "Diagnol, O wins ", 'O', a_board.get_winner())

if __name__ == "__main__":
    test_get_winner()
