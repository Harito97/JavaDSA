package Hw4_21002139.ex1;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY=1000; // default array capacity
    private E[] data; // generic array used for storage
    private int t = -1; // index of the top element in stack
    
    public ArrayStack() {
        this(CAPACITY);
    }
    
    // constructs stack with default capacity
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        // constructs stack with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    public int size() { 
        return (t + 1); 
    }

    @Override
    public boolean isEmpty() { 
        return t == -1; 
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[++t] = e; // increment t before storing new item
        // remember that ++t is difference t++
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }    

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size() && data[currentIndex + 1] != null;
            }

            @Override
            public E next() {
                return data[currentIndex++];
            }
        };
    }

    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>(); // contents: ()
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        System.out.println(S.size()); // contents: (5, 3) outputs 2
        System.out.println(S.pop()); // contents: (5) outputs 3
        System.out.println(S.isEmpty()); // contents: (5) outputs false
        System.out.println(S.pop()); // contents: () outputs 5
        System.out.println(S.isEmpty()); // contents: () outputs true
        System.out.println(S.pop()); // contents: () outputs null
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        System.out.println(S.top()); // contents: (7, 9) outputs 9
        S.push(4); // contents: (7, 9, 4)
        System.out.println(S.size()); // contents: (7, 9, 4) outputs 3
        System.out.println(S.pop()); // contents: (7, 9) outputs 4
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        System.out.println(S.pop()); // contents: (7, 9, 6) outputs 8
    }
}
