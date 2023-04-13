package Hw1_21002139.ex6;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }
    public SimpleArrayList(int capacity) {
        // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (array.length == n) {
            T[] newArray = (T[]) new Object[n * 2];
            for (int i = 0; i < n; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n] = data;
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            return null;
        }
        return array[i];
    }
    
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            return;
        }
        array[i] = data;
    }

    public void remove(T data) {
        T[] newArray = (T[]) new Object[n];
        int newN = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] != data) {
                newArray[newN] = array[i];
                newN++;
            }
        }
        array = newArray;
        n = newN;
    }

    public boolean isContain(T data) {
        int index = 0;
        while (index < n) {
            if (array[index] == data) {
                System.out.println("This SimpleArrayList is contain " + data);
                return true;
            }
            index++;
        }
        System.out.println("This SimpleArrayList is NOT contain " + data);
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return array[currentIndex + 1] != null;
            }

            @Override
            public T next() {
                currentIndex++;
                return array[currentIndex];
            }
            
            @Override
            public void remove() {
                for (int i = currentIndex; i < n - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[n - 1] = null;
                n--;
            }
        };
    }

    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListInterface<Integer> listInterface = new SimpleArrayList<>(2);

        System.out.println("Test add(), size(): ");
        listInterface.add(9);
        listInterface.add(0);
        listInterface.add(80);
        listInterface.display();
        System.out.println(listInterface.size());
        // [ 9 0 80 ]
        // 3
        // => Test add(), size() successful

        System.out.println("Test set(), get(): ");
        listInterface.set(2, 81);
        listInterface.display();
        System.out.println(listInterface.get(2));
        // [ 9 0 81 ]
        // 81
        // => Test set(), get() successful
        
        System.out.println("Test isContain(): ");
        listInterface.isContain(9);
        listInterface.isContain(79);
        // => Test isContain() successful

        System.out.println("Test iterator(): ");
        listInterface.add(0);
        // [ 9 0 81 0 ]
        listInterface.display();
        listInterface.iterator().remove();
        // [ 0 81 0 ]
        listInterface.display();
        System.out.println(listInterface.size());
        System.out.println(listInterface.iterator().hasNext());
        // true
        System.out.println(listInterface.iterator().next());
        // 81
        // => Test iterator() successful

        System.out.println("Test remove(): ");
        listInterface.remove(0);        
        listInterface.display();
        System.out.println(listInterface.size());
        // [ 81 ]
        // 1
        // => Test remove() successful

        // => All APIs tested successfully
    }
}