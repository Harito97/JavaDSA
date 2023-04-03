package DataStructureAndAlgorithms.AssignmentLT.spoj.week3;

import java.io.DataInputStream;
import java.io.IOException;
// import java.time.Duration;
// import java.time.Instant;
// import java.util.Scanner;

public class SLPLN {
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
        //Instant start = Instant.now();
        //Scanner sc = new Scanner("3 100 40 30");
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();
        int t = reader.nextInt();
        int n;
        for (int i = 0; i < t; i++) {
            n = reader.nextInt();
            builder.append((int) Math.pow(n, 1/3.0)).append("\n");
        }
        System.out.println(builder.toString());
        //sc.close();
        // Instant end = Instant.now();
        // System.out.println(Duration.between(start, end));
    }
}

/*
 * Số lập phương

Thời gian: Không quá 2s

Bộ nhớ: Không quá 256MB

Đầu vào: Luồng nhập chuẩn

Đầu ra: Luồng xuất chuẩn

 

Cần lập trình đưa ra số lớn nhất có lập phương không vượt quá số nguyên dương N.

Dữ liệu vào: Dòng đầu tiên chứa một số nguyên T  biểu thị số lượng test. Mỗi test gồm một dòng duy nhất chứa một số nguyên dương N.

Dữ liệu ra: Với mỗi test, hiển thị trên một dòng số lớn nhất có lập phương không vượt quá số N tương ứng

Ràng buộc

1 ≤ T ≤ 100

1 ≤ N ≤ 10000

Ví dụ:

Dữ liệu vào
	

Dữ liệu ra

3

100

40

30
	

4

3

3
 */