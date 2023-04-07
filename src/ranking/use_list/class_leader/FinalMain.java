package ranking.use_list.class_leader;

import java.io.DataInputStream;
import java.io.IOException;

public class FinalMain {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();
        int T = reader.nextInt();
        int[][] ansInNormalProb = new int[1001][1001];
        for (int o = 1; o <= 1000; o++) {
            ansInNormalProb[o][1] = 1;
        }
        for (int o = 1; o <= 1000; o++) {
            for (int n = 2; n <= 1000; n++) {
                // (Josephus(n - 1, o) + o - 1) % n + 1;
                ansInNormalProb[o][n] = (ansInNormalProb[o][n - 1] + o - 1) % n + 1;
            }
        }
        while (T-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int o = reader.nextInt();
            int result = (ansInNormalProb[o][n] + m - 1) % n + 1;
            builder.append(result).append("\n");
        }

        System.out.print(builder.toString());
    }
    
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
}

// Java code to Implement Josephus Problem
// import java.io.DataInputStream;
// import java.io.IOException;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         Reader reader = new Reader();
//         StringBuilder builder = new StringBuilder();
//         int T = reader.nextInt();

//         while (T-- > 0) {
//             int n = reader.nextInt();
//             int m = reader.nextInt();
//             int o = reader.nextInt();
//             int ansInNormalProb = 0;
//             for (int i = 2; i <= n; i++) {
//                 ansInNormalProb = (ansInNormalProb + o) % i;
//             }
//             int result = (ansInNormalProb + m) % n + 1;
//             builder.append(result).append("\n");
//         }

//         System.out.print(builder.toString());
//     }

    