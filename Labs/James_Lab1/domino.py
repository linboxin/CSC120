# 1. create()
# 2. as_str()
# 3. get_right()
# 4. get_left()


def create(left, right):
    """
     creates a domino and returns in tuple.
    """
    return (left, right)

def as_str(domino):
    """
     returns the domino values as a string
    """
    return "[%d | %d]" % (get_left(domino), get_right(domino))

def get_left(domino):
    """
     returns the left value of the domino
    """
    return domino[0]

def get_right(domino):
    """
     returns the right value of the domino
    """
    return domino[1]


# James Lin
# I affirm that I have carried out the attached academic endeavors with full academic honesty,
# in accordance with the Union College Honor Code and the course syllabus.
