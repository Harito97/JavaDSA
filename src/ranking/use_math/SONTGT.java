package ranking.use_math;

import java.io.DataInputStream;
import java.io.IOException;

public class SONTGT {
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
        int p = 0;
        for (int i = 0; i < t; i++) {
            p = sc.nextInt();
            builder.append(isFactorialPrime(p));
        }
        System.out.print(builder.toString());
    }

    public static String isFactorialPrime(int p) {
        int factorial = 1;
        for (int i = 2; i <= p; i++) {
            factorial *= i;
            if (p == factorial || p == factorial - 1 || p == factorial + 1) {
                return "YES\n";
            }
        }
        return "NO\n";
    }
}

/*
 * Số nguyên tố giai thừa

Thời gian: Không quá 2s

Bộ nhớ: Không quá 256MB

Đầu vào: Luồng nhập chuẩn

Đầu ra: Luồng xuất chuẩn

 

Số nguyên tố giai thừa (factorial prime) là một số nguyên tố nhỏ hơn hoặc lớn hơn một so với một giai thừa hoặc chính nó là một giai thừa. Một vài số nguyên tố giai thừa là: 2, 3, 5,..

Cần lập trình kiểm tra xem một số nguyên tố có phải số nguyên tố giai thừa hay không.

Dữ liệu vào: Dòng đầu tiên chứa một số nguyên T  biểu thị số lượng test. Mỗi test gồm một dòng duy nhất chứa một số nguyên dương P là một số nguyên tố.

Dữ liệu ra: Với mỗi test, hiển thị trên một dòng xâu YES nếu số nguyên tố tương ứng là số nguyên tố giai thừa, ngược lại đưa ra NO.

Ràng buộc

1 ≤ T ≤ 100

1 ≤ P ≤ 10000

Ví dụ:

Dữ liệu vào
	

Dữ liệu ra

3

2

3

11
	

YES

YES

NO
 */