package strategies.distance;

import strategies.ConversionStrategy;

public final class MileToKilometerStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 1.609344f;
    }

    @Override
    public String getDescription() {
        return "Mile to Kilometer";
    }
}
