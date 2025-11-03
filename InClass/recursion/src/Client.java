public class Client {

    public static void main(String[] args){
//        numericRecursion();
//        structuralRecursion();
        test();
    }

    /**
     * numerical recursion demo
     */
    public static void numericRecursion() {
        RecursionDemo f = new RecursionDemo();
//        f.counter(5);
//        System.out.println(f.power(2,3));
        System.out.println(f.factorial(5));
    }

    /**
     * structural recursion demo
     */
    public static void structuralRecursion() {
        ListProcessing processor = new ListProcessing();
        int[] list = new int[] {1,2,3};
        System.out.println(processor.findRecursively(list,23));
    }

    public static void test() {
        ListProcessing processor = new ListProcessing();
        int[] list = new int[] {1,2,-3, -1,29, -4, -6, -1, -56};
        System.out.println(processor.howManyNegatives(list));
    }


}

