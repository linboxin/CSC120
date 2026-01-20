/**
 * a classic example of recursion in action
 */
public class RecursionDemo {

    public void counter(int times) {
        if (times == 0) {  // if I've reached base case
            // stop recursing
            System.out.println("hi");
        }
        else { //not at base case yet; recurse again
            System.out.println(times);
            //times = times - 1;
            times--;
            counter(times);
        }
    }

    /**
     * computes base^exp
     * @param base integer to be multiplied
     * @param exp  power of base
     * @return  base^exp
     */
    public int power(int base, int exp) {
        if (exp == 0){ // base case: base^0 = 1
            return 1;
        }
        else { // recursive case
            return base * power(base,exp-1);
        }
    }

    /**
     * computes N! = N * (N-1) * (N-2) * 3 * 2 * 1
     * @param N any integer
     * @return N!
     */
    public int factorial(int N){
        if (N == 1) {
            return 1;
        }
        else {
            return N * factorial(N-1);
        }
    }


}
