package Hw5_21002139_PhamNgocHai.ex1;

public interface BinaryTreeInterface<E> {
    E root(); // value of the root (null if there is no root)

    int size(); // number of point in tree

    boolean isEmpty();

    int numChildren(E p);
    // number of children of point has element p
    // (search node have value = p precedence PreOrderTraversal to make sure that
    // can get same value when using both Array or LinkedList)

    E parent(E p);
    // return value's parent of point has element p
    // (search node have value = p precedence PreOrderTraversal to make sure that
    // can get same value when using both Array or LinkedList)

    E left(E p);
    // return value's left child of point has element p
    // (search node have value = p precedence PreOrderTraversal to make sure that
    // can get same value when using both Array or LinkedList)

    E right(E p);
    // return value's right child of point has element p
    // (search node have value = p precedence PreOrderTraversal to make sure that
    // can get same value when using both Array or LinkedList)

    E sibling(E p);
    // return value's sibling of point has element p
    // (search node have value = p precedence PreOrderTraversal to make sure that
    // can get same value when using both Array or LinkedList)
}