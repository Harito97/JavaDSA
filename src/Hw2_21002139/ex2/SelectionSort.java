package Hw2_21002139.ex2;

public class SelectionSort {
    int[] array;
    int numberOfSwap = 0;
    int numberOfComparisons = 0;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getNumberOfSwap() {
        return numberOfSwap;
    }

    public void setNumberOfSwap(int numberOfSwap) {
        this.numberOfSwap = numberOfSwap;
    }

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public void setNumberOfComparisons(int numberOfComparisons) {
        this.numberOfComparisons = numberOfComparisons;
    }

    public void printArray() {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            System.out.println("index is not acceptable");
            return;
        }
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        ++numberOfSwap;
    }

    public long sortSelectionSort() {
        long start = System.nanoTime();
        int sizeOfArray = array.length;
        int maxIndex = sizeOfArray - 1;
        
        for (int i = sizeOfArray - 1; i >= 1; i--) {
            maxIndex = i;
            // Step 1. Make inner loop to find the max item in unsorted part
            // So the idea of selection sort algorithm is select the max item in unsorted part
            for (int j = 0; j < i; j++) {
                numberOfComparisons++;
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }

            }

            // Step 2. After find the max item in the unsorted part
            // We swap to push the max item in the unsorted part to the sorted part
            // (After each outer loop, the size of sorted part bigger 1 item
            // and the size of unsorted part smaller 1 item) 
            if (i != maxIndex) {
                swap(i, maxIndex);
                //printArray();
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
