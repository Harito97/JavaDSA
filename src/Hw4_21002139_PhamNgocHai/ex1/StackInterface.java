package Hw4_21002139_PhamNgocHai.ex1;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();    
}
