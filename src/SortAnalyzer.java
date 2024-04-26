package src;

import java.util.ArrayList;

public class SortAnalyzer {
    private ArrayList<Integer> array = new ArrayList<>();
    private boolean debug;
    public SortAnalyzer(boolean debug) {
        this.debug = debug;
    }

    /**
     * Creates the worst-case for the insertion sort algorithm. The unsortedArray will be filled with n elements.
     * @param elementCount The number of elements which will be added to the unsortedArray.
     */
    public void insertionSort_setWorstCase(int elementCount) {
        this.array.clear();

        // The worst-case scenario for the insertion sort is that the array is sorted the wrong way round.
        for (int i = elementCount-1; i >= 0; i--) {
            this.array.add(i);
        }
    }

    /**
     * Implementation of insertion sort using the 'move' approach to minimize array accesses.
     * The function creates a copy of unsortedArray and returns the sorted copy.
     * @return The previously unsorted array, now sorted.
     */
    public ArrayList<Integer> insertionSort_MoveApproach() {
        // Iterate through every element in the array, except the last one.
        for (int i = 0; i < this.array.size()-1; i++) {
            // Get the index of the next element which will be pulled into the sorted section.
            // Temporarily save the next element in nextInt.
            int nextIndex = i + 1;
            Integer nextInt = this.array.get(nextIndex);

            // Move all elements to the right, until the right position of nextInt has been found.
            while (nextIndex > 0 && nextInt < this.array.get(nextIndex-1)) {
                this.array.set(nextIndex, this.array.get(nextIndex-1));
                nextIndex--;
            }

            // Correct position has been found. Place nextInt.
            this.array.set(nextIndex, nextInt);
            if (this.debug) System.out.println(this.array);
        }
        return this.array;
    }
}
