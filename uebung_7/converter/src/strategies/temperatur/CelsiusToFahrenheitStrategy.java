package strategies.temperatur;

import strategies.ConversionStrategy;

public final class CelsiusToFahrenheitStrategy extends ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 9 / 5 + 32;
    }
}
