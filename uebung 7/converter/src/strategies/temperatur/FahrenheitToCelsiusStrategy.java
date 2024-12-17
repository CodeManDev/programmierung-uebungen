package strategies.temperatur;

import strategies.ConversionStrategy;

public final class FahrenheitToCelsiusStrategy extends ConversionStrategy {
    @Override
    public float convert(float value) {
        return (value - 32) * 5 / 9;
    }
}
