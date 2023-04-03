package ranking.use_tree.ada_and_apple;

//import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.List;
import java.util.Set;

public class Ada_And_Apple {
    // static int n;
    static byte[] type;
    static ArrayList<Integer>[] adjList;
    // static boolean[] visited;
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        Reader reader = new Reader();
        int n = reader.nextInt();
        int q = reader.nextInt();

        // read the ownership
        type = new byte[n];
        for (int i = 0; i < n; i++) {
            type[i] = reader.read();
        }

        // read connection
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int numberConnection = n - 1;
        for (int i = 0; i < numberConnection; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // visited = new boolean[n];
        for (int i = 0; i < q; i++) {
            byte order = reader.read();
            if (order == 48) {
                int idx = reader.nextInt();
                updateType(idx);
            } else {
                int start = reader.nextInt();
                int end = reader.nextInt();
                boolean isConnected = bfs(start, end);
                if (isConnected) {
                    builder.append("YES\n");
                } else {
                    builder.append("NO\n");
                }
            }
        }
        System.out.print(builder.toString());
        // reader.close();
    }

    static void updateType(int idx) {
        if (type[idx] == 48) {
            type[idx] = 49;
            return;
        }
        type[idx] = 48;
    }

    static boolean bfs(int start, int end) {
        // clear the visited set
        visited.clear();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                return true;
            }
            for (int neighbor : adjList[current]) {
                if (!visited.contains(neighbor)) {
                    if (type[current] == type[neighbor]) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    // static boolean dfs(int start, int end) {
    // // clear the visited set
    // visited.clear();
    // return dfsHelper(start, end);
    // }

    // static boolean dfsHelper(int current, int end) {
    // visited.add(current);
    // if (current == end) {
    // return true;
    // }
    // for (int neighbor : adjList[current]) {
    // if (!visited.contains(neighbor)) {
    // if (type[current] == type[neighbor]) {
    // boolean isConnected = dfsHelper(neighbor, end);
    // if (isConnected) {
    // return true;
    // }
    // }
    // }
    // }
    // return false;
    // }

    // static boolean dfs(int start, int end) {
    // // make all element of visited be false
    // Arrays.fill(visited, false);
    // return dfsHelper(start, end);
    // }

    // static boolean dfsHelper(int current, int end) {
    // visited[current] = true;
    // if (current == end) {
    // return true;
    // }
    // for (int neighbor : adjList[current]) {
    // if (!visited[neighbor]) {
    // if (type[current] == type[neighbor]) {
    // boolean isConnected = dfsHelper(neighbor, end);
    // if (isConnected) {
    // return true;
    // }
    // }
    // }
    // }
    // return false;
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
            // c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            // if (neg)
            // return -ret;
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

        // public void close() throws IOException {
        // if (din == null)
        // return;
        // din.close();
        // }
    }
}
