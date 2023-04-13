package Hw5_21002139_PhamNgocHai.ex2.ex2_3;

import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;
import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree.Node;

public class CalculateExpressionTree {
    public static double result(LinkedBinaryTree<String> tree) {
        return evaluateExpressionTree(tree.getRoot());
    }

    private static double evaluateExpressionTree(Node<String> node) {
        if (node == null) {
            return 0;
        }

        // check is this node is leaf node
        if (node.getLeft() == null && node.getRight() == null) {
            return Double.parseDouble(node.getElement().toString());
        }

        double leftOperand = evaluateExpressionTree(node.getLeft());
        double rightOperand = evaluateExpressionTree(node.getRight());
        
        switch ((String) node.getElement()) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            case "^":
                return Math.pow(leftOperand, rightOperand);
            default:
                throw new IllegalArgumentException("Invalid operator: " + node.getElement());
        }
    }
}
