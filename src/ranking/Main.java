package DataStructureAndAlgorithms.AssignmentLT.spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        StringBuilder builder = new StringBuilder();
        while (t-- > 0) {
            int n = reader.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = reader.nextInt();
            quickSort(arr, 0, arr.length - 1);
            for (int i : arr)
                builder.append(i + " ");
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        CustomComparator comparator = new CustomComparator();
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class CustomComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a == 1)
            return -1;
        if (b == 1)
            return 1;
        if (a == 2 && b == 3)
            return -1;
        if (a == 3 && b == 2)
            return 1;
        return b - a;
    }
}

class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;

        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }

        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();

        while (c <= ' ')
            c = read();

        boolean neg = (c == '-');

        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;

        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bufferPointer = 0;
        bytesRead = din.read(buffer,
                bufferPointer,
                BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}