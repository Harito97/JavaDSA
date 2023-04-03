package Hw4_21002139.ex1;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    Node stack = null;

    @Override
    public void push(E element) {
        // Thêm một phần tử vào stack
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        Node result = stack;
        if (stack == null) {
            return null;
        }
        stack = stack.next;
        return result.element;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return stack == null;
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        return stack.element;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    
    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> S = new LinkedListStack<>(); // contents: ()
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        System.out.println(S.pop()); // contents: (5) outputs 3
        System.out.println(S.isEmpty()); // contents: (5) outputs false
        System.out.println(S.pop()); // contents: () outputs 5
        System.out.println(S.isEmpty()); // contents: () outputs true
        System.out.println(S.pop()); // contents: () outputs null
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        System.out.println(S.top()); // contents: (7, 9) outputs 9
        S.push(4); // contents: (7, 9, 4)
        System.out.println(S.pop()); // contents: (7, 9) outputs 4
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        System.out.println(S.pop()); // contents: (7, 9, 6) outputs 8
        System.out.println(S.pop()); // contents: (7, 9) outputs 6
        System.out.println(S.pop()); // contents: (7) outputs 9
        System.out.println(S.pop()); // contents: () outputs 7
        System.out.println(S.pop()); // contents: () outputs null
        System.out.println(S.pop()); // contents: () outputs null
    }
}
