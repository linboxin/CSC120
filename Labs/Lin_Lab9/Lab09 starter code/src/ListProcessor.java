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

    /**
     * Returns the minimum element in the list.
     * 
     * @param aList the list to search
     * @return the minimum element
     */
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
    private int getMinIndex(ArrayList<String> aList, int startingIndex)
    {
        if (startingIndex == aList.size() - 1) {
            return startingIndex;
        }
        if (aList.get(startingIndex).compareTo(aList.get(getMinIndex(aList, startingIndex + 1))) <= 0) {
            return startingIndex;
        } else {
            return getMinIndex(aList, startingIndex + 1);
        }
    }
    
    /**
     * Returns the index of the minimum element in the list.
     * 
     * @param aList the list to search
     * @return the index of the first occurrence of the minimum element
     */
    public int getMinIndex(ArrayList<String> aList)
    {
        return getMinIndex(aList, 0);
    }
    

    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    private void sort(ArrayList<String> aList, int startingIndex)
    {
        if (startingIndex >= aList.size() - 1) {
            return;
        }
        
        swap(aList, getMinIndex(aList, startingIndex), startingIndex);
        
        sort(aList, startingIndex + 1);
    }
    
    /**
     * Sorts the list in alphabetical order using selection sort.
     * 
     * @param aList the list to sort (modified in place)
     */
    public void sort(ArrayList<String> aList)
    {
        sort(aList, 0);
    }
}
    

