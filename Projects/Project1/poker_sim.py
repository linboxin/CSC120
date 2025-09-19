"""
Poker Game
:author: James Lin
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty, in accordance with the Union College Honor Code and the course syllabus.
"""


import cards
import hands

def play_rounds():
    """
    Play poker simulation rounds and print out results in a table.
    """
    print("# of hands  pairs  %    2 pairs  %    flushes  %   high card  %")
    for i in range(10000, 100001, 10000):
        pair = 0
        twoPair = 0
        flush = 0
        highCard = 0
        handsDealt = 0

        while handsDealt < i:
            deck = cards.create()
            cards.shuffle(deck)

            while handsDealt < i and len(deck) >= 5:
                hand = cards.deal(deck, 5)
                category = hands.evaluate(hand)
                if category == "pair":
                    pair += 1
                elif category == "two pair":
                    twoPair += 1
                elif category == "flush":
                    flush += 1
                elif category == "high card":
                    highCard += 1

                handsDealt += 1

        total = handsDealt
        pairPercent = (pair / total) * 100
        twoPairPercent = (twoPair / total) * 100
        flushPercent = (flush / total) * 100
        highCardPercent = (highCard / total) * 100

        print(f"{total:>7,}" f"  {pair:>5}  {pairPercent:05.2f}"f"  {twoPair:>5}  {twoPairPercent:05.2f}"f"  {flush:>5}  {flushPercent:05.2f}"f"  {highCard:>5}  {highCardPercent:05.2f}")

if __name__ == "__main__":
    play_rounds()
