import java.util.Random;

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
     * Constructs a new Die object with the default sides value.
     */
    public Die() {
        this.value = 0;
        this.sides = DEFUALT_SIDES;
    }


    /**
     * Assigns this value to a random number ranging from 1 to 6
     */
    public void roll(){
        Random r = new Random();
        this.value = r.nextInt(DEFUALT_SIDES - DEFUALT_VALUE + 1) + DEFUALT_VALUE;
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
