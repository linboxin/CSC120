"""
Models a boneyard -- a pile of dominoes.
"""

import domino as d
# 1.  create()

import random

def create():
    """
    returns a pile of dominoes containing
    one copy of every possible domino
    """
    yard = []
    for i in range(0,7):
        for j in range(0, 7):
            tile = d.create(i, j)
            yard.append(tile)
    return yard

def draw(boneyard):
    """
    removes a random domino from the boneyard
    and returns it
    """
    n = random.randint(0, len(boneyard)-1)
    return boneyard.pop(n)

def tiles_remaining(boneyard):
    """returns the number of tiles left in the yard"""
    return len(boneyard)
