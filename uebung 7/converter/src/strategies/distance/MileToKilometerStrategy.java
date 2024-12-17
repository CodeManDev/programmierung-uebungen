package strategies.distance;

import strategies.ConversionStrategy;

public final class MileToKilometerStrategy extends ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 1.609344f;
    }
}
