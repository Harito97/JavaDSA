package ranking.use_tree.ada_and_apple;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static byte[] type;
    static StringBuilder builder = new StringBuilder();
    static Reader reader = new Reader();

    public static void main(String[] args) throws IOException {
        int n = reader.nextInt();
        int q = reader.nextInt();
        parent = new int[n];
        type = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            type[i] = reader.read();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            if (type[u] == type[v]) {
                union(u, v);
            }
        }
        while (q-- > 0) {
            byte order = reader.read();
            if (order == 49) {
                int u = reader.nextInt();
                int v = reader.nextInt();
                if (type[u] == type[v] && find(u) == find(v)) {
                    builder.append("YES\n");
                } else {
                    builder.append("NO\n");
                }
            } else {
                int x = reader.nextInt();
                type[x] ^= 1;
            }
        }
        System.out.print(builder);
    }

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu != pv) {
            parent[pu] = pv;
        }
    }

    static int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(parent[u]);
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
