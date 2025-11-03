# Poker Hand Comparison Game - Java Version

This is a Java implementation of a poker hand comparison game where players guess which of two poker hands is better.

## Project Structure

- **Card.java** - Represents a single playing card with rank (2-14) and suit (fully spelled out)
- **Deck.java** - Represents a deck of 52 cards with shuffle and deal functionality
- **PokerHand.java** - Represents a 5-card poker hand with evaluation and comparison logic
- **Client.java** - Main program that runs the game

## Key Features

### Card Implementation
- Uses two instance variables: `int rank` (2-14) and `String suit` (fully spelled out)
- Rank values: 2-10 are numeric, 11=Jack, 12=Queen, 13=King, 14=Ace
- Suits: "Spades", "Hearts", "Diamonds", "Clubs"

### Deck Implementation
- Uses ArrayList to store cards
- **Dealing without removing**: Cards are dealt by tracking an index (`nextCardIndex`) rather than removing cards from the ArrayList
- Custom shuffle method using `ThreadLocalRandom.current().nextInt()`
- `gather()` method resets the deck to undealt state without reshuffling

### Hand Evaluation
Hands are grouped into four categories (from best to worst):
1. **Flush** (value 3) - includes flush, straight flush, and royal flush
2. **Two Pair** (value 2) - includes two pair, full house, and four of a kind
3. **Pair** (value 1) - includes one pair and three of a kind
4. **High Card** (value 0) - includes high card and straight

## How to Compile

```bash
javac Card.java Deck.java PokerHand.java Client.java
```

## How to Run

```bash
java Client
```

## How to Play

1. The program shuffles a deck and deals two 5-card hands
2. You'll see both hands displayed on the screen
3. Enter your guess:
   - `1` if you think Hand 1 wins
   - `2` if you think Hand 2 wins
   - `0` if you think it's a tie
4. The program tells you if you're correct
5. Play continues until there aren't enough cards for another round
6. Your final score is displayed at the end

## Example Game Session

```
Round 1
--------------------------------------------------
Hand 1:
7 of Spades
Queen of Hearts
3 of Diamonds
Jack of Clubs
9 of Spades

Hand 2:
Ace of Hearts
Ace of Diamonds
5 of Clubs
2 of Spades
King of Hearts

Who wins? (1 for Hand 1, 2 for Hand 2, 0 for Tie): 2
Correct! Hand 2 wins!
Cards remaining: 42
```

## Implementation Notes

- All methods use Javadoc format for documentation
- Java naming conventions (camelCase) are used throughout
- The `compareTo` method in PokerHand returns negative, zero, or positive values based on hand comparison
- Random number generation uses `ThreadLocalRandom` as required

