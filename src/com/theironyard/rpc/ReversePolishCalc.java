package com.theironyard.rpc;

public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    int stackTop;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {
        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[ tokens.length ];
        stackTop = 0;

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            String currentToken = tokens[i];

            // convert the current token to a number
            Double num = null;

            try {
                num = Double.parseDouble(currentToken);
            } catch (NumberFormatException ex) {
                // eat it.
            }

            // when we're here, either num has a value
            // or it is null. if it's null, that means
            // we just encountered an operator
            if (num != null) {
                push(num);
            } else {
                if (currentToken.equals("+")) {
                    double value1 = pop();
                    double value2 = pop();

                    push(value2 + value1);
                } else if (currentToken.equals("-")) {
                    double value1 = pop();
                    double value2 = pop();

                    push(value2 - value1);
                } else if (currentToken.equals("/")) {
                    double value1 = pop();
                    double value2 = pop();

                    push(value2 / value1);
                } else if (currentToken.equals("*")) {
                    double value1 = pop();
                    double value2 = pop();

                    push(value2 * value1);
                }
            }
        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        stack[stackTop] = number;
        stackTop++;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        push(Double.toString(d));
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        // step 1: move the top of the stack back by 1
        stackTop--;

        // step 2: retrieve the value of the stack at the current element;
        String value = stack[stackTop];

        // step 3: reset the value in the stack to null
        stack[stackTop] = null;

        // step 4: return the double version of this string
        return Double.parseDouble(value);
    }
}
