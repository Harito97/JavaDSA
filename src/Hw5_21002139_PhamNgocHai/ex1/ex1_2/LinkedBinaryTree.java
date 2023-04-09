package Hw5_21002139_PhamNgocHai.ex1.ex1_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Hw5_21002139_PhamNgocHai.ex1.BinaryTreeInterface;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {
    public static class Node<E> {
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

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    // attribute
    private Node<E> root;
    private int size;

    // constructor
    public LinkedBinaryTree() {
        root = new Node<E>();
    }

    public LinkedBinaryTree(Node<E> root) {
        this.root = root;
    }

    // interface
    public E root() {
        if (root == null) {
            return null;
        }
        return root.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root.element.equals(null);
    }

    public int numChildren(E p) {
        Node<E> current = findNodeValueP(p, root);

        if (current == null)
            return 0;

        if (current.left == null && current.right != null)
            return 1;
        if (current.left != null && current.right == null)
            return 1;
        if (current.left != null && current.right != null)
            return 2;
        return 0;
    }

    public E parent(E p) {
        Node<E> current = findNodeValueP(p, root);
        if (current == null)
            return null;
        if (current.parent != null)
            return current.parent.element;
        return null;
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
        if (theParent == null) {
            // this when current is root node
            return null;
        }

        if (theParent.right != null && theParent.right != current) {
            return theParent.right.element;
        } else if (theParent.left != null && theParent.left != current)
            return theParent.left.element;
        
            return null;
    }

    // update methods
    public Node<E> setRoot(E element) {
        // Add element to root of an empty tree
        // Remember default when create a tree
        // we create a root with element null at same time
        if (root.element == null)
            ++size;
        root.element = element;
        return root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public Node<E> setLeft(Node<E> p, E element) {
        // Add element to left child node of p if empty
        // Set element to left child node of p if not empty
        if (isExistNode(p.left)) {
            p.left.element = element;
            return p.left;
        } else if (isExistNode(p)) {
            Node<E> leftNode = new Node<>();
            leftNode.element = element;
            p.left = leftNode;
            leftNode.parent = p;
            ++size;
            return leftNode;          
        }
        return null;
    }

    public Node<E> setRight(Node<E> p, E element) {
        // Add element to right child node of p if empty
        // Set element to right child node of p if not empty
        if (isExistNode(p.right)) {
            p.right.element = element;
            return p.right;
        } else if (isExistNode(p)) {
            Node<E> rightNode = new Node<>();
            rightNode.element = element;
            p.right = rightNode;
            rightNode.parent = p;
            ++size;
            return rightNode;
        }
        return null;
    }

    public void set(Node<E> p, E element) {
        // set element to node p
        if (isExistNode(p)) {
            p.element = element;
        }
        return;
    }
    
    /**
     * @return String of elements follow preOrderTraversal
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("| ");

        List<Node<E>> values = new ArrayList<>();

        // Duyệt cây theo thứ tự preOrderTraversal
        preOrderTraversal(root, values);

        for (Node<E> node : values)
            builder.append(node.element).append(" | ");

        return builder.toString();
    }
    
    private static final int COUNT = 10;
    public void visualize(Node<E> root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        visualize(root.right, space);

        // Print current node after space count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.element + "\n");

        // Process left child
        visualize(root.left, space);
    }

    // Write to file
    public void writeFile(Node<E> root, int space, FileWriter write) throws IOException {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        writeFile(root.right, space, write);

        // Print current node after space count
        write.write("\n");
        for (int i = COUNT; i < space; i++)
            write.write(" ");
        write.write(root.element + "\n");

        // Process left child
        writeFile(root.left, space, write);
    }

    /**
     * @param p the value of element of node
     * @param fromTopNode normally when use is the root node
     * @return node have value = p precedence preOrderTraversal
     */
    private Node<E> findNodeValueP(E p, Node<E> fromTopNode) {
        if (fromTopNode == null) {
            return null;
        }

        List<Node<E>> values = new ArrayList<>();

        // Duyệt cây theo thứ tự preOrderTraversal
        preOrderTraversal(fromTopNode, values);

        for (Node<E> node : values) {
            if (node.element.equals(p)) {
                return node;
            }
        }
        return null;
    }

    /**
     * @param p node p is address in tree node
     * @return true if in tree have that node, false else
     */
    private boolean isExistNode(Node<E> p) {
        if (p == null) {
            return false;
        }

        List<Node<E>> values = new ArrayList<>();

        // Duyệt cây theo thứ tự preOrderTraversal
        preOrderTraversal(root, values);

        for (Node<E> node : values) {
            if (node == p)
                return true;
        }

        return false;
    }

    private void preOrderTraversal(Node<E> node, List<Node<E>> values) {
        if (node == null) {
            return;
        }

        // Thêm giá trị của node vào danh sách
        values.add(node);

        preOrderTraversal(node.left, values);
        preOrderTraversal(node.right, values);
    }
}
