package Hw6_21002139_PhamNgocHai.ex1.ex1_5;

import Hw6_21002139_PhamNgocHai.ex1.ex1_1.UnsortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_3.UnsortedLinkedPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_4.SortedLinkedPriorityQueue;

public class TestPriorityQueueWithSameKeyAndElement {
    public static void main(String[] args) {

        /*
         * testUnsortedArrayPriorityQueue()
         * testUnsortedLinkedPriorityQueue()
         * testSortedArrayPriorityQueue()
         * testSortedLinkedPriorityQueue()
         * (see detail result in below this file)
         */

        testUnsortedArrayPriorityQueue();

        testSortedArrayPriorityQueue();

        testUnsortedLinkedPriorityQueue();

        testSortedLinkedPriorityQueue();

    }

    /*
     * here are result of testUnsortedArrayPriorityQueue():
     * 
     * Size of queue: 5
     * Is empty: false
     * 0 0
     * 4 4
     * 3 3
     * 6 6
     * 3 3
     * 
     * Remove min: 0 0
     * Now min is: 3 3
     * 
     * Size of queue: 4
     * Is empty: false
     * 4 4
     * 3 3
     * 6 6
     * 3 3
     * 
     * Now remove all queue!
     * 
     * Size of queue: 0
     * Is empty: true
     */

    /*
     * here are result of testSortedArrayPriorityQueue():
     * 
     * Size of queue: 5
     * Is empty: false
     * 6 6
     * 4 4
     * 3 3
     * 3 3
     * 0 0
     * 
     * Remove min: 0 0
     * Now min is: 3 3
     * 
     * Size of queue: 4
     * Is empty: false
     * 6 6
     * 4 4
     * 3 3
     * 3 3
     * 
     * Now remove all queue!
     * 
     * Size of queue: 0
     * Is empty: true
     */

    /*
     * here are result of testUnsortedLinkedPriorityQueue():
     * 
     * Size of queue: 5
     * Is empty: false
     * 0 0
     * 4 4
     * 3 3
     * 6 6
     * 3 3
     * 
     * Remove min: 0 0
     * Now min is: 3 3
     * 
     * Size of queue: 4
     * Is empty: false
     * 4 4
     * 3 3
     * 6 6
     * 3 3
     * 
     * Now remove all queue!
     * 
     * Size of queue: 0
     * Is empty: true
     */

    /*
     * here are result of testSortedLinkedPriorityQueue():
     * 
     * Size of queue: 5
     * Is empty: false
     * 0 0
     * 3 3
     * 3 3
     * 4 4
     * 6 6
     * 
     * Remove min: 0 0
     * Now min is: 3 3
     * 
     * Size of queue: 4
     * Is empty: false
     * 3 3
     * 3 3
     * 4 4
     * 6 6
     * 
     * Now remove all queue!
     * 
     * Size of queue: 0
     * Is empty: true
     */

    public static void testUnsortedArrayPriorityQueue() {
        System.out.println("----------------------------------");
        System.out.println("testUnsortedArrayPriorityQueue");
        UnsortedArrayPriorityQueue<Integer, Integer> queue = new UnsortedArrayPriorityQueue<>();
        queue.insert(0, 0);
        queue.insert(4, 4);
        queue.insert(3, 3);
        queue.insert(6, 6);
        queue.insert(3, 3);

        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Now min is: " + queue.min());
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Now remove all queue!");
        for (int i = 0; i < 4; i++) {
            queue.removeMin();
        }
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());
    }

    public static void testSortedArrayPriorityQueue() {
        System.out.println("----------------------------------");
        System.out.println("testSortedArrayPriorityQueue");
        SortedArrayPriorityQueue<Integer, Integer> queue = new SortedArrayPriorityQueue<>();
        queue.insert(0, 0);
        queue.insert(4, 4);
        queue.insert(3, 3);
        queue.insert(6, 6);
        queue.insert(3, 3);

        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Now min is: " + queue.min());
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Now remove all queue!");
        for (int i = 0; i < 4; i++) {
            queue.removeMin();
        }
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());
    }

    public static void testUnsortedLinkedPriorityQueue() {
        System.out.println("----------------------------------");
        System.out.println("testUnsortedLinkedPriorityQueue");
        UnsortedLinkedPriorityQueue<Integer, Integer> queue = new UnsortedLinkedPriorityQueue<>();
        queue.insert(0, 0);
        queue.insert(4, 4);
        queue.insert(3, 3);
        queue.insert(6, 6);
        queue.insert(3, 3);

        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Now min is: " + queue.min());
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Now remove all queue!");
        for (int i = 0; i < 4; i++) {
            queue.removeMin();
        }
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());
    }

    public static void testSortedLinkedPriorityQueue() {
        System.out.println("----------------------------------");
        System.out.println("testSortedLinkedPriorityQueue");
        SortedLinkedPriorityQueue<Integer, Integer> queue = new SortedLinkedPriorityQueue<>();
        queue.insert(0, 0);
        queue.insert(4, 4);
        queue.insert(3, 3);
        queue.insert(6, 6);
        queue.insert(3, 3);

        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Now min is: " + queue.min());
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());

        System.out.println("Now remove all queue!");
        for (int i = 0; i < 4; i++) {
            queue.removeMin();
        }
        System.out.println("\nSize of queue: " + queue.size() + "\nIs empty: " + queue.isEmpty());
        System.out.println(queue.toString());
    }
}
