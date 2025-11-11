from deck import *

def main():
    d = Deck()
    d.shuffle()
    while not d.is_empty():
        card = d.deal()
        print(card)
    print("deck now has %d cards" % d.size())
    # d.gather()
    # print("after gathering, deck has %d cards" % d.size())

    print()
    d2 = Deck()
    print(d2)
    my_list = d2.get_contents()
    my_list.clear()
    print(d2)


main()