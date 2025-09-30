"""

Author: James Lin
"""

import random


class Die:
    def __init__(self, sides=6):
        self.__value = None
        self.__sides = sides
    
    def roll(self):
        self.__value = random.randint(1, self.__sides)

    def get_value(self):
        return self.__value 

    def get_sides(self):
        return self.__sides
    
