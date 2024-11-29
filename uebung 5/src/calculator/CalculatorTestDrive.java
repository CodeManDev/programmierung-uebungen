package calculator;

import java.util.List;
import java.util.Scanner;

public class CalculatorTestDrive {

    public static void main(String[] args) {
        System.out.println("calculator.Calculator test drive");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Run tests? (y/n): ");
        String runTests = scanner.nextLine();
        if (runTests.equals("y")) {
            test();
            return;
        }

        System.out.println("Enter first number: ");
        double number1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double number2 = scanner.nextDouble();
        System.out.println("Enter operator (+, -, *, /): ");
        String operator = scanner.next();

        CalculationStep calculationStep = new CalculationStep(number1, number2, 0, operator);

        Calculator calculator = new Calculator();

        double result = calculator.calculate(calculationStep.number1(), calculationStep.number2(), calculationStep.operator());
        System.out.println("Result: " + result);

    }

    public static void test() {
        List<CalculationStep> calculationSteps = List.of(
                new CalculationStep(2, 3, 5, "+"),
                new CalculationStep(10, 2, 5, "/"),
                new CalculationStep(5, 5, 0, "?"),
                new CalculationStep(5, 0, 0, "/"),
                new CalculationStep(-5, -3, -2, "-")
        );

        Calculator calculator = new Calculator();

        int testsFailed = 0;

        for (CalculationStep calculationStep : calculationSteps) {
            System.out.println("Testing: " + calculationStep.number1() + " " + calculationStep.operator() + " " + calculationStep.number2());
            double result = calculator.calculate(calculationStep.number1(), calculationStep.number2(), calculationStep.operator());
            if (result != calculationStep.expectedResult()) {
                System.out.println("Expected result: " + calculationStep.expectedResult());
                System.out.println("Actual result: " + result);
                testsFailed++;
            } else {
                System.out.println("Actual result: " + result);
            }
            System.out.println();
        }

        if (testsFailed == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(testsFailed + " tests failed!");
        }
    }
}