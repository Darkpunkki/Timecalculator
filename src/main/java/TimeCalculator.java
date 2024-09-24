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

    public static void main(String[] args) {
        // Example usage with kilometers and kilometers per hour
        UnitConverter distanceConverter = new KilometersConverter();
        UnitConverter speedConverter = new KilometersPerHourConverter();

        TimeCalculator calculator = new TimeCalculator(distanceConverter, speedConverter);

        double distance = 150; // Distance in kilometers
        double speed = 75;     // Speed in kilometers per hour

        double time = calculator.calculateTime(distance, speed);

        System.out.printf("Time required to travel %.2f kilometers at %.2f km/h is %.2f hours.%n", distance, speed, time);

        // Example usage with miles and miles per hour
        UnitConverter milesDistanceConverter = new MilesConverter();
        UnitConverter milesSpeedConverter = new MilesPerHourConverter();

        TimeCalculator milesCalculator = new TimeCalculator(milesDistanceConverter, milesSpeedConverter);

        double milesDistance = 100; // Distance in miles
        double milesSpeed = 60;     // Speed in miles per hour

        double milesTime = milesCalculator.calculateTime(milesDistance, milesSpeed);

        System.out.printf("Time required to travel %.2f miles at %.2f mph is %.2f hours.%n", milesDistance, milesSpeed, milesTime);
    }
}
