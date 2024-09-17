import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeCalculatorTest {

    @Test
    public void testCalculateTimeWithKilometers() {
        TimeCalculator calculator = new TimeCalculator(new KilometersConverter(), new KilometersPerHourConverter());
        double time = calculator.calculateTime(100, 50); // 100 km, 50 km/h
        Assertions.assertEquals(2.0, time, 0.001);
    }

    @Test
    public void testCalculateTimeWithMiles() {
        TimeCalculator calculator = new TimeCalculator(new MilesConverter(), new MilesPerHourConverter());
        double time = calculator.calculateTime(62, 30); // 62 miles, 30 mph
        Assertions.assertEquals(2.066, time, 0.001);
    }

    @Test
    public void testCalculateTimeZeroSpeed() {
        TimeCalculator calculator = new TimeCalculator(new KilometersConverter(), new KilometersPerHourConverter());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateTime(100, 0));
    }

    @Test
    public void testCalculateTimeNegativeSpeed() {
        TimeCalculator calculator = new TimeCalculator(new KilometersConverter(), new KilometersPerHourConverter());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateTime(100, -10));
    }
}