package ranking.use_tree.ada_and_apple;

// Dưới đây là code Java cho ý tưởng trên,sử dụng thuật toán LCA để tiền xử lý đồ thị và ma trận kết quả để lưu trữ giá trị truy vấn:

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewMain {
    static int N, Q, logN;
    static int[] own;
    static int[][] parent, max;
    static List<Integer>[] adj;
    static int time;
    static int[] tin, tout;
    static int[] dp = new int[N];
    static int[] child = new int[N];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        N = sc.nextInt();
        Q = sc.nextInt();
        own = new int[N];
        adj = new List[N];
        for (int i = 0; i < N; i++) {
            own[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        logN = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
        parent = new int[N][logN + 1];
        max = new int[N][logN + 1];
        tin = new int[N];
        tout = new int[N];
        time = 0;
        dfs(0, -1, 0);
        preProcess();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();
            if (type == 0) {
                int idx = sc.nextInt();
                own[idx] ^= 1;
            } else {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int lca = LCA(u, v);
                int dist = pathLength(u, lca) + pathLength(v, lca);
                if (own[u] != own[v]) {
                    sb.append("NO\n");
                } else if (dist % 2 == 0) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    static void dfs(int node, int p, int depth) {
        int parent = p;
        int max = depth;
        for (int i = 0; i < adj[node].size(); i++) {
            int v = adj[node].get(i);
            if (v != p) {
                dfs(v, node, depth + 1);
                if (depth + 1 + dp[v] > max) {
                    max = depth + 1 + dp[v];
                    parent = v;
                }
            }
        }
        dp[node] = max - depth;
        if (parent != -1) {
            child[node] = parent;
        }
    }

    static void preProcess() {
        for (int i = 1; i <= logN; i++) {
            for (int j = 0; j < N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                max[j][i] = Math.max(max[j][i - 1], max[parent[j][i - 1]][i - 1]);
            }
        }
    }

    static int LCA(int u, int v) {
        if (isAncestor(u, v)) {
            return u;
        }
        if (isAncestor(v, u)) {
            return v;
        }
        for (int i = logN; i >= 0; i--) {
            if (!isAncestor(parent[u][i], v)) {
                u = parent[u][i];
            }
        }
        return parent[u][0];
    }

    static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    static int pathLength(int u, int v) {
        int maxVal = 0;
        if (u == v) {
            return 0;
        }
        for (int i = logN; i >= 0; i--) {
            if (!isAncestor(parent[u][i], v)) {
                maxVal = Math.max(maxVal, max[u][i]);
                u = parent[u][i];
            }
        }
        maxVal = Math.max(maxVal, max[u][0]);
        for (int i = logN; i >= 0; i--) {
            if (!isAncestor(parent[v][i], u)) {
                maxVal = Math.max(maxVal, max[v][i]);
                v = parent[v][i];
            }
        }
        maxVal = Math.max(maxVal, max[v][0]);
        return maxVal;
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