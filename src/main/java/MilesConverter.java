
public class MilesConverter implements UnitConverter {
    @Override
    public double convertToBaseUnit(double value) {
        return value * 1.60934; // Convert miles to kilometers
    }
}