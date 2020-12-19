package com.adventofcode.day18;

import java.util.Stack;

public class OperationOfOrder {

    static int calculateMathLine(String math) {
        math += ".";
        boolean brackets = false;
        Stack<String> stack = new Stack<>();
        int number = 0;

        char[] mathAsCharArray = math.toCharArray();
        for (int i = 0; i < mathAsCharArray.length; i++) {
            char symbol = mathAsCharArray[i];
            if (symbol == ')') {
                StringBuilder newMath = new StringBuilder();
                int j = 0;
                while (j != 1) {
                    if (!stack.peek().equals("(")) {
                        newMath.insert(0, stack.pop());
                    } else {
                        stack.pop();
                        j = 1;
                    }
                }
                stack.push(String.valueOf(calculateMathLine(newMath.toString())));
                if (!stack.contains("(")) {
                    brackets = false;
                    int rightNumber = Integer.parseInt(stack.pop());
                    String operation = stack.pop();
                    int leftNumber = Integer.parseInt(stack.pop());
                    if (operation.equals("*")) {
                        stack.push(String.valueOf(leftNumber * rightNumber));
                    }
                    if (operation.equals("+")) {
                        stack.push(String.valueOf(leftNumber + rightNumber));
                    }
                }
            }

            if (('0' <= symbol) && (symbol <= '9')) {
                number += Integer.parseInt(String.valueOf(symbol));
                if (!brackets) {
                    if ((mathAsCharArray[i + 1] <= '0') || (mathAsCharArray[i + 1] >= '9')) {
                        try {
                            String operation = stack.pop();
                            int leftNumber = Integer.parseInt(stack.pop());
                            if (operation.equals("*")) {
                                stack.push(String.valueOf(leftNumber * number));
                            }
                            if (operation.equals("+")) {
                                stack.push(String.valueOf(leftNumber + number));
                            }
                        } catch (Exception e) {
                            stack.push(String.valueOf(number));
                        }
                        number = 0;
                    }
                } else {
                    stack.push(String.valueOf(number));
                }
            }
            if ((symbol == '+') || (symbol == '*')) {
                stack.push(String.valueOf(symbol));
            }
            if (symbol == '(') {
                stack.push(String.valueOf(symbol));
                brackets = true;
            }
        }

        return Integer.parseInt(stack.pop());
    }

}
