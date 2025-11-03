import java.util.Arrays;

/**
 * a new way to use recursion -- structural recursion
 */
public class ListProcessing {

    /**
     * determine if key is in someList
     *
     * @param someList list of integers
     * @param key integer you are searching for
     * @return true if integer found in someList, else false
     */
    public boolean findRecursively(int[] someList, int key){
//        if (it's really easy to know that key isn't in someList (empty!) {
//            return false;
//        }
//        else if (it's really easy to know that key *is* in
//                 someList cuz we find key in the first place we check) {
//            return true;
//        }
//        else {  // key is not in the first place we checked, but there's more to search through
//            Let remainingList = the sublist we haven't checked yet
//            return findRecursively(remainingList,key);
//        }
        if (someList.length == 0) { // base case
            return false;
        }
        else if (someList[0] == key) { // base case
            return true;
        }
        else {
            int[] remainingList = Arrays.copyOfRange(someList,1,someList.length);
            return findRecursively(remainingList,key);
        }
    }

    /**
     * determine if key is in someList, starting the search at startingIndex
     *
     * @param someList list of integers to search
     * @param key int to find
     * @param startingIndex index that the search starts from
     * @return true if key found in range startingIndex to the end of the list, else false
     */
    private boolean find(int[] someList, int key, int startingIndex){
//        if (it's really easy to know that key isn't
//            in the part of someList we're searching) {
//            return false;
//        }
//        else if (we find key in the first place we check) {
//            return true;
//        }
//        else {  // key is not in the first place we checked, so search what's left
//            this is the recursive call.  How do we say
//            that we want to check "the rest" of someList?
//        }

        if (startingIndex == someList.length) {  // base case
            return false;
        }
        else if (key == someList[startingIndex]) {
            return true;
        }
        else {
            return find(someList,key,startingIndex+1);
        }
    }

    /**
     * determine if key is in someList
     *
     * @param someList list of integers
     * @param key integer you are searching for
     * @return true if integer found in someList, else false
     */
    public boolean find(int[] someList, int key){
        return find(someList,key,0);
    }

    /**
     * return the number of negative integers in given array,
     * @param someList array of ints
     * @return return the amount of integers < 0
     */
//    private int howManyNegatives(int[] someList, int count, int startingIndex){
//        if (startingIndex == someList.length) {
//            return count;
//        }else if(someList[startingIndex] < 0) {
//            return howManyNegatives(someList, count +1, startingIndex + 1);
//        }else {
//            return howManyNegatives(someList, count, startingIndex + 1);
//        }
//    }
    private int howManyNegatives(int[] someList, int startingIndex){
        if (someList.length == startingIndex) {
            return 0;
        }else if (someList[startingIndex] < 0) {
            return howManyNegatives(someList,startingIndex+1) + 1;
        }else{
            return howManyNegatives(someList,startingIndex+1);
        }
    }



    public int howManyNegatives(int[] someList){
        return howManyNegatives(someList,0);
    }
}
