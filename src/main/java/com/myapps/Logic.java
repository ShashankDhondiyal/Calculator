package com.myapps;

import java.util.ArrayList;
import java.util.Stack;

public class Logic {
    static class TreeNode {
        String value;
        TreeNode left, right;

        TreeNode(String value) {
            this.value = value;
        }
    }

    ArrayList<String> equation = new ArrayList<>();

    public void addToEquation(String value) {
        if (equation.isEmpty() && (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))) {
            // Do not add the operator if it's the first element
            return;
        }
        if (!equation.isEmpty() && (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))) {
            String lastValue = equation.get(equation.size() - 1);
            if (lastValue.equals("+") || lastValue.equals("-") || lastValue.equals("*") || lastValue.equals("/")) {
                // Do not add the operator if the last element is also an operator
                return;
            }
        }
        equation.add(value);
    }

    public String getEquation() {
        return String.join("", equation);
    }

    public void clearEquation() {
        equation.clear();
    }

    public void setEquation(String equation) {
        this.equation.clear();
        for (char c : equation.toCharArray()) {
            this.equation.add(String.valueOf(c));
        }
    }

    public void setSingleValue(String value) {
        this.equation.clear();
        this.equation.add(value);
    }

    // Convert infix to postfix using Shunting Yard Algorithm
    public static String toPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                output.append(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                output.append(' '); // Separate numbers
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.append(operators.pop()).append(' ');
                }
                operators.pop(); // Remove '(' from stack
            } else {
                output.append(' '); // Separate numbers
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    output.append(operators.pop()).append(' ');
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            output.append(' ').append(operators.pop());
        }
        return output.toString();
    }

    // Build expression tree from postfix notation
    public static TreeNode buildTree(String postfix) {
        Stack<TreeNode> stack = new Stack<>();
        for (String token : postfix.split(" ")) {
            if (token.isEmpty()) continue;
            TreeNode node = new TreeNode(token);
            if ("+-*/".contains(token)) {
                node.right = stack.pop(); // Pop second operand first
                node.left = stack.pop();  // Pop first operand
            }
            stack.push(node);
        }
        return stack.pop();
    }

    // Evaluate expression tree recursively
    public static double evaluate(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return Double.parseDouble(root.value);

        double left = evaluate(root.left);
        double right = evaluate(root.right);

        switch (root.value) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return 0;
        }
    }

    private static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }
}
