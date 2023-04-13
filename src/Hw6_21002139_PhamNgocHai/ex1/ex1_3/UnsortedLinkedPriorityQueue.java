package Hw6_21002139_PhamNgocHai.ex1.ex1_3;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.PriorityQueueInterface;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements
        PriorityQueueInterface<K, E> {

    //@SuppressWarnings("hiding")
    public static class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        public NodeEntry<K, E> getNext() {
            return next;
        }

        public String toString() {
            return key + " " + element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n == 0) {
            head = (NodeEntry<K, E>) entry;
            tail = head;
        } else {
            tail.next = (NodeEntry<K, E>) entry;
            tail = (NodeEntry<K, E>) entry;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Entry<K, E> entry = new NodeEntry<K, E>(k, e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K, E> pre = null;
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> min = (NodeEntry<K, E>) min();
        for (int i = 0; i < n; i++) {
            if (current == min) {
                if (pre != null) {
                    pre.next = min.next;
                    break;
                } else {
                    // case head = min
                    head = head.next;
                    break;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (n == 0)
            return null;

        if (n == 1) {
            Entry<K, E> result = head;
            return result;
        }

        // find min
        NodeEntry<K, E> currentMin = head;
        NodeEntry<K, E> currentNode = head.next;
        for (int i = 1; i < n; i++) {
            if (currentNode == null || currentNode.next == null) {
                continue;
            }
            if (currentMin.getKey().compareTo(currentNode.getKey()) > 0) {
                currentMin = currentNode;
            }
            currentNode = currentNode.next;
        }
        return currentMin;
    }

    public String toString() {
        String result = "";
        NodeEntry<K, E> currentNode = head;
        for (int i = 0; i < n; i++) {
            if (currentNode == null) {
                return result;
            }
            result += currentNode.toString() + "\n";
            currentNode = currentNode.next;
        }
        return result;
    }
}
