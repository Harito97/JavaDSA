package Hw6_21002139_PhamNgocHai.ex1.ex1_4;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.PriorityQueueInterface;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements
        PriorityQueueInterface<K, E> {

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
        NodeEntry<K, E> newEntry = (NodeEntry<K, E>) entry;
        if (n == 0) {
            // case have nothing on queue
            head = newEntry;
            tail = head;
            ++n;
            return;
        } else if (n == 1) {
            // case has only one thing on queue
            if (newEntry.getKey().compareTo(head.getKey()) >= 0) {
                // newEntry is less priority than head
                tail.next = newEntry;
                tail = newEntry;
            } else {
                // newEntry is more priority than head
                head = newEntry;
                head.next = tail;
            }
            ++n;
            return;
        } else {
            // case have more than or equal 2 things on queue
            NodeEntry<K, E> currentNode = head;
            NodeEntry<K, E> preNode = null;
            for (int i = 0; i < n; i++) {
                int condition = newEntry.getKey().compareTo(currentNode.getKey());
                if (condition >= 0) {
                    // newEntry has less priority than current
                    if (currentNode.next == null) {
                        // newEntry has worst priority
                        currentNode.next = newEntry;
                        break;
                    }
                    int newCondition = newEntry.getKey().compareTo(currentNode.next.getKey());
                    if (newCondition < 0) {
                        // newEntry has more priority than current.next
                        newEntry.next = currentNode.next;
                        currentNode.next = newEntry;
                        break;
                    }

                    // code run to here mean newEntry has less priority than currentNode and
                    // currentNode.next
                    preNode = currentNode;
                    currentNode = currentNode.next;
                    continue;
                } else if (condition < 0) {
                    // newEntry has more priority than current
                    if (preNode == null) {
                        // newEntry has most priority
                        newEntry.next = head;
                        head = newEntry;
                        break;
                    }

                    // code run to here mean newEntry has more priority than current
                    // but not be the most priority in this queue
                    preNode.next = newEntry;
                    newEntry.next = currentNode.next;
                }
            }
            ++n;
        }
    }

    @Override
    public void insert(K k, E e) {
        Entry<K, E> entry = new NodeEntry<K, E>(k, e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K, E> min = head;
        head = head.next;
        --n;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (n == 0)
            return null;
        return head;
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
}
