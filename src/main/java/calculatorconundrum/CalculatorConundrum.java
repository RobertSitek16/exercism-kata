package calculatorconundrum;

import java.util.Set;

public class CalculatorConundrum {

    public String calculate(int operand1, int operand2, String operation) {
        Set<String> possibleOperations = Set.of("+", "*", "/");
        handleInvalidOperations(operand2, operation, possibleOperations);
        int result = operation.equals("+") ? operand1 + operand2 :
                operation.equals("*") ? operand1 * operand2 : operand1 / operand2;
        return String.format("%d %s %d = %s", operand1, operation, operand2, result);
    }

    private void handleInvalidOperations(int operand2, String operation, Set<String> possibleOperations) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        } else if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        } else if (!possibleOperations.contains(operation)) {
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        } else if (operation.equals("/") && operand2 == 0) {
            throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
        }
    }

}
