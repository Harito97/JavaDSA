package DataStructureAndAlgorithms.AssignmentLT.spoj;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EasyQueue {
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

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
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
    }
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();
        Queue<Integer> queue = new ConcurrentLinkedQueue<>(); 
        int t = reader.nextInt();
        int code = 0;
        boolean isEmpty;
        while (t-- > 0) {
            code = reader.nextInt();
            if (code == 1) {
                queue.add(reader.nextInt());
            } else {
                isEmpty = queue.isEmpty();
                if (code == 2 && !isEmpty) {
                    queue.poll();
                } else {    
                    if (isEmpty) {
                        builder.append("Empty!\n");
                    } else {
                        builder.append(queue.peek()).append("\n");
                    }
                }
            } 
        }
        System.out.println(builder.toString());
    }
}