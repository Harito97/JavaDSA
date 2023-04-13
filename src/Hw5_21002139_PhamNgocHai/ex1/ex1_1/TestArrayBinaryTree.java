package Hw5_21002139_PhamNgocHai.ex1.ex1_1;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        // test setRoot(), setLeft(), setRight() in normal case
        tree.setRoot(90);
        tree.setLeft(0, 80);
        tree.setRight(0, 34);
        tree.setLeft(1, 23);
        tree.setLeft(2, 89);
        tree.setRight(2, 56);
        System.out.println(tree.toString());
        // print
        // | 90 | 80 | 34 | 23 | null | 89 | 56 | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null
        // | null | null | null | null | null | null | null | null | null | null | null |
        

        // tree now is
        // -----90
        // ----/-\
        // ---80 34
        // --/--/-\
        // -23 89 56

        // test root(), left(), right(), sibling(), parent() in normal case
        System.out.println(tree.root()); // print 90
        System.out.println(tree.left(90)); // print 80
        System.out.println(tree.right(90)); // print 34
        System.out.println(tree.sibling(34)); // print 80
        System.out.println(tree.sibling(80)); // print 34
        System.out.println(tree.sibling(89)); // print 56
        System.out.println(tree.parent(34)); // print 90
        System.out.println(tree.parent(23) + "\n"); // print 80

        // test changeMaxNumberPointOfTree()
        tree.changeMaxNumberPointOfTree(0); // print Coefficient can't acceptable!
        // coefficient = x0.0 is not acceptable
        tree.changeMaxNumberPointOfTree(0.05); // print Coefficient can't acceptable!
        // coefficient = x0.05 is not acceptable
        tree.changeMaxNumberPointOfTree(1.5); // print nothing
        // coefficient = x1.5 is acceptable and defaultSize now is 150 instep of 100
        System.out.println(tree.size() + "\n"); // print 6

        // test sibling(), parent() in special case
        System.out.println(tree.sibling(null)); // print null
        System.out.println(tree.parent(null) + "\n"); // print null

        // test isEmpty(), size(), numChildren()
        System.out.println(tree.isEmpty()); // print false
        System.out.println(tree.size()); // print 6
        System.out.println(tree.numChildren(34)); // print 2
        System.out.println(tree.numChildren(80)); // print 1
        System.out.println(tree.numChildren(89) + "\n"); // print 0

        // test setRoot(), setLeft(), setRight() in special case
        // use element = null to delete a part of tree
        System.out.println(tree.size()); // print 6
        tree.setLeft(0, null);
        System.out.println(tree.size()); // print 4
        tree.setRight(0, null);
        System.out.println(tree.size()); // print 1
        tree.setRoot(null);
        System.out.println(tree.size()); // print 0
        System.out.println(tree.isEmpty()); // print true
        System.out.println(tree.root()); // print null
        System.out.println(tree.numChildren(0)); // print 0
        System.out.println(tree.left(0)); // print null
        System.out.println(tree.right(0)); // print null
        // test when use setRoot(null) multi times
        tree.setRoot(null);
        System.out.println(tree.size() + "\n"); // print 0

        // try build tree again to see is anything went wrong
        tree.setRoot(90);
        tree.setLeft(0, 80);
        tree.setRight(0, 34);
        tree.setLeft(1, 23);
        tree.setLeft(2, 89);
        tree.setRight(2, 56);
        System.out.println(tree.isEmpty()); // print false
        System.out.println(tree.size()); // print 6
        System.out.println(tree.numChildren(34)); // print 2
        System.out.println(tree.numChildren(80)); // print 1
        System.out.println(tree.numChildren(89)); // print 0
    }
}
