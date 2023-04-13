package Hw6_21002139_PhamNgocHai.ex1.ex1_1;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.PriorityQueueInterface;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements
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
            return this.key + " " + this.element;
        }
    }

    private ArrEntry<K, E>[] array;
    private int n = 0;
    private int defaultSize = 1000;

    @SuppressWarnings("unchecked")
    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    @SuppressWarnings("unchecked")
    public UnsortedArrayPriorityQueue(int capacity) {
        if (capacity < 1) {
            throw new IndexOutOfBoundsException("Capacity have to larger than 0");
        }
        array = new ArrEntry[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        if (n >= array.length) {
            System.out.println("Full priority queue!");
            return;
        }

        array[n] = (ArrEntry<K, E>) entry;
        ++n;
    }

    public void insert(K k, E e) {
        Entry<K, E> entry = new ArrEntry<K, E>(k, e);
        insert(entry);
    }

    public Entry<K, E> removeMin() {
        ArrEntry<K, E> currentMin = array[0];
        if (n == 1) {
            array[0] = null;
            --n;
            return currentMin;
        }

        int index = 0;
        for (int i = 1; i < n; i++) {
            ArrEntry<K, E> x = array[i];
            if (x != null && (x.getKey()).compareTo(currentMin.getKey()) < 0) {
                currentMin = x;
                index = i;
            }
        }

        for (int i = index; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        array[n - 1] = null;
        --n;
        return currentMin;
    }

    public Entry<K, E> min() {
        ArrEntry<K, E> currentMin = array[0];
        for (int i = 1; i < n; i++) {
            ArrEntry<K, E> x = array[i];
            if (x == null) {
                continue;
            }

            if ((x.getKey()).compareTo(currentMin.getKey()) < 0) {
                currentMin = x;
            }
        }
        return currentMin;
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
