package strategies.temperatur;

import strategies.ConversionStrategy;

public final class FahrenheitToCelsiusStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public String getDescription() {
        return "Fahrenheit to Celsius";
    }
}
