package Hw5_21002139_PhamNgocHai.ex3;

import java.util.ArrayList;
import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;

public class TestBuildTreeExpression {
    public static void main(String[] args) {
        String expression = "(65.4/3.0 + (8/4.0 - 5))";
        expression = "(6/2 + 3) * (7 - 4)";
        ArrayList<String> result = BuildTreeExpression.infixToPostfix(expression);
        System.out.println(result.toString()); // print [6, 2, /, 3, +, 7, 4, -, *]

        LinkedBinaryTree<String> tree = BuildTreeExpression.buildTreeExpression(expression);
        System.out.println(tree.toString()); // print | * | + | / | 6 | 2 | 3 | - | 7 | 4 |
    }
}
