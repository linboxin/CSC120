"""
Tic-Tac-Toe utilities
"""

def __remove_blank_lines(list_of_strings):
    """
    Remove empty strings from a list of strings.
    Non-destructive (does not alter original list).

    :param list_of_strings: list of tic-tac-toe rows
    :return: new list identical to list_of_strings but
    with all empty strings removed
    """
    result = list()
    for s in list_of_strings:
        if s != '':
            result.append(s)
    return result


def get_board_from_file(filename):
    """
    Reads board, returns a list of rows.

    :param filename: text file with a tic-tac-toe board such as
    X X X
    O X O
    X O O
    where each line is one row
    :return: list of strings where each string is a
    row from filename; any blank lines in the file are removed
    Example: ["X X X", "O X O", "X O O"]
    """
    board_list = []
    board_file = open(filename,"r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()

    board_list = __remove_blank_lines(board_list)
    return board_list


def __print_row(row):
    """
    Nicely prints a row of the board.

    :param row: string of Xs and Os
    """
    str = ''
    for i in range(0,len(row)):
        str += row[i]
        if i != len(row)-1:
            str += ' | '
    print(str)


def print_board(board):
    """
    prints the tic-tac-toe board

    :param board: list of rows
    """
    for i in range(0,len(board)):
        row = board[i]
        __print_row(row)
        if i != len(board) - 1:
            print('----------')


def __three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy). Example:
    (start_x, start_y) = (2,2) means we start at the lower
    right (row 2, col 2). (dx, dy) = (-1, 0) means the next
    square we check is (2+dx, 2+dy) = (1,2).  And the last
    square we check is (1+dx, 2+dy) = (0,2).  So we've just
    checked the rightmost column - (2,2), (1,2), and (0,2).
    :param board: list of rows
    :param player: string -- either "X" or "O"
    :param start_x: row to start checking at; first row is row 0
    :param start_y: col to start checking at; first col is col 0
    :param dx: 1 if checking downward, -1 if checking upward, 0 if checking this row
    :param dy: 1 if checking rightward, -1 if checking leftward, 0 if checking this col
    """
    x = start_x
    y = start_y
    for i in range(0,3):
        if board[x][y] != player:
            return False
        x += dx
        y += dy
    return True


def is_winner(board, player):
    """
    Returns True if and only if the given player has won.

    :param board: list of row strings
    :param player: string - "X" or "O"
    :return: True if player won; False if player lost or tied
    """
    if __three_in_row(board, player, 0, 0, 1, 1):
        return True
    elif __three_in_row(board, player, 2, 0, -1, 1):
        return True
    else:
        for i in range(0, 3):
            if (__three_in_row(board, player, 0, i, 1, 0)
                    or __three_in_row(board, player, i, 0, 0, 1)):
                return True
        return False


def get_winner(board):
    """
    Returns the name of the winner, or None if there is no winner

    :param board: list of row strings
    :return: "X" if X is winner, "O" if O is winner, None if tie
    """
    if is_winner(board, 'X'):
        return 'X'
    elif is_winner(board, 'O'):
        return 'O'
    else:
        return None


def __confirm_result(board, winner):
    """
    testing function

    :param board: list of strings
    :param winner: "X", "O", or None
    """
    actual = get_winner(board)
    expected = winner
    if actual==expected:
        print("PASS")
    else:
        print("***FAIL***")
        print_board(board)
        print("expected " + str(expected) + " but was " + str(actual))


def main():
    files = ["spaces.txt","X_wins.txt","O_wins.txt","tie.txt",
             "main_diagonal.txt","other_diagonal.txt"]
    answers = ["X","X","O",None,"X","O"]
    for index, filename in enumerate(files):
        board = get_board_from_file(filename)
        expected = answers[index]
        __confirm_result(board, expected)


if __name__ == "__main__":
    main()
