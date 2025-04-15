package strategies.distance;

import strategies.ConversionStrategy;

public final class KilometerToMileStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return value * 0.6213712f;
    }

    @Override
    public String getDescription() {
        return "Kilometer to Mile";
    }
}
