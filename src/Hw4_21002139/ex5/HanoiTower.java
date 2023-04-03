package Hw4_21002139.ex5;

import java.util.Scanner;
import java.util.Stack;

public class HanoiTower {
    public static int N;
    public static long step;
    /* Creating Stack array */
    public static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        /* Accepting number of disks */
        System.out.print("Enter number of disks: ");
        int num = scan.nextInt();
        N = num;
        hanoiTowerSolver(num);
        scan.close();
    }

    /* Function to push disks into stack */
    public static void hanoiTowerSolver(int n) {
        for (int d = n; d > 0; d--)
            tower[1].push(d);
        display(step);
        move(n, 1, 2, 3);
    }

    /* Recursive Function to move disks */
    public static void move(int n, int a, int b, int c) {
        if (n > 0) {
            move(n - 1, a, c, b);
            int d = tower[a].pop();
            tower[c].push(d);
            display(++step);
            move(n - 1, b, a, c);
        }
    }

    /* Function to display */
    public static void display(long step) {
        System.out.println("Step " + step + ": ");
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = N - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception e) {
            }
            try {
                d2 = String.valueOf(tower[2].get(i));
            }
            catch (Exception e) {
            }
            try {
                d3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("\n");
    }
}


// Normal use recursion only
// public class HanoiTower {
// public static void main(String[] args) {
// int nDisks = 2;
// doTowers(nDisks, 'A', 'B', 'C');
// }

// public static void doTowers(int topN, char from, char inter, char to) {
// if (topN == 1){
// System.out.println("Disk 1 from " + from + " to " + to);
// } else {
// doTowers(topN - 1, from, to, inter);
// System.out.println("Disk " + topN + " from " + from + " to " + to);
// doTowers(topN - 1, inter, from, to);
// }
// }
// }