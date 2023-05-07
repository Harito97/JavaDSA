package LT7_21002139_PhamNgocHai;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree {
    // Root of BST
    private static Node root;

    // This method mainly calls insertRec()
    /**
     * Dùng đệ quy
     * Time: O(h) với h là chiều cao của cây, trường hợp cây bị lệch
     * thì có thể thành O(n) với n là số node
     * Space: O(1)
     * 
     * @param value
     * 
     */
    public static void insert(double value) {
        root = insertRec(root, value);
        // đây là cách dùng insert đệ quy, ngoài ra chúng ta có thể dùng cách khác để
        // phá đệ quy
    }

    // A recursive function to
    // insert a new value in BST
    private static Node insertRec(Node startNode, double value) {
        // If the tree is empty,
        // return a new node
        if (startNode == null) {
            startNode = new Node(value);
            return startNode;
        }

        // Otherwise, recur down the tree
        else if (value < startNode.value)
            startNode.left = insertRec(startNode.left, value);
        else if (value > startNode.value)
            startNode.right = insertRec(startNode.right, value);

        // Return the (unchanged) node pointer
        return startNode;
    }

    // This method mainly calls InorderRec()
    /**
     * Duyệt cây theo thứ tự trái - gốc - phải bằng cách dùng đệ quy
     * The time complexity of inorder traversal is O(n), as each node is visited
     * once.
     * The Auxiliary space is O(n), as we use a stack to store nodes for recursion.
     */
    public static void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    private static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // A utility function to search a given value in BST
    /**
     * Time complexity: O(h), where h is the height of the BST.
     * Space complexity: O(h), where h is the height of the BST. This is
     * because the maximum amount of space needed to store the recursion
     * stack would be h.
     * 
     * @param root
     * @param value
     * @return node have value
     */
    public static Node search(Node root, double value) {
        // Base Cases: root is null or value is present at root
        if (root == null || root.value == value)
            return root;

        // value is greater than root's value
        if (root.value < value)
            return search(root.right, value);

        // value is smaller than root's value
        return search(root.left, value);
    }

    // This method mainly calls deleteRec()
    /**
     * Time Complexity: O(log N)
     * Auxiliary Space: O(log N), Space used for recursion stack
     * 
     * @param value
     */
    public static void deleteValue(double value) {
        root = deleteRec(root, value);
    }

    /*
     * A recursive function to
     * delete an existing value in BST
     */
    private static Node deleteRec(Node root, double value) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);

        // if value is same as root's
        // value, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    /**
     * @param root
     * @return min value in BST
     */
    public static double minValue(Node root) {
        double minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    /**
     * Kiểm tra một dãy có là dãy duyệt giữa của cây tìm kiếm nhị phân - Inorder
     * Traversal and BST
     * 
     * @param a : the array lưu trữ dãy để kiểm tra
     * @return true nếu có là và false nếu không là
     */
    public static boolean isRepresentingBST(double[] a) {
        int n = a.length;
        for (int i = 0; i + 1 < n; i++)
            if (a[i] >= a[i + 1])
                return false;
        return true;
    }

    /**
     * @param root
     * @return true if tree has root (input) is a BST, else is false
     */
    public static boolean isBST(Node root) {
        if (root == null)
            return true;

        // the binary tree has at most 100000 edges
        double[] a = new double[100000];
        int[] n = { 0 };

        inOrder(root, a, n);

        for (int i = 0; i + 1 < n[0]; i++)
            if (a[i] >= a[i + 1])
                return false;

        return true;
    }

    /**
     * Tìm median của cây tìm kiếm nhị phân - Median of BST
     * 
     * @param root
     * @return value of median
     * @throws Exception
     */
    public static double findMedian(Node root) throws Exception {
        // the binary tree has at most 100000 nodes
        double[] a = new double[100000];
        int[] n = { 0 };

        inOrder(root, a, n);

        if (n[0] == 0)
            throw new Exception("No median!");

        if (n[0] % 2 == 1)
            return a[n[0] / 2];
        else
            return (a[n[0] / 2] + a[n[0] / 2 - 1]) / 2.0;
    }

    private static void inOrder(Node root, double[] a, int[] n) {
        if (root == null)
            return;
        inOrder(root.left, a, n);
        a[n[0]++] = root.value;
        inOrder(root.right, a, n);
        // dùng int[] n thay vì dùng int n vì nếu thay thế int[] n thành int n thì giá
        // trị của biến n trong phương thức sẽ là một bản sao của giá trị n ban đầu và
        // thay đổi giá trị n trong phương thức sẽ không ảnh hưởng đến giá trị n ban
        // đầu. Điều này sẽ làm cho phương thức inOrder không thể cập nhật giá trị của
        // biến n để đếm số lượng phần tử trong mảng a. Vì vậy, cần sử dụng một mảng
        // hoặc một đối tượng chứa biến đếm để có thể cập nhật giá trị trong phương thức
        // và giữ nguyên giá trị ở bên ngoài phương thức.
    }

    /**
     * Đếm các giá trị của cây trong khoảng cho trước - Count BST nodes that lie in
     * a given range
     * 
     * @param lowerBound
     * @param upperBound
     * @return number of node has value in range
     */
    public static int countInRange(double lowerBound, double upperBound) {
        int[] count = { 0 };
        Node currentNode = root;
        countInRange(currentNode, count, lowerBound, upperBound);
        return count[0];
    }

    private static void countInRange(Node currentNode, int[] count, double lowerBound, double upperBound) {
        if (currentNode != null && currentNode.value >= lowerBound && currentNode.value <= upperBound) {
            count[0] = count[0] + 1;
            countInRange(currentNode.left, count, lowerBound, upperBound);
            countInRange(currentNode.right, count, lowerBound, upperBound);
        }
    }

    /**
     * @param k
     * @return Phần tử nhỏ nhất thứ k trong cây tìm kiếm nhị phân - k-th smallest
     *         element in BST
     */
    public static double kthSmallest(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("argument k have > 0");
        }
        double[] arr = new double[100000];
        int[] n = { 0 };
        inOrder(root, arr, n);
        return arr[k - 1];
    }

    /**
     * @param k
     * @return Phần tử lớn thứ k trong cây tìm kiếm nhị phân - Kth largest element
     *         in BST
     */
    public static double kthLargest(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("argument k have > 0");
        }
        double[] arr = new double[100000];
        int[] n = { 0 };
        inOrder(root, arr, n);
        return arr[n[0] - k];
    }

    /**
     * returns the inorder successor of the Node x in BST (rooted at ’root ’)
     * 
     * @param root
     * @param x
     * @return Tìm phần tử liền sau của một nôt trên cây tìm kiếm nhị phân - Inorder
     *         Successor in BST
     * 
     */
    public static Node inOrderSuccessor(Node x) {
        Node successor = null;
        while (root != null) {
            if (root.value <= x.value) // go right
                root = root.right;
            else {
                // go left
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    /**
     * Tìm phần tử liền trước và liền sau của một phần tử trên cây tìm kiếm nhị phân
     * - Predecessor and Successor
     * 
     * @param value
     * @return double[] {predecessor, successor}
     */
    public static double[] predecessorAndSuccessor(double value) {
        double[] arr = new double[100000];
        int[] n = { 0 };
        inOrder(root, arr, n);
        int index = -1;
        
        for (int i = 0; i < n[0]; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        if (index < 0)
            return new double[] { Double.MAX_VALUE, Double.MIN_VALUE };
        if (index == 0)
            return new double[] { Double.MAX_VALUE, arr[index + 1] };
        return new double[] { arr[index - 1], arr[index + 1] };
    }

    /**
     * Tìm giá trị phần tử lớn nhất trên cây tìm kiếm nhị phân mà không vượt quá N -
     * Closest Neighbor in BST
     * 
     * @param value
     * @return
     */
    public static double closestNeighborInBST(double value) {
        Node current = root;
        while (current.right != null) {
            if (current.right.value <= value) {
                current = current.right;
            } else {
                break;
            }
        }
        return current.value;
    }

    /**
     * Tìm số bé nhất trên cây tìm kiếm nhị phân mà có giá trị lớn hơn hoặc bằng một
     * giá trị cho trước - Ceil in BST
     * 
     * @param value
     * @return
     */
    public static double ceilInBST(double value) {
        Node current = root;
        while (current.left != null) {
            if (current.left.value >= value) {
                current = current.left;
            } else {
                break;
            }
        }
        return current.value;
    }

    /**
     * Xóa mọi phần tử có giá trị lớn hơn k trong cây tìm kiếm nhị phân - Delete
     * nodes greater than k
     * 
     * @param value
     */
    public static void deleteNodesGreaterThanValue(double value) {
        deleteNodesGreaterThanValue(root, value);
    }

    private static Node deleteNodesGreaterThanValue(Node currentNode, double value) {
        if (currentNode == null)
            return null;

        if (currentNode.value >= value) {
            currentNode.left = deleteNodesGreaterThanValue(currentNode.left, value);
            currentNode.right = deleteNodesGreaterThanValue(currentNode.right, value);
        }

        if (currentNode.value >= value) {
            Node temp = currentNode.left;
            currentNode = null;
            return temp;
        }
        return currentNode;
    }

    /**
     * Thay đổi khoá phần tử - Change of value in BST
     * 
     * @param oldValue
     * @param newValue
     */
    public static void changeValueInBST(double oldValue, double newValue) {
        deleteValue(oldValue);
        insert(newValue);
    }

    public static Node binaryTreeToBST(Node root) {
        ArrayList<Double> v = new ArrayList<>();
        int i = 0;
        inOrder1(root, v);
        Comparator<Double> comparator = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }

        };
        v.sort(comparator);
        inOrder2(root, v, i);
        return root;
    }

    private static void inOrder1(Node root, ArrayList<Double> v) {
        if (root != null) {
            inOrder1(root.left, v);
            v.add(root.value);
            inOrder1(root.right, v);
        }
    }

    private static void inOrder2(Node root, ArrayList<Double> v, int i) {
        if (root != null) {
            inOrder2(root.left, v, i);
            root.value = v.get(i);
            ++i;
            inOrder2(root.right, v, i);
        }
    }

    /**
     * Kiểm tra một dãy có là kết quả của phép duyệt trước trên cây tìm kiếm nhị
     * phân - Preorder Traversal in BST
     * 
     * @param array
     * @return true if array is preorder in BST, else is false
     */
    public static boolean isPreorderTaversalInBST(double[] array) {
        return preorderRec(root, array, 0);
    }

    private static boolean preorderRec(Node currentNode, double[] array, int index) {
        if (currentNode != null) {
            if (currentNode.value != array[index])
                return false;
            ++index;
            if (preorderRec(currentNode.left, array, index) &&
                    preorderRec(currentNode.right, array, index)) {
                return true;
            }
            return true;
        }
        return false;
    }

    /**
     * @param post
     * @param size
     * @return root of BST from its postorder traversal.
     */
    public Node constructTreeFromPostOrder(double[] post, int size) {
        int postorderIndex = 0;
        return constructTreeFromPostOrder(post, postorderIndex, post[0], Double.MIN_VALUE, Double.MAX_VALUE, size);
    }

    private Node constructTreeFromPostOrder(double[] post, int postIndex, double value, double min, double max,
            int size) {
        if (postIndex >= size)
            return null;
        Node currentNode = new Node();
        if (value > min && value < max) {
            postIndex++;
            currentNode.left = constructTreeFromPostOrder(post, postIndex, post[postIndex], min, value, size);
            currentNode.right = constructTreeFromPostOrder(post, postIndex, post[postIndex], value, max, size);
            currentNode.value = value;
        }
        return currentNode;
    }

    /**
     * Chuyển đổi phép duyệt tiền tố thành hậu tố - Preorder to Postorder
     * 
     * @param pre array
     * @return postorder array
     */
    public Node post_order(int[] pre) {
        int[] preorderIndex = { 0 };
        return constructTree(pre, preorderIndex, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length);
    }

    private Node constructTree(int[] pre, int[] preIndex, int key, int min, int max, int size) {
        if (preIndex[0] >= size) {
            return null;
        }
        Node root = null;
        if (key > min && key < max) {
            root = new Node(key);
            preIndex[0]++;
            root.left = constructTree(pre, preIndex, pre[preIndex[0]], min, key, size);
            root.right = constructTree(pre, preIndex, pre[preIndex[0]], key, max, size);
        }
        return root;
    }

    public static Node getRoot() {
        return root;
    }

    public static void setRoot(Node root) {
        BinarySearchTree.root = root;
    }

}

// Class containing left
// and right child of current node
// and value value
class Node {
    double value;
    Node left, right;

    public Node() {
    }

    public Node(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
