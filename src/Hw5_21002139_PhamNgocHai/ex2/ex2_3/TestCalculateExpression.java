package Hw5_21002139_PhamNgocHai.ex2.ex2_3;

import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;
import Hw5_21002139_PhamNgocHai.ex3.BuildTreeExpression;

public class TestCalculateExpression {
    public static void main(String[] args) {
        String expression = "((65.4/3.0 + (8/4.0 - 5)))^2.1";

        LinkedBinaryTree<String> treeExpression = BuildTreeExpression.buildTreeExpression(expression);
        System.out.println(CalculateExpressionTree.result(treeExpression)); // 18.8^2.1 => print 473.9488605100905
    }
}
