package Hw6_21002139_PhamNgocHai.ex1.ex1_2;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue.ArrEntry;

public class TestSortedArrayPriorityQueue {
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> queue = new SortedArrayPriorityQueue<>();
        queue.insert(4, "harito");
        queue.insert(1, "hieu");
        queue.insert(3, "don't");
        queue.insert(3, "why");
        queue.insert(0, "yeah");
        queue.insert(2, "cong");
        queue.insert(0, "google");
        queue.insert(0, "microsoft");
        queue.insert(0, "apple");
        queue.insert(0, "amazon");
        queue.insert(0, "meta");
        queue.insert(0, "titer");

        Entry<Integer, String> entry = new ArrEntry<Integer, String>(0, "nhan");
        queue.insert(entry);

        System.out.println("\n" + queue.size()); // print 13
        System.out.println(queue.toString());
        // print
        /*
         * 4 harito
         * 3 don't
         * 3 why
         * 2 cong
         * 1 hieu
         * 0 nhan
         * 0 titer
         * 0 meta
         * 0 amazon
         * 0 apple
         * 0 microsoft
         * 0 google
         * 0 yeah
         */

        System.out.println("\n" + queue.removeMin().toString()); // print 0 yeah
        System.out.println(queue.min().toString()); // print 0 google
        System.out.println(queue.size()); // print 12

        System.out.println("\n" + queue.toString());
        // print
        /*
         * 4 harito
         * 3 don't
         * 3 why
         * 2 cong
         * 1 hieu
         * 0 nhan
         * 0 titer
         * 0 meta
         * 0 amazon
         * 0 apple
         * 0 microsoft
         * 0 google
         */

        System.out.println("\n" + queue.removeMin().toString()); // print 0 google
        System.out.println(queue.min().toString()); // print 0 microsoft
        System.out.println(queue.size()); // print 11

        System.out.println("\n" + queue.toString());
        /*
         * 4 harito
         * 3 don't
         * 3 why
         * 2 cong
         * 1 hieu
         * 0 nhan
         * 0 titer
         * 0 meta
         * 0 amazon
         * 0 apple
         * 0 microsoft
         */

        System.out.println("Is empty now: " + queue.isEmpty()); // print false

        // now we delete all queue
        for (int i = 0; i < 11; i++) {
            queue.removeMin();
        }
        System.out.println("\nIs empty now after delete all queue: " + queue.isEmpty()); // print true
        System.out.println(queue.toString()); // print nothing

        // => Tested all interface function and all of them worked exact like expected
        // in all case
    }
}