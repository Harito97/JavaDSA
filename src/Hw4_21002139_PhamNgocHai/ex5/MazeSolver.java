package Hw4_21002139_PhamNgocHai.ex5;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class MazeSolver {
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public static boolean isValid(int[][] maze, boolean[][] visited,
            int row, int col) {
        return (row >= 0) && (row < maze.length)
                && (col >= 0) && (col < maze[0].length)
                && ((maze[row][col] == 1)
                        || (maze[row][col] == 3))
                && !visited[row][col];
    }

    public static void BFS(int[][] maze, int i, int j,
            int x, int y) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        // q work like a queue
        Queue<Point> q = new LinkedList<>();

        visited[i][j] = true;
        q.add(new Point(i, j, 0));

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();

            if (currentPoint.x == x && currentPoint.y == y) {
                System.out.println("\nThe path includes " + currentPoint.dist + " steps");
                System.out.println(
                        "\nHere is a part of maze and path (other be hided may be as program find the X point and don't search anymore) : ");
                for (int row = 0; row < visited.length; row++) {
                    for (int colum = 0; colum < visited[0].length; colum++) {
                        if (maze[row][colum] == 2) {
                            System.out.print(" O ");
                            continue;
                        }
                        if (maze[row][colum] == 3) {
                            System.out.print(" X ");
                            continue;
                        }
                        if (visited[row][colum]) {
                            System.out.print(" . ");
                            continue;
                        }
                        System.out.print("   ");
                    }
                    System.out.println();
                }
                System.out.println("\nWith:\n    o is start point\n    . is cell can go\n    X is end points\n");
                return;
            }

            // search 4 possible ways in each cell
            for (int k = 0; k < 4; k++) {
                if (isValid(maze, visited, currentPoint.x + row[k],
                        currentPoint.y + col[k])) {

                    visited[currentPoint.x + row[k]][currentPoint.y + col[k]] = true;

                    Point adjCell = new Point(currentPoint.x + row[k],
                            currentPoint.y + col[k],
                            currentPoint.dist + 1);

                    q.add(adjCell);
                }
            }
        }
        System.out.println("Path not found");
    }

    public static void main(String[] args) {
        char[][] inputMaze = {
                { '@', '1', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '1', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '0', '#' } };

        // convert inputMaze to integer matrix for processing
        // find starting and ending points in the process

        int[][] maze = new int[inputMaze.length][inputMaze[0].length];
        int startX = -2, startY = -2, endX = -3, endY = -3;

        for (int i = 0; i < inputMaze.length; i++) {
            for (int j = 0; j < inputMaze[i].length; j++) {
                if (inputMaze[i][j] == '@') {
                    startX = i;
                    startY = j;
                    maze[i][j] = 2;
                } else if (inputMaze[i][j] == '#') {
                    endX = i;
                    endY = j;
                    maze[i][j] = 3;
                } else {
                    maze[i][j] = Character.getNumericValue(inputMaze[i][j]);
                }
            }
        }

        BFS(maze, startX, startY, endX, endY);
    }
}