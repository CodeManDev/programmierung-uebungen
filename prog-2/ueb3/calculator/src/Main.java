public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        BinaryOperation addition = (a, b) -> a + b;
        BinaryOperation subtraction = (a, b) -> a - b;
        BinaryOperation multiplication = (a, b) -> a * b;
        BinaryOperation division = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        };

        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;
        System.out.println("a: " + a + ", b: " + b);
        System.out.println("Addition: " + calculator.compute(a, b, addition));
        System.out.println("Subtraction: " + calculator.compute(a, b, subtraction));
        System.out.println("Multiplication: " + calculator.compute(a, b, multiplication));
        System.out.println("Division: " + calculator.compute(a, b, division));
    }
}