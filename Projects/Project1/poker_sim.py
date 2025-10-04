# I affirm that I have carried out the attached academic endeavors with full academic honesty, in accordance with the Union College Honor Code and the course syllabus.


import cards
import hands

def play_rounds():
    """
    Play poker simulation rounds and print out results in a table.
    """
    print("# of hands  pairs  %    2 pairs  %    flushes  %   high card  %")
    for i in range(10000, 100001, 10000):
        pair = 0
        two_pair = 0
        flush = 0
        high_card = 0
        hands_dealt = 0

        while hands_dealt < i:
            deck = cards.create()
            cards.shuffle(deck)

            while hands_dealt < i and len(deck) >= 5:
                hand = cards.deal(deck, 5)
                category = hands.evaluate(hand)
                if category == "pair":
                    pair += 1
                elif category == "two pair":
                    two_pair += 1
                elif category == "flush":
                    flush += 1
                elif category == "high card":
                    high_card += 1

                hands_dealt += 1

        total = hands_dealt
        pair_percent = (pair / total) * 100
        two_pair_percent = (two_pair / total) * 100
        flush_percent = (flush / total) * 100
        high_card_percent = (high_card / total) * 100

        print(f"{total:>7,}  {pair:>5}  {pair_percent:05.2f}  {two_pair:>5}  {two_pair_percent:05.2f}  {flush:>5}  {flush_percent:05.2f}  {high_card:>5}  {high_card_percent:05.2f}")

if __name__ == "__main__":
    play_rounds()
