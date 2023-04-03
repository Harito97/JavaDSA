package Hw2_21002139.ex5;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    public SelectionSort(T[] inputArray) {
        super(inputArray);
    }
    
    @Override
    public void sort() {
        int sizeOfArray = array.length;
        int maxIndex = sizeOfArray - 1;
        // CompareElement compareElementJ;
        // CompareElement compareElementMaxIndex;
        
        for (int i = sizeOfArray - 1; i >= 1; i--) {
            maxIndex = i;
            // Step 1. Make inner loop to find the max item in unsorted part
            // So the idea of selection sort algorithm is select the max item in unsorted part
            for (int j = 0; j < i; j++) {
                // compareElementJ = new CompareElement(new Comparable<T>(array[j]));
                // compareElementMaxIndex = new CompareElement(array[maxIndex]);
                if (compare(array[j], array[maxIndex]) >= 0) {
                    maxIndex = j;
                }
            }

            // Step 2. After find the max item in the unsorted part
            // We swap to push the max item in the unsorted part to the sorted part
            // (After each outer loop, the size of sorted part bigger 1 item
            // and the size of unsorted part smaller 1 item) 
            if (i != maxIndex) {
                swap(i, maxIndex);
            }
        }
    }
}