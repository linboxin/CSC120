import java.util.ArrayList;

public class ListProcessor
{
    /**
     * Swaps elements at indices i and j in the given list.
     */
    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list and returns it.
     * Non-destructive (That means this method should not change aList.)
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
//    public String getMin(ArrayList<String> aList)
//    {
//        String minElement = aList.get(0);
//        for (int i = 1; i < aList.size(); i++) {
//            if (aList.get(i).compareTo(minElement) < 0) {
//                minElement = aList.get(i);
//            }
//        }
//        return minElement;
//    }

    private String getMin(ArrayList<String> aList, int startingIndex)
    {
        if (startingIndex == aList.size()-1) {
            return aList.get(startingIndex);
        }else if (aList.get(startingIndex).compareTo(getMin(aList, startingIndex+1)) < 0) {
            return aList.get(startingIndex);
        }else {
            return getMin(aList, startingIndex + 1);
        }

    }

    public String getMin(ArrayList<String> aList){
        return getMin(aList, 0);
    }


    /**
     * Finds the minimum element of a list and returns the index of that
     * element. If there is more than one instance of the minimum, then
     * the lowest index will be returned.  Non-destructive.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList)
    {
        int minIndex = 0;
        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i).compareTo(aList.get(minIndex)) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

//    private int getMinIndex(ArrayList<String> aList, int startingIndex){
//       if (startingIndex == aList.size() -1) {
//           return 0;
//       } else if (aList.get(startingIndex).compareTo(aList.get()) < 0) {
//          return getMinIndex(aList, startingIndex + 1);
//       }
//   }
//
//
//
//    public int getMinIndex(ArrayList<String> aList){
//        return getMinIndex(aList, 0);
//    }

    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    public void sort(ArrayList<String> aList)
    {
        if (aList.size() == 0) {
            return;
        }
        else {
            int minIndex = getMinIndex(aList);
            swap(aList, minIndex, 0);
            sort(new ArrayList<String>(aList.subList(1, aList.size())));
        }


    }
}
    

