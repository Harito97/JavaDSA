package Hw5_21002139_PhamNgocHai.ex3;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Stack;
import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;
import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree.Node;

public class BuildTreeExpression {
    public static ArrayList<String> infixToPostfix(String expression) {
        // input data processing
        /*
         * sử dụng regex để tách các phần tử trong biểu thức dựa trên các ký tự toán học
         * (+, -, *, /) và các ký tự ngoặc đơn ((), {}). Sau đó sử dụng phương thức
         * split để tách chuỗi thành các phần tử.
         */
        /*
         * biểu thức chính quy được chia thành hai phần bằng dấu |.
         * Phần đầu tiên (?<=[()+\-* /^]) sử dụng positive lookbehind để tìm các vị trí
         * có một trong các ký tự ()+\-* /^ ở phía trước. Phần thứ hai (?=[()+\-* /^]) sử
         * dụng positive lookahead để tìm các vị trí có một trong các ký tự ()+\-* /^ ở
         * phía sau.
         */
        String[] tokens = expression.replaceAll(" ", "").split("((?<=[()+\\-*/^])|(?=[()+\\-*/^]))");
        // System.out.println(Arrays.toString(tokens)); // debug is tokens work like expected

        // build result
        /*
         * Thuật toán chuyển từ dạng trung tố sang dạng hậu tố:
         * Đọc từng token trong biểu thức infix từ trái qua phải, với mỗi token ta thực
         * hiện các bước sau:
         * - Nếu là toán hạng: cho ra output reverse.
         * - Nếu là dấu mở ngoặc “(“: cho vào stack temp.
         * - Nếu là dấu đóng ngoặc “)”: lấy các toán tử trong stack temp ra và cho vào
         * output reverse cho đến khi gặp dấu mở ngoặc “(“. Dấu mở ngoặc cũng phải được
         * đưa ra khỏi stack temp.
         * - Nếu là toán tử:
         * • Chừng nào ở đỉnh stack temp là toán tử và toán tử đó có độ ưu tiên lớn hơn
         * hoặc
         * bằng toán tử hiện tại thì lấy toán tử đó ra khỏi stack temp và cho ra output
         * reverse.
         * • Đưa toán tử hiện tại vào stack temp.
         * 
         * Sau khi duyệt hết biểu thức infix, nếu trong stack temp còn phần tử thì lấy
         * các token trong đó ra và cho lần lượt vào output reverse. Cuối cùng là đảo
         * ngược biểu thức một lần nữa và ta sẽ thu được kết quả postfixExpression.
         */
        Stack<String> temp = new Stack<>();
        ArrayList<String> infixToPostfix = new ArrayList<>();
        for (String x : tokens) {
            if (x.equals("(")) {
                temp.push(x);
            } else if (x.equals(")")) {
                while (!temp.peek().equals("(")) {
                    infixToPostfix.add(temp.pop());
                }
                temp.pop();
            } else if (isOperator(x) != -1) {
                while (!temp.isEmpty() && isOperator(temp.peek()) != -1
                        && (isOperator(temp.peek()) >= isOperator(x))) {
                    infixToPostfix.add(temp.pop());
                }
                temp.push(x);
            } else {
                // là toán hạng: cho ra output infixToPostfix.
                infixToPostfix.add(x);
            }
        }

        while (!temp.isEmpty()) {
            infixToPostfix.add(temp.pop());
        }

        return infixToPostfix;
    }

    private static int isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        if (operator.equals("^")) {
            return 3;
        }
        return -1;
    }

    public static LinkedBinaryTree<String> buildTreeExpression(String expression) {
        /*
         * Lặp qua từng token trong chuỗi hậu tố
         * - Tạo một đối tượng BinaryTreeNode nhãn của node là token này
         * - Nếu là toán hạng: Push node vào stack
         * - Nếu là toán tử:
         * • Pop một toán hạng ra khỏi stack và đặt làm RightChild của node
         * • Pop toán hạng kế tiếp ra khỏi stack và đặt làm LeftChild của node
         * • Push node vào stack
         * Sau khi vòng lặp kết thúc, phần tử cuối cùng còn lại trong stack là node gốc
         * của cây biểu thức.
         */
        ArrayList<String> postfixExpression = infixToPostfix(expression);
        Stack<Node<String>> temp = new Stack<>();
        for (String x : postfixExpression) {
            if (isOperator(x) == -1) {
                Node<String> newNode = new Node<>();
                newNode.setElement(x);
                temp.push(newNode);
            } else {
                Node<String> newNode = new Node<>();
                newNode.setElement(x);
                newNode.setRight(temp.pop());
                newNode.setLeft(temp.pop());
                temp.push(newNode);
            }
        }
        return new LinkedBinaryTree<String>(temp.pop());
    }
}
