package Hw6_21002139_PhamNgocHai.ex1.ex1_2;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.PriorityQueueInterface;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements
        PriorityQueueInterface<K, E> {

    public static class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }

        public String toString() {
            return "[" + this.key + " " + this.element + "]";
        }
    }

    private ArrEntry<K, E>[] array;
    private int n = 0;
    private final int defaultSize = 1000;

    @SuppressWarnings("unchecked")
    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    @SuppressWarnings("unchecked")
    public SortedArrayPriorityQueue(int capacity) {
        if (capacity < 1) {
            throw new IndexOutOfBoundsException("Capacity have to larger than 0");
        }
        array = new ArrEntry[capacity];
    }

    public ArrEntry<K, E>[] getArray() {
        return array;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        if (n == array.length) {
            System.out.println("Full priority queue!");
            return;
        }

        array[n] = (ArrEntry<K, E>) entry;

        // them 1 cai sap xep o day
        for (int i = n; i > 0; i--) {
            if (array[i].getKey().compareTo(array[i - 1].getKey()) >= 0) {
                // swap
                ArrEntry<K, E> temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            } else {
                break;
            }
        }
        ++n;
    }

    public void insert(K k, E e) {
        if (n > array.length) {
            System.out.println("Full priority queue!");
            return;
        }

        Entry<K, E> entry = new ArrEntry<K, E>(k, e);
        insert(entry);
        //System.out.println(this.toString());
    }

    public Entry<K, E> removeMin() {
        if (n == 0)
            return null;
        ArrEntry<K, E> currentMin = array[n - 1];
        array[n - 1] = null;
        n--;
        return currentMin;
    }

    public Entry<K, E> min() {
        if (n == 0)
            return null;
        return array[n - 1];
    }

    public String toString() {
        String result = "";
        for (ArrEntry<K, E> x : array) {
            if (x == null)
                continue;
            result += x.toString() + "\n";
        }
        return result;
    }
}
