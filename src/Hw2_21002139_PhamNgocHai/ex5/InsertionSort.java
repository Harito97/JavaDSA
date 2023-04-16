package Hw2_21002139_PhamNgocHai.ex5;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    public InsertionSort(T[] inputArray) {
        super(inputArray);
    }

    @Override
    public void sort() {
        int sizeOfArray = array.length;
        T next;
        int j;

        for (int i = 1; i < sizeOfArray; i++) {
            next = array[i];

            for (j = i - 1; j >= 0 && compare(array[j], next) > 0; j--) {
                array[j + 1] = array[j];
            }

            array[j + 1] = next;
        }
    }
}