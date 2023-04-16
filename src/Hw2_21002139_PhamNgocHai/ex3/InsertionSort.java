package Hw2_21002139_PhamNgocHai.ex3;

public class InsertionSort {
    int[] array;
    int numberOfSwap = 0;
    int numberOfComparisons = 0;

    public InsertionSort(int[] array) {
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

    public long sortInsertionSort() {
        long start = System.nanoTime();

        int sizeOfArray = array.length;
        int next;
        int j;

        for (int i = 1; i < sizeOfArray; i++) {
            next = array[i];

            for (j = i - 1; j >= 0; j--) {
                numberOfComparisons++;

                if (array[j] > next) {
                    array[j + 1] = array[j];
                    numberOfSwap++;
                } else {
                    break;
                }
            }

            array[j + 1] = next;
            //printArray();
        }

        long end = System.nanoTime();
        return end - start;
    }
}
