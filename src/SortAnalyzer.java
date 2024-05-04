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
     * Creates the best-case for the insertion sort algorithm. The unsortedArray will be filled with n elements.
     * @param elementCount The number of elements which will be added to the unsortedArray.
     */
    public void insertionSort_setBestCase(int elementCount) {
        this.array.clear();

        // The best-case scenario for the insertion sort is that the array is already sorted.
        for (int i = 0; i < elementCount; i++) {
            this.array.add(i);
        }
    }

    /**
     * Implementation of insertion sort using the 'move' approach to minimize array accesses.
     * @return The previously unsorted array, now sorted.
     */
    public ArrayList<Integer> insertionSort_MoveApproach() {
        // Iterate through every element in the array, except the last one.
        for (int i = 0; i < this.array.size()-1; i++) {
            if (this.debug) System.out.println(STR."Outer loop: \{this.array}");  // Used for debugging

            // Get the index of the next element which will be pulled into the sorted section.
            // Temporarily save the next element in nextInt.
            int nextIndex = i + 1;
            Integer nextInt = this.array.get(nextIndex);

            // Move all elements to the right, until the right position of nextInt has been found.
            while (nextIndex > 0 && nextInt < this.array.get(nextIndex-1)) {
                this.array.set(nextIndex, this.array.get(nextIndex-1));
                if (this.debug) System.out.println(STR."    Inner loop: \{this.array}");  // Used for debugging
                nextIndex--;
            }

            this.array.set(nextIndex, nextInt);  // Correct position has been found. Place nextInt.
        }
        return this.array;
    }

    /**
     * Implementation of insertion sort using the 'swap' approach. This is less optimal than the 'move' approach.
     * In comparison to the 'move' approach, this approach requires one more array access per inner loop iteration.
     * @return The previously unsorted array, now sorted.
     */
    public ArrayList<Integer> insertionSort_SwapApproach() {
        // Iterate through every element in the array, except the last one.
        for (int i = 0; i < this.array.size()-1; i++) {
            if (this.debug) System.out.println(STR."Outer loop: \{this.array}");  // Used for debugging

            // Get the index of the next element which will be pulled into the sorted section.
            int nextIndex = i + 1;

            // As long as the element at index nextIndex is larger than the element 'left' to nextIndex, swap
            while (nextIndex > 0 && this.array.get(nextIndex) < this.array.get(nextIndex-1)) {
                // Swap elements at nextIndex and nextIndex - 1
                Integer tempElement = this.array.get(nextIndex);
                this.array.set(nextIndex, this.array.get(nextIndex-1));
                this.array.set(nextIndex-1, tempElement);

                nextIndex--;  // Decrease nextIndex to continue swapping to the left.
                if (this.debug) System.out.println(STR."    Inner loop: \{this.array}");  // Used for debugging
            }
        }
        return this.array;
    }

    /**
     * Implementation of selection sort.
     * @return The previously unsorted array, now sorted.
     */
    public ArrayList<Integer> selectionSort() {
        // Iterate through every element in the array, except the last one.
        for (int i = 0; i < array.size() - 1; i++) {
            if (this.debug) System.out.println(STR."Outer loop: \{this.array}");

            // Set the smallest index to the current index.
            int smallestIndex = i;
            for (int j = i + 1; j < array.size(); j++) {  // Iterate through the unsorted part of the array.
                if (array.get(j) < array.get(smallestIndex)) smallestIndex = j;  // Compare all elements with each other and determine the smallest.
            }
            // Swap the smallest element in the unsorted part of the array with the element which gets included in the sorted part of the array.
            Integer tempIndex = array.get(smallestIndex);
            array.set(smallestIndex, array.get(i));
            array.set(i, tempIndex);
        }
        return array;
    }
}
