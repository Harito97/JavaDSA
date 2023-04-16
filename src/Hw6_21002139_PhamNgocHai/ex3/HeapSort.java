package Hw6_21002139_PhamNgocHai.ex3;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex2.MinHeapPriorityQueue;

public class HeapSort {

    // attribute
    private static MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>();
    private static Integer[] sortedArray = null;

    // interface
    public static void takeInputData(Integer[] array) {
        // thao tác ngay trên mảng cũ
        // nhờ thêm dòng này mà chạy debug không bị sắp xếp sai cấu trúc dữ liệu
        sortedArray = array;
        for (Integer x : array) {
            if (x == null)
                break;
            heap.insert(x, null);
        }
    }

    public static void sortIncreased() {
        int length = sortedArray.length;
        for (int i = 0; i < length; i++) {
            Entry<Integer, String> temp = heap.removeMin();
            if (temp == null)
                return;
            sortedArray[i] = temp.getKey();
        }
    }

}
