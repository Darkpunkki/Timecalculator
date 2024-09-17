
public class MilesPerHourConverter implements UnitConverter {
    @Override
    public double convertToBaseUnit(double value) {
        return value * 1.60934;
    }
}