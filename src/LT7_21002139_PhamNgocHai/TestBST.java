package LT7_21002139_PhamNgocHai;

public class TestBST {
    // Driver Code
    public static void main(String[] args) throws Exception {
        /*
         * Let us create following BST
         * -----50
         * ----/--\
         * ---30---70
         * --/ \---/ \
         * 20--40|60 80
         */
        BinarySearchTree.insert(50);
        BinarySearchTree.insert(30);
        BinarySearchTree.insert(20);
        BinarySearchTree.insert(40);
        BinarySearchTree.insert(77);
        BinarySearchTree.insert(60);
        BinarySearchTree.insert(80);
        Node root = BinarySearchTree.getRoot();

        // Test inorder 
        BinarySearchTree.inorder();
        System.out.println();
        // print 20.0 30.0 40.0 50.0 60.0 70.0 80.0

        // Test minValue
        System.out.println(BinarySearchTree.minValue(root));
        // print 20

        // Test search
        System.out.println(BinarySearchTree.search(root, 60).getValue());
        // print 60

        // Test delete
        BinarySearchTree.deleteValue(40);
        BinarySearchTree.inorder();
        System.out.println();
        // 20.0 30.0 50.0 60.0 70.0 80.0

        // Test isRepresentingBST(double[] a)
        double[] a = new double[] { 0, 3, 5, 8, 9, 90 };
        System.out.println(BinarySearchTree.isRepresentingBST(a));
        // print true

        a = new double[] { 0, 4, 3, 2, 8, 10 };
        System.out.println(BinarySearchTree.isRepresentingBST(a));
        // print false

        // Test isBST(Node root)
        System.out.println(BinarySearchTree.isBST(root));
        // print true

        // Test findMedian(Node root)
        BinarySearchTree.deleteValue(30);
        BinarySearchTree.deleteValue(50);
        BinarySearchTree.deleteValue(60);
        BinarySearchTree.deleteValue(80);
        System.out.println(BinarySearchTree.findMedian(root)); 
        BinarySearchTree.insert(50);
        BinarySearchTree.insert(30);
        BinarySearchTree.insert(60);
        BinarySearchTree.insert(80);
        System.out.println(BinarySearchTree.findMedian(root));
        // print 48.5
        // print 55.0
        
        // Test countInRange(double lowerBound, double upperBound)
        System.out.println(BinarySearchTree.countInRange(50, 80));
        // print 2

        // Test kthSmallest(int k)
        System.out.println(BinarySearchTree.kthSmallest(3));
        // print 50.0

        System.out.println(BinarySearchTree.kthLargest(4));
        // print 50.0

        // Test inOrderSuccessor(Node x)
        Node x = root.left.right;
        System.out.println(x.getValue());
        // print 50.0
        System.out.println(BinarySearchTree.inOrderSuccessor(x).value);
        // print 60.0
        // Test ...
        
    }
}
