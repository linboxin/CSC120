
public class Stringdemo {

	public static void main(String[] args) {
		String x;
        String y;
        x = new String("hello");
        y = new String("hello");
//        if (x==y) {
        if (x.equals(y)) {
            System.out.println("they're equal");
        }
        else {
            System.out.println("they're different");
        }
	}
}
