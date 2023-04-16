package Hw2_21002139_PhamNgocHai.ex5;

import java.time.Duration;
import java.time.Instant;

public class Sort<T extends Comparable<T>> {
    T[] array;

    public Sort(T[] inputArray) {
        this.array = inputArray;
    }

    public void sort() {
    }

    void printArray() {
        if (array == null) {
            return;
        }
        System.out.print("\n[ ");
        for (T x : array) {
            System.out.print(x + " ");
        }
        System.out.print("]");
    }

    Duration returnTimeRan() {
        Instant start = Instant.now();
        sort();
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    /*
     * Identify time ran by program in second
     */
    void printTimeRan() {
        Instant start = Instant.now();
        sort();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    protected void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            System.out.println("index is not acceptable");
            return;
        }
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    protected int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}