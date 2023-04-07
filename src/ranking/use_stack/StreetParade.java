package ranking.use_stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        while (n != 0) {
            String[] trucksStr = reader.readLine().split(" ");
            int[] trucks = new int[n];
            for (int i = 0; i < n; i++) {
                trucks[i] = Integer.parseInt(trucksStr[i]);
            }
            writer.write(canBeReordered(trucks) ? "yes\n" : "no\n");
            n = Integer.parseInt(reader.readLine());
        }
        writer.flush();
    }

    public static boolean canBeReordered(int[] trucks) {
        Stack<Integer> sideStreet = new Stack<>();
        int currentTruck = 1;
        for (int truck : trucks) {
            while (!sideStreet.empty() && sideStreet.peek() == currentTruck) {
                sideStreet.pop();
                currentTruck++;
            }
            if (truck == currentTruck) {
                currentTruck++;
            } else {
                sideStreet.push(truck);
            }
        }
        while (!sideStreet.empty() && sideStreet.peek() == currentTruck) {
            sideStreet.pop();
            currentTruck++;
        }
        return sideStreet.empty();
    }
}