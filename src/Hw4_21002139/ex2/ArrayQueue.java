package Hw4_21002139.ex2;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private static int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 5;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return queue[top];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(E element) {
        if (count == n) {
            n *= 2;
            //queue = Arrays.copyOf(queue, n);
            E[] newQueue = (E[]) new Object[n];
            int number = queue.length - top;
            System.arraycopy(queue, top, newQueue, 0, number);
            System.arraycopy(queue, 0, newQueue, number, top);
            queue = newQueue;
            top = 0;
            enqueue(element);
        }
        if (count < queue.length) {
            int index = (top + count) % queue.length;
            queue[index] = element;
            count++;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E result = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count - 1;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

    public static void main(String[] args) {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        QueueInterface<String> queue = new ArrayQueue<>();
        queue.enqueue(a1[0]);
        queue.enqueue(a1[1]);
        queue.enqueue(a1[2]);
        queue.enqueue(a1[3]);
        queue.enqueue(a1[4]);
        queue.enqueue(a1[5]);

        System.out.println(queue.isEmpty());
        for (String x : queue) {
            System.out.print(x.toString() + " \n");
        }

        // queue.dequeue();
        // queue.dequeue();
        // queue.dequeue();
        // queue.dequeue();

        // Iterator<String> iterator1 = queue.iterator();
        // System.out.println(iterator1.hasNext());
        // System.out.println(iterator1.next());
        // System.out.println(iterator1.next());

        // queue.dequeue();
        // System.out.println(queue.isEmpty());
        System.out.println(n); // print 10 -> so x2 times n = array length work true in add()
    }
}