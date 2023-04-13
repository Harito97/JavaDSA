package Hw5_21002139_PhamNgocHai.ex2.ex2_2;

import Hw5_21002139_PhamNgocHai.ex2.ex2_1.ExpressionTree;
import Hw5_21002139_PhamNgocHai.ex3.BuildTreeExpression;

public class TestExpressionTreePrint {
    public static void main(String[] args) {
        String expression = "(65.4/3.0 + (8/4.0 - 5))";
        expression = "(6/2 + 3) * (7 - 4)";

        ExpressionTree<String> tree = new ExpressionTree<>(BuildTreeExpression.buildTreeExpression(expression).getRoot());
        
        System.out.println("\nPrint tree follow pre order");
        tree.preOrderPrint(tree.getRoot());
        System.out.println("\nPrint tree follow in order");
        tree.inOrderPrint(tree.getRoot(), true);
        System.out.println("\nPrint tree follow post order");
        tree.postOrderPrint(tree.getRoot());
        System.out.println("\n");
    }
}
