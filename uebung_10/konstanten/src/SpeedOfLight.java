public class SpeedOfLight {

    public static final double SPEED_OF_LIGHT = 299_792_458.0;

    public static double fraction(double fraction) {
        if (fraction < 0 || fraction > 1) {
            throw new IllegalArgumentException("Fraction must be between 0 and 1.");
        }

        return SPEED_OF_LIGHT * fraction;
    }

    public static void printFraction(double fraction) {
        double fractionSpeed = fraction(fraction);

        System.out.printf("%.2f of the speed of light is %,.2f m/s.%n", fraction, fractionSpeed);
    }
}
