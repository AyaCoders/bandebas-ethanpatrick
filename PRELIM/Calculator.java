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

public class Calculator {
    static int simplify(char operator, Stack<Integer> numbers) {
        int res = 0;
        int pop1 = 0;
        int pop2 = 0;

        if (numbers.size() >= 2) {
            pop1 = numbers.pop();
            pop2 = numbers.pop();
        }

        switch (operator) {
            case '+':
                res = pop2 + pop1;
                break;
            case '/':
                res = pop2 / pop1;
                break;
            case '*':
                res = pop2 * pop1;
                break;
            case '-':
                res = pop2 - pop1;
                break;
        }
        return res;
    }

    static void evaluatePostFix(String postFixString) {
        Stack<Integer> numbers = new Stack<>();
        String operator = "/+-*";

        for (int i = 0; i < postFixString.length(); i++) {
            char currentChar = postFixString.charAt(i);
            if (Character.isDigit(currentChar)) {
                numbers.push(Character.getNumericValue(currentChar));
            } else if (operator.contains(Character.toString(currentChar))) {
                numbers.push(simplify(currentChar, numbers));
            }
        }
        // Output Result
        int res = numbers.pop();
        numbers.clear();
        System.out.println("\nResult: " + res);
    }

    // Function to process each character index in the expression
    static void processCharacter(char token, Queue<Character> postFix, Stack<Character> operators) {
        String opTable = "/*+-";

        System.out.println("\nCurrent Character: " + token);

        if (Character.isDigit(token)) {
            postFix.add(token);
            return;
        } else if (opTable.contains(Character.toString(token))) {
            if (operators.isEmpty()) {
                operators.push(token);
                return;
            }

            char top = operators.peek();
            System.out.println("Peeked: " + top);
            // If same precedence then put it in operands 
            if ((top == '/' && token == '*') || (top == '*' && token == '/')
                || (top == '+' && token == '-') || (top == '-' && token == '+')
                || (top == token)) {
                while (!operators.isEmpty()) {
                    if (top == '(') {
                        operators.pop(); // Remove '('
                        break;
                    }

                    char ch = operators.pop();
                    postFix.add(ch);

                    // Check first before peek
                    if (!operators.isEmpty()) {
                        top = operators.peek();
                    }
                }

                operators.push(token);

            } else if (top == '(') {
                operators.push(token);
            } else {
                operators.push(token);
            }

        } else if (token == '(') {
            operators.push(token);
        } else if (token == ')') { // if ')' is met then add top stack to postfix before '('
            System.out.println("Removing Parenthesis");
            while (operators.peek() != '(') {
                char ch = operators.pop();
                postFix.add(ch);
            }
            operators.pop(); // Remove '('
        }
    }

    // Function to convert expression from Infix to Postfix
    static String toPostFix(String equation) {
        Queue<Character> postFix = new LinkedList<>();
        Stack<Character> operators = new Stack<>();
        String res = "";
        // Pass each character to the function to process
        for (int i = 0; i < equation.length(); i++) {
            processCharacter(equation.charAt(i), postFix, operators);
            System.out.println("PostFix: " + postFix);
            System.out.println("Operators: " + operators);
        }
        // After processing and operators is not empty, flush contents into
        // postFix
        while (!operators.isEmpty()) {
            char topOfOps = operators.pop();
            postFix.offer(topOfOps);
        }
        // flush postFix to String
        while (!postFix.isEmpty()) {
            res += postFix.poll();
        }

        System.out.println("Postfix Form: " + res);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char choice;
        String equation;

        do {
            System.out.println("Enter expression: ");
            equation = in.nextLine().replaceAll(" ", "");

            String postFixString = toPostFix(equation);
            evaluatePostFix(postFixString);

            System.out.print("\nEnter another expression?\nAnswer: ");
            choice = in.next().charAt(0);
            in.nextLine(); // flush input stream
        } while (Character.toUpperCase(choice) == 'Y');
    }
}