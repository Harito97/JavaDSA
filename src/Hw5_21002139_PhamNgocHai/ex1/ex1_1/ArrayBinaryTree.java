package Hw5_21002139_PhamNgocHai.ex1.ex1_1;

import java.io.FileWriter;
import java.io.IOException;

import Hw5_21002139_PhamNgocHai.ex1.BinaryTreeInterface;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E[] array;
    private int numberNode = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    // interface
    public E root() {
        return array[0];
    }

    public int size() {
        return numberNode;
    }

    public boolean isEmpty() {
        return numberNode == 0;
    }

    public int numChildren(E p) {
        int i = findElementWithPreOrderTraversal(array, 0, p);
        if (i < 0)
            return 0;
        if (array[2 * i + 2] != null && array[2 * i + 1] == null)
            return 1;
        if (array[2 * i + 2] == null && array[2 * i + 1] != null)
            return 1;
        if (array[2 * i + 2] != null && array[2 * i + 1] != null)
            return 2;
        return 0;
    }

    public E parent(E p) {
        for (int i = 0; i < numberNode; i++) {
            // xet ben trai node p
            if (array[2 * i + 1] != null && array[2 * i + 1].equals(p))
                return array[i];
            // xet ben phai node p
            if (array[2 * i + 2] != null && array[2 * i + 2].equals(p)) {
                return array[i];
            }
        }
        return null;
    }

    public E sibling(E p) {
        int index = findElementWithPreOrderTraversal(array, 0, p);
        if (index <= 0) {
            return null;
        }
        if (index % 2 != 0) {
            return array[index / 2 * 2 + 2];
        }
        return array[index / 2 * 2 - 1];
    }

    public E left(E p) {
        int index = findElementWithPreOrderTraversal(array, 0, p);
        if (index == -1) {
            // don't exist any node have value element p
            return null;
        } else if (index >= 0 && 2 * index < defaultSize - 1) {
            return array[2 * index + 1];
        }
        return null;
    }

    public E right(E p) {
        int index = findElementWithPreOrderTraversal(array, 0, p);
        if (index == -1) {
            // don't exist any node have value element p
            return null;
        } else if (index >= 0 && 2 * index < defaultSize - 2) {
            return array[2 * index + 2];
        }
        return null;
    }

    // update methods
    /**
     * @param element
     *                if element is null then delete root (mean make tree has 0
     *                point)
     * 
     *                if element is not null then add root (if there is no root
     *                before) or set root by element (if there is root already)
     * @return
     *         null if element null or there is no root before setRoot(element)
     *         old value of root in the other cases
     */
    public E setRoot(E element) {
        if (element == null) {
            E oldValue = array[0];
            delete(0);
            return oldValue;
        }

        if (array[0] == null) {
            array[0] = element;
            ++numberNode;
            return null;
        }
        E oldValue = array[0];
        array[0] = element;
        return oldValue;
    }

    /**
     * @param p
     *                p is the index encode for a point in tree
     *                so p belong [0, maxNumberPointOfTree)
     * 
     *                remember when p >= (maxNumberPointOfTree - 1) / 2, it can't
     *                create the right child except increasing the
     *                maxNumberPointOfTree - that's not support for now
     * @param element
     *                if element null then delete the left child of point has index
     *                p
     * 
     *                else set left child of p has value element if element is not
     *                null or create new child in left of p if it don't exist before
     * @return
     *         old value of left child of p if it exist before
     *         else return null
     */
    public E setLeft(int p, E element) {
        if (p < 0 || 2 * p >= defaultSize - 1) {
            return null;
        }

        if (element == null) {
            E oldValue = array[2 * p + 1];
            delete(2 * p + 1);
            return oldValue;
        }

        if (array[2 * p + 1] == null) {
            array[2 * p + 1] = element;
            ++numberNode;
            return null;
        }
        E oldValue = array[2 * p + 1];
        array[2 * p + 1] = element;
        return oldValue;
    }

    /**
     * @param p
     *                p is the index encode for a point in tree
     *                so p belong [0, maxNumberPointOfTree)
     * 
     *                remember when p >= (maxNumberPointOfTree - 2) / 2, it can't
     *                create the right child except increasing the
     *                maxNumberPointOfTree - that's not support for now
     * @param element
     *                if element null then delete the right child of point has index
     *                p
     * 
     *                else set right child of p has value element if element is not
     *                null or create new child in right of p if it don't exist
     *                before
     * @return
     *         old value of right child of p if it exist before
     *         else return null
     */
    public E setRight(int p, E element) {
        if (p < 0 || 2 * p >= defaultSize - 2) {
            return null;
        }

        if (element == null) {
            E oldValue = array[2 * p + 2];
            delete(2 * p + 2);
            return oldValue;
        }

        if (array[2 * p + 2] == null) {
            array[2 * p + 2] = element;
            ++numberNode;
            return null;
        }
        E oldValue = array[2 * p + 2];
        array[2 * p + 2] = element;
        return oldValue;
    }

    /**
     * @return String of elements follow array index increasing
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("| ");

        for (int i = 0; i < defaultSize; i++)
            builder.append(array[i]).append(" | ");

        return builder.toString();
    }
    
    private static final int COUNT = 10;
    public void visualize(E data, int space) {
		// Base case
	    if (data == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    visualize(this.right(data), space);
	 
	    // Print current node after space count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(data + "\n");
	 
	    // Process left child
	    visualize(this.left(data), space);
	}
	
	public void writeFile(E root, int space, FileWriter write) throws IOException {
		// Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    writeFile(this.right(root), space, write);
	 
	    // Print current node after space count
	    write.write("\n");
	    for (int i = COUNT; i < space; i++)
	        write.write(" ");
	    write.write(root + "\n");
	 
	    // Process left child
	    writeFile(this.left(root), space, write);
	}

    /**
     * @param coefficient
     *                    coefficient is a double - has value from 0 and should be 2
     *
     *                    if coefficient < 1 then defaultSize will descending
     *                    (if number of point already in tree are smaller)
     *                    if coefficient > 1 then defaultSize will ascending
     *
     *                    warning that because defaultSize is int (max near to
     *                    2,000,000,000) so
     *                    max coefficient that still work like expected is near to
     *                    20,000,000.0
     */

    public void changeMaxNumberPointOfTree(double coefficient) {
        int newSize = (int) (defaultSize * coefficient);
        int lastIndexNotNull = 0;
        for (int i = 0; i < defaultSize; i++) {
            if (array[i] != null) 
                lastIndexNotNull = i;
        }
        if (coefficient <= 0 || newSize <= lastIndexNotNull) {
            System.out.println("Coefficient can't acceptable!");
            return;
        }
        E[] newArray = (E[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, lastIndexNotNull + 1);
        defaultSize = newSize;
        array = newArray;
    }

    private int findElementWithPreOrderTraversal(E[] tree, int index, E p) {
        // remember that our start from index 0 - is root
        // the left of index i is 2 * i + 1
        // the right of index i is 2 * i + 2
        if (index < 0 || index >= numberNode) {
            return -1;
        }
        if (tree[index] != null && tree[index].equals(p)) {
            return index;
        }
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        findElementWithPreOrderTraversal(tree, leftChildIndex, p);
        findElementWithPreOrderTraversal(tree, rightChildIndex, p);
        index++;
        return findElementWithPreOrderTraversal(tree, index, p);
    }

    private void delete(int p) {
        // no need to check p is valid or not as we did it
        // when using function setRoot(), setLeft(), setRight()

        // check condition to stop recursion
        if (array[p] == null || p >= defaultSize) {
            return;
        }

        int leftIndex = 2 * p + 1;
        int rightIndex = 2 * p + 2;
        array[p] = null;
        --numberNode;
        delete(leftIndex);
        delete(rightIndex);
    }
}
