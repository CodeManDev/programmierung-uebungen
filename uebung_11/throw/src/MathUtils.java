public class MathUtils {

    public static double divide(int dividend, int divisor) throws IllegalArgumentException {
        if (divisor == 0)
            throw new IllegalArgumentException("Divisor must not be zero!");
        return (double) dividend / divisor;
    }

}
