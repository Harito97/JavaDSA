package Hw6_21002139_PhamNgocHai.ex4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import Hw6_21002139_PhamNgocHai.ex1.PriorityQueueInterface;
import Hw6_21002139_PhamNgocHai.ex1.ex1_1.UnsortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_2.SortedArrayPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_3.UnsortedLinkedPriorityQueue;
import Hw6_21002139_PhamNgocHai.ex1.ex1_4.SortedLinkedPriorityQueue;

public class TestImplementOfPriorityQueue {

    private static final int[] SIZE_OF_DATA_SETS = { 50, 100, 200, 400, 800, 1600 };
    // { 1000, 10000, 100000, 1000000, 10000000, 100000000 }; // để data size to thế
    // này đợi chạy xong mất quá nhiều thời gian
    private static final String[] IMPLEMENT_OF_PRIORITY_QUEUE = { "UnsortedArrayPriorityQueue",
            "SortedArrayPriorityQueue", "UnsortedLinkedPriorityQueue", "SortedLinkedPriorityQueue" };
    private static int[] dataSet;
    private static long[][] timeRunTest = new long[8][6];
    // 8 lines mean
    // 4 lines for 4 types of insert() and
    // 4 lines for 4 types of removeMin()
    // 6 columns store time to do function with sizes of data (10^3 to 10^8)

    public static void main(String[] args) throws IOException {
        int indexSize = 0;
        for (int size : SIZE_OF_DATA_SETS) {
            generateData(size);
            for (int encode = 0; encode < 4; encode++) {
                timeRunTest[encode][indexSize] = timeInsert(encode, size);
                timeRunTest[4 + encode][indexSize] = timeRemoveMin(encode, size);
            }
            ++indexSize;
        }
        String result = resultTest();
        // data in ra là nanosecond thay vì millisecond như đề bài yêu cầu 
        // vì data size đã sửa lại để đỡ phải chờ lâu nên để nanosecond cho dễ nhìn thấy
        // sự khác biệt
        printResultTestToTerminal(result);
        printResultTestToFile(result);
    }

    private static void generateData(int size) {
        Random random = new Random();
        int n = size;
        dataSet = new int[n];
        while (--n >= 0) {
            dataSet[n] = random.nextInt();
        }
    }

    private static long timeInsert(int encode, int size) {
        PriorityQueueInterface<Integer, Character> pQueue = null;

        switch (encode) {
            case 0:
                pQueue = new UnsortedArrayPriorityQueue<>(size);
                break;
            case 1:
                pQueue = new SortedArrayPriorityQueue<>(size);
                break;
            case 2:
                pQueue = new UnsortedLinkedPriorityQueue<>();
                break;
            case 3:
                pQueue = new SortedLinkedPriorityQueue<>();
        }

        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            pQueue.insert(dataSet[i], null);
        }

        return System.nanoTime() - start;
    }

    private static long timeRemoveMin(int encode, int size) {
        PriorityQueueInterface<Integer, Character> pQueue = null;

        switch (encode) {
            case 0:
                pQueue = new UnsortedArrayPriorityQueue<>(size);
                break;
            case 1:
                pQueue = new SortedArrayPriorityQueue<>(size);
                break;
            case 2:
                pQueue = new UnsortedLinkedPriorityQueue<>();
                break;
            case 3:
                pQueue = new SortedLinkedPriorityQueue<>();
        }

        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            pQueue.removeMin();
        }

        return System.nanoTime() - start;
    }

    private static String resultTest() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < 6; i++) {
            builder.append("*With size of data set = ").append(SIZE_OF_DATA_SETS[i]);
            for (int j = 0; j < 4; j++) {
                builder.append("\n" + (j + 1) + ". " + IMPLEMENT_OF_PRIORITY_QUEUE[j] + " ... \n")
                        .append("Time to insert(): ")
                        .append(timeRunTest[j][i] + "ns\n")
                        .append("Time to removeMin(): ")
                        .append(timeRunTest[4 + j][i] + "ns\n");
            }
            builder.append("\n\n");
        }
        return builder.toString();
    }

    private static void printResultTestToTerminal(String string) {
        System.out.print(string);
    }

    private static void printResultTestToFile(String string) throws IOException {
        System.out.println("Writing this result test to file ...");
        String fileName = "src/Hw6_21002139_PhamNgocHai/ex4/ResultOfTestFourImplementOfPriorityQueue.txt";
        FileWriter objectFile = new FileWriter(fileName);
        objectFile.write(string);
        objectFile.close();
        System.out.println("Write successful!\n");
    }

}
