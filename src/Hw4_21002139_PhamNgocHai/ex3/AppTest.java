package Hw4_21002139_PhamNgocHai.ex3;

public class AppTest {
    public static void main(String[] args) throws Exception {
        String expression;
        expression = "(1 + ((2 + 3) * (4 * 5)))"; // 101
        expression = "{[(50 - ((8 - 4) * (2 + 3))) + (3 * 4)] / 2}"; // 21
        //expression = "(5 - (2 / 2))";   // 4
        BracketMatching.bracketMatching(expression);
    }
}
