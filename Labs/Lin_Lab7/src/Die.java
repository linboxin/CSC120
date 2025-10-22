import java.util.Random;

/**
 * A die with a fixed number of sides and a current face value. The die is mutable.
 */
public class Die {
    private final int DEFUALT_SIDES = 6;
    private final int DEFUALT_VALUE = 1;


    private int value;
    private int sides;

    /**
     * Constructs a new Die object.
     * @param sides The int representation of sides in a Die.
     */
    public Die(int sides){

        this.value = DEFUALT_VALUE;
        this.sides = sides;
    }

    /**
     * Constructs a new die with the default number of sides (6).
     */
    public Die() {
        this.value = DEFUALT_VALUE;
        this.sides = DEFUALT_SIDES;
    }

    /**
     * Rolls this die, updating its value to a random integer in [1, sides].
     */
    public void roll(){
        Random r = new Random();
        this.value = r.nextInt(this.sides) + 1;
    }

    /**
     * Returns the value of the current Die
     * @return this.value The current value of the dice
     */
    public int getValue(){
        return this.value;
    }



//
//    /**
//     * @return this.sides The current side of the dice
//     */
//    public int getSides() {
//        return this.sides;
//    }
}
