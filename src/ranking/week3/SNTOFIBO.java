package DataStructureAndAlgorithms.AssignmentLT.spoj.week3;

import java.io.DataInputStream;
import java.io.IOException;

public class SNTOFIBO {
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
        Reader sc = new Reader();
        StringBuilder builder = new StringBuilder();
        int t = sc.nextInt();
        int x;
        for (int i = 0; i < t; i++) {
            x = sc.nextInt();
            builder.append(isFibonacci(x));
        }
        System.out.print(builder.toString());
    }

    // A utility method that returns true if x is perfect square
    public static  boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }
      
    // Returns true if n is a Fibonacci Number, else false
    public static String isFibonacci(int n) {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        if (isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4)) {
            return "YES\n";
        }
        return "NO\n";
    }

    // public static String isFibonacci(int x) {
    //     if (x == 2 || x == 3) {
    //         return "YES\n";
    //     }
    //     int first = 2;
    //     int second = 3;
    //     int temp = 5;
    //     while (temp < x) {
    //         temp = first + second;
    //         first = second;
    //         second = temp;
    //     }
    //     if (x == temp) {
    //         return "YES\n";
    //     }
    //     return "NO\n";
    // }
}

/*
 * Số nguyên tố Fibonacci

Thời gian: Không quá 2s

Bộ nhớ: Không quá 256MB

Đầu vào: Luồng nhập chuẩn

Đầu ra: Luồng xuất chuẩn

 

Số nguyên tố P được gọi là số nguyên tố Fibonacci nếu nó cũng là số Fibonacci. Cần lập trình xác định số nguyên tố P có phải là số nguyên tố Fibonacci hay không.

Dữ liệu vào: Dòng đầu tiên chứa một số nguyên T biểu thị số lượng test. Mỗi test gồm một dòng duy nhất chứa một số nguyên dương P là một số nguyên tố.

Dữ liệu ra: Với mỗi test, hiển thị trên một dòng xâu YES nếu số nguyên tố tương ứng là số Fibonacci, ngược lại đưa ra NO.

Ràng buộc

1 ≤ T ≤ 100

1 ≤ P ≤ 10000

Ví dụ:

Dữ liệu vào
	

Dữ liệu ra

3

2

5

11
	

YES

YES

NO
 */