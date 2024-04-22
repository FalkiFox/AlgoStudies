import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialise unsorted array
        ArrayList<Integer> unsortedArray = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            unsortedArray.add(i);
        }

        System.out.println("Unsorted Array: " + unsortedArray);
        System.out.println("Sorted array: " + insertionSort(unsortedArray));
    }

    /**
     *
     * @param array An unsorted array.
     * @return The previously unsorted array, now sorted.
     */
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int nextIndex = i + 1;
            Integer nextInt = array.get(nextIndex);
            while (nextIndex > 0 && nextInt < array.get(nextIndex-1)) {
                array.set(nextIndex, array.get(nextIndex-1));
                nextIndex--;
            }
            array.set(nextIndex, nextInt);
        }
        return array;
    }
}
