package Hw6_21002139_PhamNgocHai.ex2;

import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends
        SortedArrayPriorityQueue<K, E> {

    ArrEntry<K, E> heapPQ[];

    @SuppressWarnings("unchecked")
    public MinHeapPriorityQueue(int capacity) {
        heapPQ = new ArrEntry[capacity];
        // n = 0;
    }

    // Các phương thức bổ sung 
    // write lai upHeap() va downHeap()
    // protected void upHeap() {
    //     // vun lên
    //     int k = n - 1;
    //     while (k > 0) {
    //         int p = (k - 1) / 2;
    //         ArrEntry<K, E> item = heapPQ[k];
    //         ArrEntry<K, E> parent = heapPQ[p];
    //         if (item.getKey().compareTo(parent.getKey()) < 0) {
    //             // swap
    //             heapPQ[k] = parent;
    //             heapPQ[p] = item;

    //             // move up one level
    //             k = p;
    //         } else {
    //             break;
    //         }
    //     }
    // }

    // protected void downHeap() {
    //     // vun xuống
    //     int k = 0;
    //     int leftChild = 2 * k + 1;
    //     while (leftChild < n) {
    //         int min = leftChild;
    //         int rightChild = leftChild + 1;
    //         if (rightChild < n) {
    //             if (heapPQ[leftChild].getKey().compareTo(heapPQ[rightChild].getKey()) > 0) {
    //                 min = rightChild;
    //             }
    //         }
    //         if (heapPQ[k].getKey().compareTo(heapPQ[min].getKey()) > 0) {
    //             // swap
    //             ArrEntry<K, E> temp = heapPQ[k];
    //             heapPQ[k] = heapPQ[min];
    //             heapPQ[min] = temp;

    //             k = min;
    //             leftChild = 2 * k + 1;
    //         } else {
    //             break;
    //         }
    //     }
    // }
}
