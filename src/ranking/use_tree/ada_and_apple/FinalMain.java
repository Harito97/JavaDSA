package ranking.use_tree.ada_and_apple;

import java.io.DataInputStream;
import java.io.IOException;

public class FinalMain {
    static int N; // số phần tử trong mảng
    static byte[] A; // mảng chứa thông tin về quyền sở hữu của từng quả táo
    static int[] tree; // Segment Tree
    static int[] lazy; // mảng lưu trữ thông tin về truy vấn loại 0 chưa được thực hiện
    static boolean[] changed; // mảng đánh dấu rằng cây đã bị thay đổi

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        N = sc.nextInt();

        A = new byte[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.read();
        }

        // Khởi tạo Segment Tree
        int treeSize = 4 * N;
        tree = new int[treeSize];
        lazy = new int[treeSize];
        changed = new boolean[treeSize];
        build(1, 1, N);

        int Q = sc.nextInt();
        while (Q-- > 0) {
            byte type = sc.read();
            if (type == 48) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                updateRange(1, 1, N, l, r);
            } else {
                int x = sc.nextInt();
                System.out.println(query(1, 1, N, x));
            }
        }
    }

    // Khởi tạo Segment Tree
    public static void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = (int) A[left];
            return;
        }

        int mid = (left + right) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // Thực hiện truy vấn trên cây
    public static int query(int node, int left, int right, int x) {
        if (changed[node]) {
            tree[node] += lazy[node] * (right - left + 1);

            if (left != right) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
                changed[node * 2] = true;
                changed[node * 2 + 1] = true;
            }

            lazy[node] = 0;
            changed[node] = false;
        }

        if (left == right && left == x) {
            return tree[node];
        }

        int mid = (left + right) / 2;
        int res = 0;
        if (x <= mid) {
            res += query(node * 2, left, mid, x);
        } else {
            res += query(node * 2 + 1, mid + 1, right, x);
        }

        return res;
    }

    public static void updateRange(int node, int left, int right, int l, int r) {
        if (changed[node]) {
            tree[node] += lazy[node] * (right - left + 1);

            if (left != right) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
                changed[node * 2] = true;
                changed[node * 2 + 1] = true;
            }

            lazy[node] = 0;
            changed[node] = false;
        }

        if (left > r || right < l) {
            return;
        }

        if (left >= l && right <= r) {
            tree[node] += (right - left + 1);
            if (left != right) {
                lazy[node * 2]++;
                lazy[node * 2 + 1]++;
                changed[node * 2] = true;
                changed[node * 2 + 1] = true;
            }
            return;
        }

        int mid = (left + right) / 2;
        updateRange(node * 2, left, mid, l, r);
        updateRange(node * 2 + 1, mid + 1, right, l, r);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
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
