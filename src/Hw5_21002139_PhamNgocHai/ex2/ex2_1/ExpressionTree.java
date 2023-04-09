package Hw5_21002139_PhamNgocHai.ex2.ex2_1;

import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public ExpressionTree(Node<E> root) {
        super(root);
    }

    public void preOrderPrint(Node<E> p) {
        // pre-order traversal of tree with root p
        if (p == null)
            return;

        /* first print data of p */
        System.out.print(p.getElement() + " ");

        /* then recur on left subtree */
        preOrderPrint(p.getLeft());

        /* now recur on right subtree */
        preOrderPrint(p.getRight());
    }

    public void postOrderPrint(Node<E> p) {
        // post-order traversal of tree with root p
        if (p == null)
            return;

        // first recur on left subtree
        postOrderPrint(p.getLeft());

        // then recur on right subtree
        postOrderPrint(p.getRight());

        // now deal with the p
        System.out.print(p.getElement() + " ");
    }

    public void inOrderPrint(Node<E> p, boolean isRoot) {
        if (p == null) {
            return;
        }

        boolean isLeaf = (p.getLeft() == null && p.getRight() == null);

        if (!isRoot && !isLeaf) {
            System.out.print("(");
        }

        inOrderPrint(p.getLeft(), false);

        System.out.print(" " + p.getElement() + " ");

        inOrderPrint(p.getRight(), false);

        if (!isRoot && !isLeaf) {
            System.out.print(")");
        }
    }
}
