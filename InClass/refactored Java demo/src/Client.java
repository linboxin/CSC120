public class Client {

    public static void main(String[] args) { //psvm for short
        int age;
        age = 10;
        float weight;
        String name = "Chris";
        System.out.println(name);  //sout for short
        System.out.println("My age is " + age);
        Card myCard;  // declare a Card type variable
        myCard = new Card(6,"Hearts"); //constructor call
        Card myCard2 = new Card(7,"Spades");
        Card myCard3 = new Card();
        Card myCard4 = new Card("Hearts");
        System.out.println(myCard.getRank());
        System.out.println(myCard3.getSuit());
        System.out.println(myCard);
    }



}
