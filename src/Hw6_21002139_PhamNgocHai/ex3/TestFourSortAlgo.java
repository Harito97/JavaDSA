package Hw6_21002139_PhamNgocHai.ex3;

// import java.util.Arrays;
import java.util.Random;

public class TestFourSortAlgo {
    public static void main(String[] args) {
        // create data to test
        final String[] algorithm = { "heap", "merge", "quick", "selection" };
        Integer[] unsortedArray = generateRandomIntegers();
        int n = unsortedArray.length;

        // update data to class to prepare sort then sort
        // must do 2 stage difference (update data to class & sort)
        // to make sure thus take time to sort
        // (not take time to update data to class more)
        for (int encode = 0; encode < 4; encode++) {
            // prepare data
            Integer[] unsortedArray_temp = new Integer[n];
            System.arraycopy(unsortedArray, 0, unsortedArray_temp, 0, n);
            // print data input if you wanna see data will be updated to class sort
            // System.out.println(Arrays.toString(unsortedArray_temp));

            // update data to class
            updateDataToClass(encode, unsortedArray_temp);

            // start sort
            System.out.println("Running " + algorithm[encode] + " sort algorithm ...");
            System.out.println("Time took: " + timeRunSortAlgo(encode) + "ns");

            // print result if you wanna see data after sort
            // System.out.println(Arrays.toString(unsortedArray_temp) + "\n");
        }
    }

    private static void updateDataToClass(int encode, Integer[] array) {
        if (encode < 0 || encode > 3) {
            return;
        }

        switch (encode) {
            case 0:
                HeapSort.takeInputData(array);
                break;
            case 1:
                MergeSort.takeInputData(array);
                break;
            case 2:
                QuickSort.takeInputData(array);
                break;
            case 3:
                SelectionSort.takeInputData(array);
                break;
        }
    }

    private static long timeRunSortAlgo(int encode) {
        if (encode < 0 || encode > 3) {
            return -1;
        }

        long start = System.nanoTime();

        switch (encode) {
            case 0:
                testHeapSort();
                break;
            case 1:
                testMergeSort();
                break;
            case 2:
                testQuickSort();
                break;
            case 3:
                testSelectionSort();
                break;
        }

        return System.nanoTime() - start;
    }

    private static void testHeapSort() {
        HeapSort.sortIncreased();
    }

    private static void testMergeSort() {
        MergeSort.sortIncreased();
    }

    private static void testQuickSort() {
        QuickSort.sortIncreased();
    }

    private static void testSelectionSort() {
        SelectionSort.sortIncreased();
    }

    private static Integer[] generateRandomIntegers() {
        Random random = new Random();
        int n = 1 + random.nextInt(1000); // Integer.MAX_VALUE);
        // tạo ra n từ 1 đến bound (input bound quá lớn có thể làm tràn heap mem)
        // - chú ý với những jdk lạc hậu
        // có thể không chạy được lệnh random trên
        Integer[] result = new Integer[n];
        while (--n >= 0) {
            result[n] = random.nextInt();
        }
        return result;
    }
}
