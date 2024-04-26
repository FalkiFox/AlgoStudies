package src;

public class Main {
    public static void main(String[] args) {
        SortAnalyzer analysis = new SortAnalyzer(true);
        analysis.insertionSort_setWorstCase(5);
        System.out.println(analysis.insertionSort_MoveApproach());
    }
}
