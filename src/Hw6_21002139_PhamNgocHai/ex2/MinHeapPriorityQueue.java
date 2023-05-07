package Hw6_21002139_PhamNgocHai.ex2;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue.ArrEntry;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> {

    private ArrEntry<K, E> heapPQ[];
    private int n = 0;
    private final int DEFAULT_SIZE = 1000;
    private int root = 1;

    @SuppressWarnings("unchecked")
    public MinHeapPriorityQueue() {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    public MinHeapPriorityQueue(int capacity) {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // Các phương thức bổ sung
    protected void upHeap() {
        int i = this.size();
        while (i > 1 && heapPQ[i / 2].getKey().compareTo(heapPQ[i].getKey()) > 0) {
            swap(i / 2, i);
            i /= 2;
        }
    }

    protected void downHeap() {
        int i = 1;
        int notLeaf = n / 2;
        while (i <= notLeaf) {
            if (2 * i + 1 <= n)
                if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) > 0
                        || heapPQ[i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) > 0) {
                    int j = heapPQ[2 * i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) < 0 ? 2 * i : 2 * i + 1;
                    swap(i, j);
                    i = j;
                } else
                    break;
            else if (2 * i <= n) {
                if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) > 0)
                    swap(i, 2 * i);
                i = 2 * i;
            } else
                break;
        }
    }

    public void insert(Entry<K, E> entry) {
        if (n == heapPQ.length - 1) {
            // System.out.println("Full heap!");
            return;
        }
        heapPQ[++n] = (ArrEntry<K, E>) entry;
        upHeap();
    }

    public void insert(K k, E e) {
        Entry<K, E> entry = new ArrEntry<>(k, e);
        insert(entry);
    }

    public Entry<K, E> removeMin() {
        if (n == 0) {
            // System.out.println("Empty heap!");
            return null;
        }
        Entry<K, E> min = heapPQ[root];
        heapPQ[root] = heapPQ[n--];
        downHeap();
        return min;
    }

    public Entry<K, E> min() {
        return heapPQ[root];
    }

    public ArrEntry<K, E>[] getHeapPQ() {
        return heapPQ;
    }

    public String toString() {
        String content = "";
        for (int i = 1; i <= n; i++)
            content += heapPQ[i].toString() + "\n";
        return content;
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

}
