package src;

import java.util.ArrayList;

public class SortAnalyzer {
    private ArrayList<Integer> unsortedArray = new ArrayList<>();
    private boolean debug;
    public SortAnalyzer(boolean debug) {
        this.debug = debug;
    }

    /**
     * Creates the worst-case for the insertion sort algorithm. The unsortedArray will be filled with n elements.
     * @param elementCount The number of elements which will be added to the unsortedArray.
     */
    public void insertionSort_setWorstCase(int elementCount) {
        unsortedArray.clear();

        // The worst-case scenario for the insertion sort is that the array is sorted the wrong way round.
        for (int i = elementCount-1; i >= 0; i--) {
            this.unsortedArray.add(i);
        }
    }

    /**
     * Implementation of insertion sort using the 'move' approach to minimize array accesses.
     * The function creates a copy of unsortedArray and returns the sorted copy.
     * @return The previously unsorted array, now sorted.
     */
    public ArrayList<Integer> insertionSort_MoveApproach() {
        // Copy unsorted array into a new array which will be sorted
        ArrayList<Integer> sArray = new ArrayList<>(this.unsortedArray);

        // Iterate through every element in the array, except the last one.
        for (int i = 0; i < sArray.size()-1; i++) {
            // Get the index of the next element which will be pulled into the sorted section.
            // Temporarily save the next element in nextInt.
            int nextIndex = i + 1;
            Integer nextInt = sArray.get(nextIndex);

            // Move all elements to the right, until the right position of nextInt has been found.
            while (nextIndex > 0 && nextInt < sArray.get(nextIndex-1)) {
                sArray.set(nextIndex, sArray.get(nextIndex-1));
                nextIndex--;
            }

            // Correct position has been found. Place nextInt.
            sArray.set(nextIndex, nextInt);
            if (this.debug) System.out.println(sArray);
        }
        return sArray;
    }
}
