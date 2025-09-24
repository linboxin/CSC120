"""Tic tac toe helper functions

Author: James Lin
Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

def print_board(board):
    """
    Prints the board on the console
    :param board: a list of X and O boards
    """
    num_rows = len(board)
    num_cols = len(board[0])
    for row_num, row in enumerate(board):
        row_str = ''
        for col_num, marker in enumerate(row):
            row_str += marker
            if col_num < num_cols - 1:
                row_str += ' | '
        print(row_str)
        if row_num < num_rows - 1:
            print('---------')


def row_all_same(board, row):
    """
    Checks if the rows are all the same
    :param board: a list of X and O boards
    :param row: a list of rows in the board
    :return: a boolean value
    """
    return (board[row][0] == board[row][1] == board[row][2])


def column_all_same(column):
    """
    Checks if the column is the same
    :param column: a list of column vals
    :return: a boolean value
    """
    return (column[0] == column[1] == column[2])


def diagonal_all_same(diagonal):
    """
    Check if the diagonal is the same
    :param diagonal: a list of diagnol vals
    :return: a boolean value
    """
    return (diagonal[0] == diagonal[1] == diagonal[2])


def get_back_slash(board):
    """
    Gets the back slashes from the board
    :param board: a list of X and O boards
    :return: return the list of back slash only
    """
    return [board[i][i] for i in range(len(board))]


def get_forward_slash(board):
    """
    Gets the forward slash from the board
    :param board: a list of X and O boards
    :return: return the list of forward slash only
    """
    return [board[len(board)-i-1][i] for i in range(len(board))]


def columns(board):
    """
    Gets the columns of the board
    :param board: a list of X and O boards
    :return: a list of columns of the board
    """
    num_cols = len(board[0])
    num_rows = len(board)
    
    to_return = []
    
    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        to_return.append(col_str)
    return to_return


def check_winner(board):
    """
    Check for the winner of the board
    :param board: a list of X and O boards
    :return: the winner of the board
    """
    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            winner = board[row_num][0]
            return winner
        
    for col in columns(board):
        if column_all_same(col):
            winner = col[0]
            return winner
    
    if diagonal_all_same(get_back_slash(board)):
        winner = board[0][0]
        return winner
    
    if diagonal_all_same(get_forward_slash(board)):
        winner = board[2][0]
        return winner


def get_board_from_file(filename):
    """
    Create a list of boards from a file
    :param filename: the name of the file
    :return: a list of boards
    """
    board_list = []
    board_file = open(filename,"r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    return board_list

def main():
    inputfile = 'input.txt'
    board = get_board_from_file(inputfile)

    print_board(board)

    winner = check_winner(board)

    if winner != '':
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")

if __name__ == '__main__':
    main()



"""
Reflection: 
1. Why is the logic inside badmain's main-line code ambiguous and hard to follow?
The logic inside badmain's main-line code is hard to follow because of the helper functions not actually utilizing their parameters. Instead they are using global variables,
this is not a good way to write code, especially in the industry, when you have to work as a team on a project. The global variables will cause many confusions and hard to track.

2) How does my refactoring remove this ambiguity?
Now all my helper functions uses its parameters instead of global variables. The main function is also way easier to track and understand after removing all the messy variables. 

"""