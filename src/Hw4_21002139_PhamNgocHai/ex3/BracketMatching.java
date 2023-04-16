package Hw4_21002139_PhamNgocHai.ex3;

import java.util.ArrayList;

import Hw4_21002139_PhamNgocHai.ex1.ArrayStack;
import Hw4_21002139_PhamNgocHai.ex1.StackInterface;

public class BracketMatching {
    public static void bracketMatching(String expression) {
        expression = expression.replaceAll("\\s", "");
        if (isBracketMatching(expression)) {
            System.out.print("A bracket matching! \nAnd ");
            System.out.print(expression + " = " + resultOfExpression(toArrayExpression(expression)) + "\n");
        } else {
            System.out.println("Not a bracket matching!");
        }
    }

    private static double resultOfExpression(ArrayList<String> expression) {
        StackInterface<Double> values = new ArrayStack<>();
        StackInterface<String> operators = new ArrayStack<>();

        for (String token : expression) {
            if (token.equals("(") || token.equals("")) {
                // do nothing
            } else if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                operators.push(token);
            } else if (token.equals(")")) {
                double value2 = values.pop();
                double value1 = values.pop();
                String operator = operators.pop();
                double result = 0;
                switch (operator) {
                    case "+":
                        result = value1 + value2;
                        break;
                    case "-":
                        result = value1 - value2;
                        break;
                    case "*":
                        result = value1 * value2;
                        break;
                    case "/":
                        if (value2 == 0)
                            throw new IllegalArgumentException("Cannot divide by zero");
                        result = value1 / value2;
                        break;
                }
                values.push(result);
            } else {
                values.push(Double.parseDouble(token));
            }
        }
        return values.pop();
    }

    private static ArrayList<String> toArrayExpression(String expression) {
        // Phân tách data ra ký tự bracket matching với các toán tử và các con số
        char temp;
        ArrayList<String> arrayExpression = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            temp = expression.charAt(i);
            if (temp == '(' || temp == ')' ||
                    temp == '+' || temp == '-' ||
                    temp == '*' || temp == '/') {
                arrayExpression.add("" + temp);
            } else if (temp == '[' || temp == '{') {
                arrayExpression.add("(");
                // Có thể làm thế này được mà vẫn đảm bảo tính tương ứng ngoặc
                // vì mặc định đã kiểm tra tính hợp lệ của các cặp ngoặc () {} [] tương ứng
                // bằng cách sử dụng hàm isBracketMatching
            } else if (temp == ']' || temp == '}') {
                arrayExpression.add(")");
                // Có thể làm thế này được mà vẫn đảm bảo tính tương ứng ngoặc
                // vì mặc định đã kiểm tra tính hợp lệ của các cặp ngoặc () {} [] tương ứng
                // bằng cách sử dụng hàm isBracketMatching
            } else {
                String strNumber = "";
                while (Character.isDigit(temp) || temp == '.') {
                    strNumber += temp;
                    ++i;
                    temp = expression.charAt(i);
                }
                arrayExpression.add(strNumber);
                if (temp == '(' || temp == ')' ||
                        temp == '+' || temp == '-' ||
                        temp == '*' || temp == '/') {
                    arrayExpression.add("" + temp);
                } else if (temp == '[' || temp == '{') {
                    arrayExpression.add("(");
                    // Có thể làm thế này được mà vẫn đảm bảo tính tương ứng ngoặc
                    // vì mặc định đã kiểm tra tính hợp lệ của các cặp ngoặc () {} [] tương ứng
                    // bằng cách sử dụng hàm isBracketMatching
                } else if (temp == ']' || temp == '}') {
                    arrayExpression.add(")");
                    // Có thể làm thế này được mà vẫn đảm bảo tính tương ứng ngoặc
                    // vì mặc định đã kiểm tra tính hợp lệ của các cặp ngoặc () {} [] tương ứng
                    // bằng cách sử dụng hàm isBracketMatching
                }
            }
        }
        // Bây giờ chúng ta đã có 1 mảng String gồm 3 thành phần or là toán tử or là số
        // or là dấu bracket matching
        return arrayExpression;
    }

    private static boolean isBracketMatching(String expression) {
        StackInterface<Character> stack = new ArrayStack<>();
        for (int i = 0; i < expression.length(); i++) {
            char charIndex = expression.charAt(i);
            if (charIndex == '(' || charIndex == '[' || charIndex == '{') {
                stack.push(charIndex);
                continue;
            }

            if (!stack.isEmpty() && ((charIndex == ')' && stack.top() == '(') ||
                    (charIndex == '}' && stack.top() == '{') ||
                    (charIndex == ']' && stack.top() == '['))) {
                stack.pop();
                continue;
            }

            if (charIndex == ')' || charIndex == ']' || charIndex == '}') {
                stack.push(charIndex);
                continue;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    // public static void main(String[] args) {
    //     String expression = "(5+45)*(9-3)";
    //     ArrayList<String> realExpression = toArrayExpression(expression);
    //     for (int i = 0; i < realExpression.size(); i++) {
    //         System.out.print(realExpression.get(i) + "|");
    //     }
    //     System.out.println();
    // }
}
