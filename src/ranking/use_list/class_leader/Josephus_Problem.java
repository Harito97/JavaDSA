package ranking.use_list.class_leader;

import java.io.DataInputStream;
import java.io.IOException;

public class Josephus_Problem {
    public static void main(String[] args) throws IOException {
    //     Reader reader = new Reader();
    //     StringBuilder builder = new StringBuilder();
    //     int T = reader.nextInt();

    //     while (T-- > 0) {
    //         int n = reader.nextInt();
    //         int m = reader.nextInt();
    //         int o = reader.nextInt();

    //         if (n == 1) {
    //             builder.append(1).append("\n");
    //             continue;
    //         }

    //         // Create a circle of people
    //         CircularLinkedList list = new CircularLinkedList();
    //         Node playerWillTakeFlagEachRow;

    //         if (m == 1) {
    //             for (int i = 1; i <= n; i++) {
    //                 list.addNode(i);
    //             }
    //             playerWillTakeFlagEachRow = list.head;
    //         } else {
    //             for (int i = 1; i <= m; i++) {
    //                 list.addNode(i);
    //             }
    //             playerWillTakeFlagEachRow = list.tail;

    //             for (int i = m + 1; i <= n; i++) {
    //                 list.addNode(i);
    //             }
    //         }

    //         // start to delete player after each row
    //         while (playerWillTakeFlagEachRow.nextNode != playerWillTakeFlagEachRow.previousNode) {
    //             for (int i = 0; i < o; i++) {
    //                 playerWillTakeFlagEachRow = playerWillTakeFlagEachRow.nextNode;
    //             }
    //             // delete player in row
    //             playerWillTakeFlagEachRow.previousNode.nextNode = playerWillTakeFlagEachRow.nextNode;
    //             playerWillTakeFlagEachRow = playerWillTakeFlagEachRow.previousNode;
    //         }
    //         builder.append(playerWillTakeFlagEachRow.value).append("\n");
    //     }
    //     System.out.println(builder.toString());
    //     reader.close();
    // }

    // static class Node {
    //     int value;
    //     Node nextNode;
    //     Node previousNode;

    //     public Node(int value) {
    //         this.value = value;
    //     }
    // }

    // static class CircularLinkedList {
    //     private Node head = null;
    //     private Node tail = null;

    //     public void addNode(int value) {
    //         Node newNode = new Node(value);

    //         if (head == null) {
    //             head = newNode;
    //         } else {
    //             newNode.previousNode = tail;
    //             tail.nextNode = newNode;
    //         }

    //         tail = newNode;
    //         tail.nextNode = head;
    //         head.previousNode = tail;
    //     }

        // public boolean containsNode(int searchValue) {
        // Node currentNode = head;

        // if (head == null) {
        // return false;
        // } else {
        // do {
        // if (currentNode.value == searchValue) {
        // return true;
        // }
        // currentNode = currentNode.nextNode;
        // } while (currentNode != head);
        // return false;
        // }
        // }

        // public void deleteNode(int valueToDelete) {
        // Node currentNode = head;
        // if (head == null) { // the list is empty
        // return;
        // }
        // do {
        // Node nextNode = currentNode.nextNode;
        // if (nextNode.value == valueToDelete) {
        // if (tail == head) { // the list has only one single element
        // head = null;
        // tail = null;
        // } else {
        // currentNode.nextNode = nextNode.nextNode;
        // if (head == nextNode) { // we're deleting the head
        // head = head.nextNode;
        // }
        // if (tail == nextNode) { // we're deleting the tail
        // tail = currentNode;
        // }
        // }
        // break;
        // }
        // currentNode = nextNode;
        // } while (currentNode != head);
        // }
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