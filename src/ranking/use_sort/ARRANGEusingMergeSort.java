package ranking.use_sort;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ARRANGEusingMergeSort {
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
        StringBuilder builder = new StringBuilder();
        Reader reader = new Reader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int index = 0;
            int n = reader.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                int number = reader.nextInt();
                // print all number 1 in front
                if (number == 1) {
                    builder.append("1 ");
                } else {
                    // input will have only number bigger than 1
                    input[index] = number;
                    ++index;
                }
            }
            // check the special case if only have 2 and 3
            // result will be 1 1 ... 1 2 3
            if (index == 2 &&
                    ((input[0] == 2 && input[1] == 3) ||
                            (input[0] == 3 && input[1] == 2))) {
                builder.append("2 3 \n");
                continue;
            }

            // if input is in normal case then 
            // simply sort the array ascending like [0, 2, 3, 4, 5, ...]
            // and print it from back to front 
            // (result will be 1 1 ... 1 n n-1 n-2 ... 3 2)
            Arrays.sort(input);
            int i = input.length - 1;
            while (i >= 0 && input[i] != 0) {
                builder.append(input[i] + " ");
                i--;
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
