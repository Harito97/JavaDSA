package ranking.use_tree.ada_and_apple;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class NewIdea {
    static byte[] type;
    static ArrayList<Integer>[] adjList;
    static StringBuilder builder = new StringBuilder();
    static Reader reader = new Reader();
    static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    static Set<Integer> keys;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        int n = reader.nextInt();
        int q = reader.nextInt();

        // read the ownership & read connection
        adjList = new ArrayList[n];
        type = new byte[n];
        for (int i = 0; i < n; i++) {
            type[i] = reader.read();
            adjList[i] = new ArrayList<>();
        }

        int numberConnection = n - 1;
        for (int i = 0; i < numberConnection; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            // it seems to be that u < v in all case of test
            adjList[u].add(v);
        }

        buildMap(n);

        while (q-- > 0) {
            byte order = reader.read();
            if (order == 49) {
                int firstPoint = reader.nextInt();
                int secondPoint = reader.nextInt();
                checkCanGo(builder, keys, firstPoint, secondPoint);
            } else {
                int pointChange = reader.nextInt();
                if (type[pointChange] == 48) {
                    type[pointChange] = 49;
                } else {
                    type[pointChange] = 48;
                }
                //map = new TreeMap<>();
                updateMap(n, pointChange);
            }
        }

        System.out.print(builder.toString());
    }

    // function to know map - all set of point can go each other
    private static void buildMap(int numPoint) {
        int numberOfPointChecked = 0;
        while (numberOfPointChecked < numPoint) {
            if (map.containsKey(numberOfPointChecked)) {
                numberOfPointChecked++;
                continue;
            }
            byte newByCode = type[numberOfPointChecked];
            ArrayList<Integer> newValue = new ArrayList<>();
            newValue.add(numberOfPointChecked);
            pointReturn(newValue, new HashSet<>(), numberOfPointChecked, newByCode);
            map.put(numberOfPointChecked, newValue);
        }
        keys = map.keySet();
    }

    private static void pointReturn(ArrayList<Integer> result,
            HashSet<Integer> pointChecked,
            int point, byte typeOfPoint) {
        pointChecked.add(point);
        for (int x : adjList[point]) {
            if (type[x] == typeOfPoint && !pointChecked.contains(x)) {
                result.add(x);
                pointReturn(result, pointChecked, x, typeOfPoint);
            }
        }
        pointChecked.remove(point);
    }

    // ham de quy de tra ve list cac dinh co the di toi
    // private static void pointReturn(ArrayList<Integer> result,
    //         HashSet<Integer> pointChecked,
    //         int point, byte typeOfPoint) {
    //     if (adjList[point].isEmpty()) {
    //         return;
    //     }
    //     for (int x : adjList[point]) {
    //         if (type[x] == typeOfPoint && !pointChecked.contains(x)) {
    //             result.add(x);
    //             pointChecked.add(x);
    //             pointReturn(result, pointChecked, x, typeOfPoint);
    //         }
    //     }
    // }

    private static void updateMap(int numPoint, int pointChange) {
        byte newByCode = type[pointChange];
        ArrayList<Integer> newValue = new ArrayList<>();
        newValue.add(pointChange);
        pointReturn(newValue, new HashSet<>(), pointChange, newByCode);
        map.put(pointChange, newValue);
        for (int x : adjList[pointChange]) {
            if (type[x] == newByCode) {
                ArrayList<Integer> list = map.get(x);
                if (list.contains(pointChange)) {
                    list.remove(Integer.valueOf(pointChange));
                }
                if (newValue.contains(x)) {
                    newValue.remove(Integer.valueOf(x));
                }
                list.addAll(newValue);
                map.put(x, list);
            }
        }
        keys = map.keySet();
    }
    // private static void updateMap(int numPoint, int pointChange) {
    //     byte newByCode = type[pointChange];
    //     ArrayList<Integer> newValue = new ArrayList<>();
    //     newValue.add(pointChange);
    //     pointReturn(newValue, new HashSet<>(), pointChange, newByCode);
    //     map.put(pointChange, newValue);
    //     for (int x : adjList[pointChange]) {
    //         if (type[x] == newByCode) {
    //             ArrayList<Integer> list = map.get(x);
    //             if (list.contains(pointChange)) {
    //                 list.remove(Integer.valueOf(pointChange));
    //             }
    //             if (newValue.contains(x)) {
    //                 newValue.remove(Integer.valueOf(x));
    //             }
    //             list.addAll(newValue);
    //             map.put(x, list);
    //         }
    //     }
    //     keys = map.keySet();
    // }

    // function to check 2 point can go to each other
    private static void checkCanGo(StringBuilder builder, Set<Integer> keys,
            int firstPoint, int secondPoint) {
        if (type[firstPoint] != type[secondPoint]) {
            builder.append("NO\n");
            return;
        }
        for (int key : keys) {
            ArrayList<Integer> check = map.get(key);
            if (check.contains(firstPoint) && check.contains(secondPoint)) {
                builder.append("YES\n");
                return;
            }
        }
        builder.append("NO\n");
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
