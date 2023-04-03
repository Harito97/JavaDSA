package Hw4_21002139.ex2;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
