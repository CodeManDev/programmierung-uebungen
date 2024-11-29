package calculator;

public class Calculator {

    public double calculate(double number1, double number2, String operator) {
        return switch (operator) {
            case "+" -> add(number1, number2);
            case "-" -> subtract(number1, number2);
            case "*" -> multiply(number1, number2);
            case "/" -> divide(number1, number2);
            default -> {
                System.out.println("Invalid operator!");
                yield 0;
            }
        };
    }

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        if (number2 == 0) {
            System.out.println("Division by zero is not allowed!");
            return 0;
        }
        return number1 / number2;
    }
}
