package DataStructureAndAlgorithms.AssignmentLT.spoj;

//import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.io.DataInputStream;
import java.io.IOException;

public class ADAFRIEN {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int maxNumberDelete = reader.nextInt();

        HashMap<String, Long> friends = new HashMap<>();
        while (n-- > 0) {
            String[] line = reader.readLine().split(" ");
            String name = line[0];
            long expense = Long.parseLong(line[1].trim());
            friends.put(name, friends.getOrDefault(name, 0L) + expense);
        }

        // long sumOfTopKExpenses = friends.values()
        //         .stream()
        //         .sorted(Comparator.reverseOrder())
        //         .limit(maxNumberDelete)
        //         .mapToLong(Long::longValue)
        //         .sum();

        PriorityQueue<Long> topExpenses = new PriorityQueue<>(maxNumberDelete);
        for (long expense : friends.values()) {
            if (topExpenses.size() < maxNumberDelete) {
                topExpenses.add(expense);
            } else if (expense > topExpenses.peek()) {
                topExpenses.poll();
                topExpenses.add(expense);
            }
        }

        long sumOfTopKExpenses = 0;
        while (!topExpenses.isEmpty()) {
            sumOfTopKExpenses += topExpenses.poll();
        }
        System.out.println(sumOfTopKExpenses);
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
