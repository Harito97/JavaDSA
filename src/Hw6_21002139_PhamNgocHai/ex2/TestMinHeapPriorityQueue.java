package Hw6_21002139_PhamNgocHai.ex2;

public class TestMinHeapPriorityQueue {

    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> queue = new MinHeapPriorityQueue<>(10);
        queue.insert(3, "Three");
        queue.insert(1, "One");
        queue.insert(4, "Four");
        queue.insert(2, "Two");
        queue.insert(0, "Ana");
        queue.insert(2, "Na ru to");
        queue.insert(0, "Play");
        queue.insert(0, "Zero");
        queue.insert(2, "Hai");
        queue.insert(2, "New Hai"); // print Full heap!

        System.out.println("The min heap priority queue now is: \n" + queue);
        // print
        /*
         * The min heap priority queue now is:
         * [0 Ana] // root heapPQ[1]
         * [0 Zero] // left of root heapPQ[2]
         * [0 Play] // right of root heapPQ[3]
         * [1 One] // left1 heapPQ[4]
         * [2 Two] // right1 heapPQ[5]
         * [4 Four] // left2 ...
         * [2 Na ru to] // right2 ...
         * [3 Three] // left of left ...
         * [2 Hai]
         */
        // simple implement
        /*
         * --------------[0 Ana]
         * ---------------/---\
         * --------------/-----\
         * -------[0 Zero]-----[0 Play]
         * ----------/---\-----/---\
         * ---------/-----\---/-----\
         * ---[1 One][2 Two][4 Four][2 Na ru to]
         * ----/----\
         * [3 Three] \
         * ----------[2 Hai]
         */
        // => Success build a min heap priority queue
    }
    
}
