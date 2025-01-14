package strategies.temperatur;

import strategies.ConversionStrategy;

public final class CelsiusToFahrenheitStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 9 / 5 + 32;
    }

    @Override
    public String getDescription() {
        return "Celsius to Fahrenheit";
    }
}
