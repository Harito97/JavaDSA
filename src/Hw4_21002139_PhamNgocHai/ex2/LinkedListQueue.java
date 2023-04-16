package Hw4_21002139_PhamNgocHai.ex2;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;
    }

    Node queue = null;
    Node currentLastNode = new Node();

    @Override
    public void enqueue(E element) {
        // Thêm một phần tử vào queue
        if (queue == null) {
            // Trường hợp thêm đối tượng đầu tiên vào Queue
            queue = new Node();
            queue.element = element;
            return;
        }

        if (queue.next == null) {
            // Trường hợp thêm đối tượng thứ 2 vào Queue
            currentLastNode.element = element;
            queue.next = currentLastNode;
            return;
        }

        // Trường hợp thêm đối tượng thứ i (i > 2) vào Queue
        Node newNode = new Node();
        newNode.element = element;
        currentLastNode.next = newNode;
        currentLastNode = newNode;
    }

    @Override
    public E dequeue() {
        // Lấy một phần tử khỏi queue
        Node result = queue;
        if (queue == null) {
            return null;
        }
        queue = queue.next;
        return result.element;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra queue rỗng
        return queue == null;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }
    
    class QueueIterator implements Iterator<E> {
        private Node currentNode = queue;
        
        @Override
        public boolean hasNext() {
        return currentNode != null && currentNode.next != null;
        }

        @Override
        public E next() {
            if (currentNode == null) {
                return null;
            }
            E data = currentNode.element;
            currentNode = currentNode.next;
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

        Iterator<String> iterator = queue.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        Iterator<String> iterator1 = queue.iterator();
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }
}
