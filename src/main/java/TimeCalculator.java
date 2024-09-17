
public class TimeCalculator {
    private final UnitConverter distanceConverter;
    private final UnitConverter speedConverter;

    public TimeCalculator(UnitConverter distanceConverter, UnitConverter speedConverter) {
        this.distanceConverter = distanceConverter;
        this.speedConverter = speedConverter;
    }

    public double calculateTime(double distance, double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be greater than zero.");
        }
        // Convert distance and speed to the same base unit (kilometers and kilometers per hour)
        double baseDistance = distanceConverter.convertToBaseUnit(distance);
        double baseSpeed = speedConverter.convertToBaseUnit(speed);

        // Time = distance / speed
        return baseDistance / baseSpeed;
    }
}
