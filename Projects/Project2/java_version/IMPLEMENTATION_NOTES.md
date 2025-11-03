# Implementation Notes: Python to Java Translation

## Key Changes from Python Version

### 1. Card Class Implementation

**Python Version:**
- Used a dictionary to store rank and suit: `self.__card = {"rank": rank, "suit": suit}`
- Suit stored as single character ("H", "D", "C", "S")

**Java Version:**
- Uses two instance variables: `private int rank` and `private String suit`
- Suit is fully spelled out ("Hearts", "Diamonds", "Clubs", "Spades")
- Rank is stored as int (2-14) where 11=Jack, 12=Queen, 13=King, 14=Ace

### 2. Deck Class Implementation

**Python Version:**
- Used `random.shuffle()` for shuffling
- `deal()` method removed cards with `pop(0)`
- Deck size decreased as cards were dealt

**Java Version:**
- Custom shuffle implementation using nested loop with `ThreadLocalRandom.current().nextInt()`
- **Dealing without removing**: Uses `nextCardIndex` to track position in deck
- `deal()` returns card at `nextCardIndex` and increments the index
- `gather()` method resets `nextCardIndex` to 0 (cards stay in ArrayList)
- `isEmpty()` checks if `nextCardIndex >= cards.size()`
- `size()` returns `cards.size() - nextCardIndex`

### 3. PokerHand Class

**Python Version:**
- Used Python lists and dictionaries
- Private methods prefixed with `__` (name mangling)
- Method name: `compare_to()`

**Java Version:**
- Uses `ArrayList<Card>` and `HashMap<Integer, Integer>`
- Private methods have `private` access modifier
- Method name: `compareTo()` (camelCase)
- Added inner class `CountRankPair` to handle sorting of (count, rank) pairs
- Implements `Comparable<CountRankPair>` interface for the inner class

### 4. Client/Main Program

**Python Version:**
- File: `poker_sim.py`
- Used `input()` for user input
- Used f-strings for formatting

**Java Version:**
- File: `Client.java`
- Uses `Scanner` class for user input
- Uses string concatenation and `String.format()` for output
- Requires closing the Scanner: `scanner.close()`

### 5. Naming Conventions

**Python:**
- snake_case for methods: `get_rank()`, `add_card()`, `get_ith_card()`

**Java:**
- camelCase for methods: `getRank()`, `addCard()`, `getIthCard()`

### 6. Documentation

**Python:**
- Used Python docstrings with triple quotes
- Format: `:param`, `:return:`

**Java:**
- Uses Javadoc format with `/** */`
- Tags: `@param`, `@return`, `@author`, `@version`

## Efficiency Improvements

The new deck implementation improves efficiency in several ways:

1. **No ArrayList shifting**: Python's `pop(0)` was O(n) because it shifted all elements. Java version is O(1) for dealing.
2. **Faster gather**: Resetting index is O(1) vs recreating the deck which would be O(52).
3. **Memory efficient**: Cards stay in the same ArrayList, reducing memory allocations.

## Testing the Translation

All functionality from the Python version has been preserved:
- ✓ Card creation and string representation
- ✓ Deck creation, shuffling, and dealing
- ✓ Poker hand evaluation (flush, pairs, high card, etc.)
- ✓ Hand comparison logic
- ✓ Game loop with user interaction
- ✓ Score tracking and game over message

The game plays identically to the Python version from the user's perspective!

