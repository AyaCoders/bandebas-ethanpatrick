/*
        This program computes arithmetic expressions,
        that follows the rules of PEMDAS.

        Written by: Aya
        Algorithm: Shunting Yard

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Calculator {
    // Check if operator
    static boolean isOperator(char token) {
        return "+-*/".contains(Character.toString(token));
    }

    static boolean isParenthesis(char token) {
        return "()".contains(Character.toString(token));
    }

    static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    static double evaluator(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    static double evaluateExp(Queue<String> operands) {
        Stack<Double> stack = new Stack<>();

        while (!operands.isEmpty()) {
            String token = operands.poll();

            if (token.length() == 1 && isOperator(token.charAt(0)) && stack.size() >= 2) {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double result = evaluator(num1, num2, token.charAt(0));
                stack.push(result);
            } else {
                double operand = Double.parseDouble(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }

    static void toPostFix(String equation) {
        Stack<Character> operators = new Stack<>();
        Queue<String> operands = new LinkedList<>();

        System.out.println("Equation: " + equation);

        for (int i = 0; i < equation.length(); i++) {
            char current = equation.charAt(i);

            if (Character.isDigit(current) || current == '.') { // operand character
                StringBuilder digit = new StringBuilder();

                while (i < equation.length() && (Character.isDigit(equation.charAt(i) ) || equation.charAt(i) == '.')) {
                    digit.append(equation.charAt(i));
                    i++;
                }

                i--;
                operands.add(digit.toString());
            } else if (isOperator(current)) { // operator character
                if (operators.isEmpty() || operators.peek() == '(') {
                    operators.push(current);
                } else {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(current)) {
                        operands.add(Character.toString(operators.pop()));
                    }
                    operators.push(current);
                }
            } else if (isParenthesis(current)) {
                if (current == '(') {
                    operators.push(current);
                } else if (current == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        operands.add(Character.toString(operators.pop()));
                    }

                    if (!operators.isEmpty() && operators.peek() == '(') {
                        operators.pop(); // Remove the opening parenthesis
                    }
                }
            }
        }

        while (!operators.isEmpty()) {
            operands.add(Character.toString(operators.pop()));
        }

        System.out.println("\nPostfix: " + operands);
        System.out.println("Evaluate: " + evaluateExp(operands));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter equation: ");
        String equation = in.nextLine().replace(" ", "");

        toPostFix(equation);
    }
}
