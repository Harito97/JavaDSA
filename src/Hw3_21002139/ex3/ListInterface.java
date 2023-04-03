package Hw3_21002139.ex3;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int I, T data);
    public void remove(T data);
    public void display();
    public boolean isContain(T data);
    public boolean isEmpty();
    public int size();
    public int indexOf(T data);
}