package StackCalc;

import java.util.Stack;

public class CalcApp {
    public static void main(String[] args) {

        String inputDataTwo = "4+1-3+4";

        Stack<Integer> integerStack = new Stack<>();
        CalcApp calcApp = new CalcApp();
        System.out.println("Sum of this expression " + inputDataTwo + " = " + calcApp.calc(integerStack, inputDataTwo));
    }

    private int calc(Stack<Integer> stack, String input) {
        int tempInt = 0;
        Operation tempOperation = Operation.PLUS;
        for (int i = 0; i < input.length(); i++) {

            char temp = input.charAt(i);
            if (Character.isDigit(temp)) {
                tempInt = temp - '0';
            }

            if (!Character.isDigit(temp) || i == input.length() - 1) {
                switch (tempOperation) {
                    case PLUS:
                        stack.push(tempInt);
                        break;
                    case MINUS:
                        stack.push(-tempInt);
                        break;
                    case DIVISION:
                        int previousD = stack.pop() / tempInt;
                        break;
                    case MULTIPLY:
                        int previous = stack.pop();
                        stack.push(previous * tempInt);
                        break;
                    default:
                }
                tempOperation = Operation.getOperationBySymbol(temp);
                tempInt = 0;
            }
        }
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();

        }
        return sum;
    }
}

