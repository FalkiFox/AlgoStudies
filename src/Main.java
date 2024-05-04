package src;

public class Main {
    public static void main(String[] args) {
        // Init analysers:
        SortAnalyzer analysis_is = new SortAnalyzer(true);
        SortAnalyzer analysis_ss = new SortAnalyzer(true);

        // Fill arrays:
        analysis_is.insertionSort_setWorstCase(10);
        analysis_ss.insertionSort_setWorstCase(10);

        // Execute sorts
        System.out.println(analysis_is.insertionSort_MoveApproach());
        System.out.println(analysis_ss.selectionSort());
    }
}
