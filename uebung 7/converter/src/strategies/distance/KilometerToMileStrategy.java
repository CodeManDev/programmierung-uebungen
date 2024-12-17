package strategies.distance;

import strategies.ConversionStrategy;

public final class KilometerToMileStrategy extends ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 0.6213712f;
    }
}
