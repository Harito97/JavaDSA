package Hw6_21002139_PhamNgocHai.ex1.ex1_5;

import Hw6_21002139_PhamNgocHai.ex1.ex1_1.UnsortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_3.UnsortedLinkedPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_4.SortedLinkedPriorityQueue;

public class TestPriorityQueueWithDifferKeyAndElement {
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
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg apple
     * 9.999999999999E12 $ for harito's company
     * 0.01 $ for 1 cent
     * 45.0 $ for 10 kg orange
     * 
     * Remove min: 0.01 $ for 1 cent
     * Now min is: 45.0 $ for 10 kg apple
     * 
     * Size of queue: 4
     * Is empty: false
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg apple
     * 9.999999999999E12 $ for harito's company
     * 45.0 $ for 10 kg orange
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
     * 9.999999999999E12 $ for harito's company
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg orange
     * 45.0 $ for 10 kg apple
     * 0.01 $ for 1 cent
     * 
     * Remove min: 0.01 $ for 1 cent
     * Now min is: 45.0 $ for 10 kg apple
     * 
     * Size of queue: 4
     * Is empty: false
     * 9.999999999999E12 $ for harito's company
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg orange
     * 45.0 $ for 10 kg apple
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
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg apple
     * 9.999999999999E12 $ for harito's company
     * 0.01 $ for 1 cent
     * 45.0 $ for 10 kg orange
     * 
     * Remove min: 0.01 $ for 1 cent
     * Now min is: 45.0 $ for 10 kg apple
     * 
     * Size of queue: 4
     * Is empty: false
     * 320000.0 $ for 1 rocket
     * 45.0 $ for 10 kg apple
     * 9.999999999999E12 $ for harito's company
     * 45.0 $ for 10 kg orange
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
     * 0.01 $ for 1 cent
     * 45.0 $ for 10 kg apple
     * 45.0 $ for 10 kg orange
     * 320000.0 $ for 1 rocket
     * 9.999999999999E12 $ for harito's company
     * 
     * Remove min: 0.01 $ for 1 cent
     * Now min is: 45.0 $ for 10 kg apple
     * 
     * Size of queue: 4
     * Is empty: false
     * 45.0 $ for 10 kg apple
     * 45.0 $ for 10 kg orange
     * 320000.0 $ for 1 rocket
     * 9.999999999999E12 $ for harito's company
     * 
     * Now remove all queue!
     * 
     * Size of queue: 0
     * Is empty: true
     */

    public static void testUnsortedArrayPriorityQueue() {
        System.out.println("----------------------------------");
        System.out.println("testUnsortedArrayPriorityQueue");
        UnsortedArrayPriorityQueue<Double, String> queue = new UnsortedArrayPriorityQueue<>();
        queue.insert(320000.0, "$ for 1 rocket");
        queue.insert(45.0, "$ for 10 kg apple");
        queue.insert(9999999999999.0, "$ for harito's company");
        queue.insert(0.01, "$ for 1 cent");
        queue.insert(45.0, "$ for 10 kg orange");

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
        SortedArrayPriorityQueue<Double, String> queue = new SortedArrayPriorityQueue<>();
        queue.insert(320000.0, "$ for 1 rocket");
        queue.insert(45.0, "$ for 10 kg apple");
        queue.insert(9999999999999.0, "$ for harito's company");
        queue.insert(0.01, "$ for 1 cent");
        queue.insert(45.0, "$ for 10 kg orange");

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
        UnsortedLinkedPriorityQueue<Double, String> queue = new UnsortedLinkedPriorityQueue<>();
        queue.insert(320000.0, "$ for 1 rocket");
        queue.insert(45.0, "$ for 10 kg apple");
        queue.insert(9999999999999.0, "$ for harito's company");
        queue.insert(0.01, "$ for 1 cent");
        queue.insert(45.0, "$ for 10 kg orange");

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
        SortedLinkedPriorityQueue<Double, String> queue = new SortedLinkedPriorityQueue<>();
        queue.insert(320000.0, "$ for 1 rocket");
        queue.insert(45.0, "$ for 10 kg apple");
        queue.insert(9999999999999.0, "$ for harito's company");
        queue.insert(0.01, "$ for 1 cent");
        queue.insert(45.0, "$ for 10 kg orange");

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
