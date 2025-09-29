"""demo of OOP techniques"""

from deck import *
from card import *

def main():
    mycard = Card("K","Hearts") # runs the constructor
    # use the class name to call __init__

    print(mycard.get_suit())
    print(mycard.get_rank())
    print(mycard) #automatically call __str__

    # s = "happy654"
    # if s.isalpha():
    #     print("s is alphabetic")
    # else:
    #     print("not alphabetic")



if __name__ == '__main__':
    main()