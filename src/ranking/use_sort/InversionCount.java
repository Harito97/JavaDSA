package ranking.use_sort;

import java.io.DataInputStream;
import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;

public class InversionCount {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();
        int numberTest = reader.nextInt(); //Integer.parseInt(reader.readLine());
        //reader.readLine();

        // Read data & processing
        while (numberTest-- > 0) {
            int n = reader.nextInt(); //Integer.parseInt(reader.readLine());
            int[] data = new int[n];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = reader.nextInt(); //Integer.parseInt(reader.readLine());
            }
            //reader.readLine();
            builder.append(mergeSort(data, temp, 0, n - 1)).append("\n");
        }

        // Print output
        System.out.print(builder.toString());
    }

    public static long mergeSort(int arr[], int temp[], int left, int right) {
        int mid;
        long inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count += mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    public static long merge(int arr[], int temp[], int left,
            int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        long inv_count = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
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

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
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
}

/*
 * INVCNT - Số lần đảo ngược
 * 
 * Cho A[0...n - 1] là một dãy gồm n số nguyên dương phân biệt. Nếu i < j và
 * A[i] > A[j] thì cặp (i, j) được gọi là một nghịch đảo của A. Cho n và một
 * mảng A, nhiệm vụ của bạn là tìm số nghịch đảo của A.
 * 
 * Đầu vào
 * 
 * Dòng đầu tiên chứa t, số lượng testcase theo sau là khoảng trống. Mỗi t bài
 * kiểm tra bắt đầu bằng một số n (n <= 200000). Sau đó n + 1 dòng tiếp theo. Ở
 * dòng thứ i ghi một số A[i - 1] (A[i - 1] <= 10^7). Dòng thứ (n + 1) là khoảng
 * trống.
 * 
 * Đầu ra
 * 
 * Đối với mỗi đầu ra thử nghiệm, một dòng cho biết số lần nghịch đảo của A.
 * 
 * Ví dụ
 * 
 * Đầu vào:
 * 2
 * 
 * 3
 * 3
 * 1
 * 2
 * 
 * 5
 * 2
 * 3
 * 8
 * 6
 * 1
 * 
 * 
 * Đầu ra:
 * 2
 * 5
 */
