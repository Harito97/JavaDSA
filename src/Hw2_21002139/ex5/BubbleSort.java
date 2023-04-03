package Hw2_21002139.ex5;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    public BubbleSort(T[] inputArray) {
        super(inputArray);
    }

    @Override
    public void sort() {
        int sizeOfArray = array.length;
        boolean isSorted = true;

        for (int i = 0; i < sizeOfArray - 1; i++) {
            for (int j = i + 1; j < sizeOfArray; j++) {
                if (compare(array[i], array[j]) > 0) {
                    swap(i, j);
                    isSorted = false;
                }
                // after 1 time of inner loop, the item in index i (if bigger) will be swap with the item in index j
            }
            if (isSorted) {
                // isSorted help this SortAlgorithm run in the best case is O(n)
                return;
            }
            // after 1 time of outer loop, the biggest item will be push to the last of array
        }
    }
}
