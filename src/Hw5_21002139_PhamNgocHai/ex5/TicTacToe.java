package Hw5_21002139_PhamNgocHai.ex5;

import java.util.Scanner;

/**
 * Viết một chương trình có thể chơi Tic-Tac-Toe một cách hiệu quả. (Xem phần
 * 3.1.5.) Để làm được điều này, bạn sẽ cần tạo ra một cây trò chơi T, đó là một
 * cây mà mỗi vị trí tương ứng với một cấu hình trò chơi, trong trường hợp này
 * là một biểu diễn của bảng Tic-Tac-Toe. (Xem phần 8.4.2.) Gốc tương ứng với
 * cấu hình ban đầu. Đối với mỗi vị trí nội bộ p trong T, các con của p tương
 * ứng với các trạng thái trò chơi mà chúng ta có thể đạt được từ trạng thái trò
 * chơi của p trong một nước đi hợp lệ đối với người chơi phù hợp, A (người chơi
 * đầu tiên) hoặc B (người chơi thứ hai). Các vị trí ở độ sâu chẵn tương ứng với
 * các nước đi của A và các vị trí ở độ sâu lẻ tương ứng với các nước đi của B.
 * Các lá là trạng thái trò chơi cuối cùng hoặc ở độ sâu vượt quá mà chúng ta
 * không muốn khám phá. Chúng tôi ghi điểm cho mỗi lá với một giá trị cho biết
 * trạng thái này tốt đối với người chơi A. Trong các trò chơi lớn, như cờ vua,
 * chúng ta phải sử dụng một hàm điểm houris-tic, nhưng đối với các trò chơi
 * nhỏ, như Tic-Tac-Toe, chúng ta có thể xây dựng toàn bộ cây trò chơi và ghi
 * điểm cho lá là +1, 0, -1, cho biết liệu người chơi A có chiến thắng, hòa hoặc
 * thua trong cấu hình đó. Một thuật toán tốt để lựa chọn các nước đi là
 * minimax. Trong thuật toán này, chúng ta gán một điểm số cho mỗi vị trí nội bộ
 * p trong T, sao cho nếu p đại diện cho lượt chơi của A, chúng ta tính điểm số
 * của p là điểm số lớn nhất của các con của p (tương ứng với lượt chơi tối ưu
 * của A từ p). Nếu một nút nội bộ p đại diện cho lượt chơi của B, chúng ta tính
 * điểm số của p là điểm số nhỏ nhất của các con của p (tương ứng với lượt chơi
 * tối ưu của B từ p).
 * 
 */
public class TicTacToe {
    private char[][] board;
    private static final int SIZE = 3;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = ' ';

    public TicTacToe() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public int evaluate(char player) {
        if (isWinner(player)) {
            return 1;
        }
        if (isWinner(getOpponent(player))) {
            return -1;
        }
        return 0;
    }

    public char getOpponent(char player) {
        return player == PLAYER_X ? PLAYER_O : PLAYER_X;
    }

    public int minimax(char player, int depth) {
        if (isWinner(PLAYER_X)) {
            return 1;
        }
        if (isWinner(PLAYER_O)) {
            return -1;
        }
        if (isFull()) {
            return 0;
        }
        if (player == PLAYER_X) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_X;
                        int score = minimax(PLAYER_O, depth + 1);
                        board[i][j] = EMPTY;
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_O;
                        int score = minimax(PLAYER_X, depth + 1);
                        board[i][j] = EMPTY;
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    public void play() {
        char currentPlayer = PLAYER_X;
        while (!isFull() && !isWinner(PLAYER_X) && !isWinner(PLAYER_O)) {
            if (currentPlayer == PLAYER_X) {
                int bestScore = Integer.MIN_VALUE;
                int row = -1;
                int col = -1;
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (board[i][j] == EMPTY) {
                            board[i][j] = PLAYER_X;
                            int score = minimax(PLAYER_O, 0);
                            board[i][j] = EMPTY;
                            if (score > bestScore) {
                                bestScore = score;
                                row = i;
                                col = j;
                            }
                        }
                    }
                }
                board[row][col] = PLAYER_X;
                currentPlayer = PLAYER_O;
            } else {
                System.out.println(
                        "Player O's turn. Enter row and column (separated by space) \n(Eg: 0 1 vs 0 is row and 1 is column): ");
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                while (board[row][col] != EMPTY) {
                    System.out.println(
                            "Invalid move. Enter row and column (separated by space) \n(Eg: 0 1 vs 0 is row and 1 is column): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                }
                board[row][col] = PLAYER_O;
                currentPlayer = PLAYER_X;
                scanner.close();
            }
            printBoard();
        }
        if (isWinner(PLAYER_X)) {
            System.out.println("Player X wins!");
        } else if (isWinner(PLAYER_O)) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}