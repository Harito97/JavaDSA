package Hw6_21002139_PhamNgocHai.ex2;


public class TestMinHeapPriorityQueue {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> queue = new MinHeapPriorityQueue<>(10);
        queue.insert(3, "Three");
        queue.insert(1, "One");
        queue.insert(4, "Four");
        queue.insert(2, "Two");

        System.out.println("The min heap priority queue now is: \n" + queue);
        
        //queue.upHeap();
        System.out.println("-------------------------------------");
        System.out.println("Use up heap!");
        System.out.println("The min heap priority queue now is: \n" + queue);
        
        //queue.downHeap();
        System.out.println("-------------------------------------");
        System.out.println("Use down heap!");
        System.out.println("The min heap priority queue now is: \n" + queue);

        
    }
}
