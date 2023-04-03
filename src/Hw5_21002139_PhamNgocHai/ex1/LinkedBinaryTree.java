package Hw5_21002139_PhamNgocHai.ex1;

import java.util.ArrayList;
import java.util.List;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child

        // Constructs a node with the given element and neighbors.
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            // Sinh viên hoàn thiện phương thức
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public Node() {
        }
    }

    // attribute
    private Node<E> root;
    private int size;

    // constructor
    public LinkedBinaryTree() {
        root = new Node<E>();
    }

    // interface
    public E root() {
        return root.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int numChildren(E p) {
        return -1;
    }

    public E parent(E p) {
        Node<E> current = findNodeValueP(p, root);
        if (current == null)
            return null;
        return current.parent.element;
    }

    public E left(E p) {
        Node<E> current = findNodeValueP(p, root);
        if (current == null)
            return null;
        return current.left.element;
    }

    public E right(E p) {
        Node<E> current = findNodeValueP(p, root);
        if (current == null)
            return null;
        return current.right.element;
    }

    public E sibling(E p) {
        Node<E> current = findNodeValueP(p, root);
        if (current == null)
            return null;
        Node<E> theParent = current.parent;
        if (theParent.right != current) {
            return theParent.right.element;
        }
        return theParent.left.element;
    }

    // update methods
    public Node<E> setRoot(E element) {
        // Add element to root of an empty tree
        return null;
    }

    public Node<E> setLeft(Node p, E element) {
        // Add element to left child node of p if empty
        return null;
    }

    public Node<E> setRight(Node p, E element) {
        // Add element to right child node of p if empty
        return null;
    }

    public void set(Node p, E element) {
        // set element to node p
        return;
    }

    // (find node have value = p precedence from left to right)
    private Node<E> findNodeValueP(E p, Node<E> fromTopNode) {
        List<Node<E>> values = new ArrayList<>();

        // Duyệt cây theo thứ tự trước và in ra các giá trị theo thứ tự 0 1 2 3 4 5 6
        preOrderTraversal(fromTopNode, values);

        for (int i = 0; i <= 6; i++) {
            if (values.contains(i)) {
                System.out.print(i + " ");
            }
        }
        if (fromTopNode == null) {
            return null;
        }

        if (fromTopNode.element.equals(p)) {
            return fromTopNode;
        }

        findNodeValueP(p, root.left);
        findNodeValueP(p, root.right);

        return null;
    }

    void preOrderTraversal(Node<E> node, List<Node<E>> values) {
        if (node == null) {
            return;
        }

        // Thêm giá trị của node vào danh sách
        values.add(node);

        preOrderTraversal(node.left, values);
        preOrderTraversal(node.right, values);
    }
}
