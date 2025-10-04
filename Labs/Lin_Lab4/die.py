"""
This module is a class that represents a die, that can be rolled and has a value.

Author: James Lin
Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

import random


class Die:
    """
    Represents a die with a specified number of sides.
    __sides: An int that represents the number of sides on the die.
    __value: An int that represents the current value showing on the die.
    """

    def __init__(self, sides=6):
        """
        Constructs a Die object with a specified number of sides.
        Param: sides - The number of sides on the die. Defaults to 6.
        """
        self.__value = None
        self.__sides = sides
    
    def roll(self):
        """
        Rolls the die and sets the current value to the random number from 1 to the number of sides.
        """
        self.__value = random.randint(1, self.__sides)

    def get_value(self):
        """
        Returns the current value showing on the die.
        Returns: An int that represents the current value on the die.
        """
        return self.__value 

    def get_sides(self):
        """
        Returns the number of sides on the die.
        Returns: An int that represents the number of sides on the die.
        """
        return self.__sides
    
