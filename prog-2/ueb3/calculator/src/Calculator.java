public class Calculator {
    public int compute(int a, int b, BinaryOperation operation) {
        return operation.apply(a, b);
    }
}
