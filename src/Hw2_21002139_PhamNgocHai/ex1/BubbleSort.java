package Hw2_21002139_PhamNgocHai.ex1;

public class BubbleSort {
    int[] array;
    int numberOfSwap = 0;
    int numberOfComparisons = 0;

    public BubbleSort(int[] array) {
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
        numberOfSwap++;
    }

    public long sortBubbleSort() {
        long start = System.nanoTime();
        
        int sizeOfArray = array.length;
        boolean isSorted = true;

        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 1; j < sizeOfArray - i; j++) {
                numberOfComparisons++;
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                    //printArray();
                    isSorted = false;
                }
                // after 1 time of inner loop, the item in index i (if bigger) will be swap with the item in index j
            }
            if (isSorted) {
                // isSorted help this SortAlgorithm run in the best case is O(n)
                break;
            }
            // after 1 time of outer loop, the biggest item will be push to the last of array
        }

        long end = System.nanoTime();
        return end - start;
    }
}
