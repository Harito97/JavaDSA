package Hw6_21002139_PhamNgocHai.ex3;

public class SelectionSort {
    // attribute
    private static Integer[] sortedArray;

    // interface
    public static void takeInputData(Integer[] array) {
        sortedArray = array;
    }

    public static void sortIncreased() {
        int n = sortedArray.length;

        // One by one move boundary of unsorted sub array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (sortedArray[j] < sortedArray[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = sortedArray[min_idx];
            sortedArray[min_idx] = sortedArray[i];
            sortedArray[i] = temp;
        }
    }
}
