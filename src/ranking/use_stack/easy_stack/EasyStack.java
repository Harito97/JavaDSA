package ranking.use_stack.easy_stack;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class EasyStack {
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
        // long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // long start = System.nanoTime();
        // System.out.println("Time start: " + start + "ns");
        // Reader reader = new Reader("6 1 15 1 20 2 3 2 3");
        
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); 
        int t = reader.nextInt();
        int code = 0;
        boolean test;
        while (t-- > 0) {
            code = reader.nextInt();
            if (code == 1) {
                stack.push(reader.nextInt());
            } else {
                test = stack.empty();
                if (code == 3 && !test) {
                    builder.append(stack.peek()).append("\n");
                } else if (code == 3 && test) {
                    builder.append("Empty!\n");
                } else if (code == 2 && !test) {
                    stack.pop();
                } 
            } 
        }
        System.out.print(builder.toString());
        
        // long end = System.nanoTime();
        // System.out.println("Time end: " + end + "ns");
        // System.out.println("Time took: " + (end - start)/(1000000000.0) + "s");
        // long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // long actualMemUsed = afterUsedMem - beforeUsedMem;
        // System.out.println("ActualMemUsed: " + actualMemUsed + " bytes = " + actualMemUsed/1048576.0 + " MB");
    }
}

            // if (code == 1) {
            //     stack.push(reader.nextInt());
            // } else {
            //     test = stack.empty();
            //     if (code == 2 && !test) {
            //         stack.pop();
            //     } else if (code == 3) {
            //         if (test) {
            //             builder.append("Empty!\n");
            //         } else {
            //             builder.append(stack.peek()).append("\n");
            //         }
            //     }
            // }

            // switch (code) {
            //     case 1:
            //         stack.push(reader.nextInt());
            //         break;
            //     case 2:
            //         stack.pop();
            //         break;
            //     case 3:
            //         if (stack.empty()) {
            //             builder.append("Empty!\n");
            //             break;
            //         }
            //         builder.append(stack.peek()).append("\n");
            //         break;
            //     default:
            //         break;
            // } 

/* Bạn có một ngăn xếp trống và bạn được cung cấp một số truy vấn. 
Các truy vấn này là các thao tác ngăn xếp cơ bản như Push, Pop và in phần tử Top. 
Bây giờ, bạn nên xử lý các truy vấn đã cho.

Input:
Dòng đầu tiên chứa số nguyên T (0 <= T <= 10^6).
Mỗi T dòng tiếp theo chứa một truy vấn dựa trên các định dạng này.
1 n : Đẩy n (0 < n <= 10^9) lên đầu ngăn xếp.
2 : Lấy một phần tử từ trên cùng của ngăn xếp. Nếu ngăn xếp trống, không làm gì cả.
3 : In phần tử trên cùng của ngăn xếp (xem Định dạng đầu ra).

Output:
Đối với mỗi truy vấn 3, hãy in phần tử trên cùng của ngăn xếp. 
Nếu ngăn xếp trống, hãy in 'Empty!' không có dấu ngoặc kép. 

Eg:
Input:
6
1 15
1 20
2
3
2
3

Output:
15
Empty! */
