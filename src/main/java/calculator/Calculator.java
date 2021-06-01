package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers;
    private final List<String> operators;

    public Calculator(String expression) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        String[] splits = expression.split(" ");
        for (int i = 0; i < splits.length; i++) {
            classify(splits[i], i);
        }

        if (numbers.size() - 1 != operators.size()) {
            throw  new IllegalArgumentException();
        }
    }

    private void classify(String split, int index) {
        if (index % 2 == 0) {
            numbers.add(Integer.parseInt(split));
            return;
        }
        if (isNotOperator(split)) {
            throw new IllegalArgumentException();
        }
        operators.add(split);
    }

    private boolean isNotOperator(String operator) {
        return !("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator));
    }

    public int calculate() {
        while (numbers.size() > 1) {
            int operand1 = numbers.remove(0);
            int operand2 = numbers.remove(0);
            String operator = operators.remove(0);
            int result = calculate(operand1, operand2, operator);
            numbers.add(0, result);
        }
        return numbers.get(0);
    }

    private int calculate(int operand1, int operand2, String operator) {
        if ("+".equals(operator)) {
            return operand1 + operand2;
        }

        if ("-".equals(operator)) {
            return operand1 - operand2;
        }

        if ("*".equals(operator)) {
            return operand1 * operand2;
        }

        return operand1 / operand2;
    }
}
