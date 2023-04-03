package ranking.use_list.class_leader;

import java.io.DataInputStream;
import java.io.IOException;

public class Class_Leader {
    // public static void main(String[] args) throws IOException {
    //     Reader reader = new Reader();
    //     StringBuilder builder = new StringBuilder();
    //     int T = reader.nextInt();

    //     while (T-- > 0) {
    //         int n = reader.nextInt();
    //         int m = reader.nextInt();
    //         int o = reader.nextInt();
    //         int result = (Josephus(n, m, o) + m - 1) % n + 1;
    //         builder.append(result).append("\n");
    //     }

    //     System.out.print(builder.toString());
    //     //reader.close();
    // }

    // public static int Josephus(int n, int m, int o) {
    //     // Initialize variables i and ans with 1 and 0 respectively.
    //     int ans = 0;
    //     // Run a while loop till i <= n
    //     while (m <= n) {
    //         // Update the Value of ans and Increment i by 1
    //         ans = (ans + o) % m;
    //         m++;
    //     }
    //     ++ans;
    //     return ans;
    // }    

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

        // public Reader(String file_name) throws IOException {
        // din = new DataInputStream(
        // new FileInputStream(file_name));
        // buffer = new byte[BUFFER_SIZE];
        // bufferPointer = bytesRead = 0;
        // }

        // public String readLine() throws IOException {
        // byte[] buf = new byte[64]; // line length
        // int cnt = 0, c;
        // while ((c = read()) != -1) {
        // if (c == '\n') {
        // if (cnt != 0) {
        // break;
        // } else {
        // continue;
        // }
        // }
        // buf[cnt++] = (byte) c;
        // }
        // return new String(buf, 0, cnt);
        // }

        // public int[] readIntLine() throws IOException {
        // ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // int c;
        // while ((c = read()) != -1 && c != '\n') {
        // if (Character.isDigit(c)) {
        // buffer.write(c);
        // }
        // }
        // if (buffer.size() == 0 && c == -1) {
        // // Không còn dữ liệu để đọc
        // return null;
        // }
        // byte[] bytes = buffer.toByteArray();
        // int[] output = new int[bytes.length];
        // for (int i = 0; i < bytes.length; i++) {
        // output[i] = bytes[i] - '0';
        // }
        // return output;
        // }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            // boolean neg = (c == '-');
            // if (neg)
            //     c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            // if (neg)
            //     return -ret;
            return ret;
        }

        // public long nextLong() throws IOException {
        // long ret = 0;
        // byte c = read();
        // while (c <= ' ')
        // c = read();
        // boolean neg = (c == '-');
        // if (neg)
        // c = read();
        // do {
        // ret = ret * 10 + c - '0';
        // } while ((c = read()) >= '0' && c <= '9');
        // if (neg)
        // return -ret;
        // return ret;
        // }

        // public double nextDouble() throws IOException {
        // double ret = 0, div = 1;
        // byte c = read();
        // while (c <= ' ')
        // c = read();
        // boolean neg = (c == '-');
        // if (neg)
        // c = read();

        // do {
        // ret = ret * 10 + c - '0';
        // } while ((c = read()) >= '0' && c <= '9');

        // if (c == '.') {
        // while ((c = read()) >= '0' && c <= '9') {
        // ret += (c - '0') / (div *= 10);
        // }
        // }

        // if (neg)
        // return -ret;
        // return ret;
        // }

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

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
