package Hw2_21002139.ex1;

import java.util.Random;

public class TestBubbleSort {
    private static int[] generateRandomArray() {
        Random random = new Random();
        int n = random.nextInt(0, 10);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(-1000, 1000);

        }
        return array;
    }
    
    public static void main(String[] args) {
        //int[] array = new int[] {1, 5, 3, 7, 2};
        //int[] array = new int[] {4, 3, 2, 6, 2, 4, 6, 9, 10, 43};
        //int[] array = new int[] {-5, -8, 9, 10, 11, 4, 3, 2, 8};
        //int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array = generateRandomArray();

        BubbleSort bubbleSort = new BubbleSort(array);

        System.out.println("State of array before sort: ");
        bubbleSort.printArray();

        System.out.println("\nStart sort: ");
        bubbleSort.sortBubbleSort();

        System.out.println("\nNumber of comparisons: " + bubbleSort.numberOfComparisons);
        System.out.println("Number of swaps: " + bubbleSort.numberOfSwap);
    }
}
