import old_card as c
import old_deck as d

def main():
    card = c.create("K", "Hearts")
    print(c.get_rank(card))
    print(c.get_suit(card))
    print(c.as_str(card))

    deck = d.create()
    some_card = d.deal(deck)
    print(c.as_str(some_card))


if __name__ == '__main__':
    main()