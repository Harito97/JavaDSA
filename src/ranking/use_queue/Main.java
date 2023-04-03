package ranking.use_queue;

//import java.io.FileInputStream;
import java.lang.StringBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    static class ArrayQueue {
        private int[] queue;
        //private int n = 0; // so phan tu
        private int top = 0;// vi tri phan tu dau tien
        private int count = 0;// dem hien tai trong queue co bn phan tu
        private int default_size = 100;

        public ArrayQueue(int capacity) {
            //n = capacity;
            queue = new int[capacity];
        }

        public ArrayQueue() {
            //n = default_size;
            queue = new int[default_size];
        }

        private void ensureCapacity() {
            int newSize = queue.length * 2;
            queue = Arrays.copyOf(queue, newSize);
        }

        public void enqueue(int element) throws IllegalAccessException {
            if (count == queue.length) {
                ensureCapacity();
                // throw new IllegalAccessException("Queue is full");
            }
            int avail = (top + count) % queue.length; // tranh truong hop bi tran gia tri
            queue[avail] = element;
            count++;
        }

        public Integer dequeue() {
            if (isEmpty()) {
                return null;
            }
            int answer = queue[top];
            queue[top] = Integer.MIN_VALUE;
            top = (top + 1) % queue.length;
            count--;
            return answer;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public Integer first() {
            if (isEmpty())
                return null;
            return queue[top];
        }
    }

    public static void main(String args[]) throws IOException, IllegalAccessException {
        Reader r = new Reader();
        StringBuilder sb = new StringBuilder();
        ArrayQueue queue = new ArrayQueue();
        int t = r.nextInt();
        int n;
        int x;
        while (t-- > 0) {
            n = r.nextInt();
            if (n == 1) {
                x = r.nextInt();
                queue.enqueue(x);
            } else if (n == 2) {
                // if (!queue.isEmpty()) {
                queue.dequeue();
                // }
            } else {
                if (queue.isEmpty()) {
                    sb.append("Empty!\n");
                } else {
                    sb.append(queue.first()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
