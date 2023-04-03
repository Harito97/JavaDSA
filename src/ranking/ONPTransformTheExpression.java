package DataStructureAndAlgorithms.AssignmentLT.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ONPTransformTheExpression {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numExpressions = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numExpressions; i++) {
                String input = reader.readLine();
                String postfix = infixToPostfix(input);
                System.out.println(postfix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            
            if (Character.isLetterOrDigit(c))
                result.append(c);
                
            else if (c == '(')
                stack.push(c);
                
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                    
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result.append(stack.pop());
                    
                stack.push(c);
            }
        
        }
        
        while (!stack.isEmpty())
            result.append(stack.pop());
            
        return result.toString();
    }
}

/*
 * Transform the algebraic expression with brackets into RPN form (Reverse
 * Polish Notation). Two-argument operators: +, -, *, /, ^ (priority from the
 * lowest to the highest), brackets ( ). Operands: only letters: a,b,...,z.
 * Assume that there is only one RPN form (no expressions like a*b*c).
 * 
 * Input
 * t [the number of expressions <= 100]
 * expression [length <= 400]
 * [other expressions]
 * Text grouped in [ ] does not appear in the input file.
 * 
 * Output
 * The expressions in RPN form, one per line.
 * Example
 * Input:
 * 3
 * (a+(b*c))
 * ((a+b)*(z+x))
 * ((a+t)*((b+(a+c))^(c+d)))
 * 
 * Output:
 * abc*+
 * ab+zx+*
 * at+bac++cd+^*
 */