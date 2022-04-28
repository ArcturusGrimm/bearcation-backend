package bearcation.utils;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTests {

    // Checks normal process
    @Test
    @DisplayName("Test Calculate Distance Method 1")
    public void testCalcDistance1() {

        // Setup
        double lat1 = 0.0;
        double long1 = -12.1;
        double long2 = 102.2222;
        double lat2 = -12.1;

        // Test calculate
        double testVal = MathUtils.calculateDistance(lat1, long1, lat2, long2);
        double expectedValue = 12640;

        // Make sure we are right within 1% of the expected value
        assertEquals(testVal, expectedValue, expectedValue / 100);
    }

    // Checks equality
    @Test
    @DisplayName("Test Calculate Distance Method 2")
    public void testCalcDistance2() {

        // Setup
        double lat1 = 0.0;
        double long1 = 0.0;
        double long2 = 0.0;
        double lat2 = 0.0;

        // Test calculate
        double testVal = MathUtils.calculateDistance(lat1, long1, lat2, long2);
        double expectedValue = 0.0;

        // Make sure we are right within 1% of the expected value
        assertEquals(testVal, expectedValue, expectedValue / 100);
    }

    // Checks for wrap around on the globe
    @Test
    @DisplayName("Test Calculate Distance Method 3")
    public void testCalcDistance3() {

        // Setup
        double lat1 = 0.0;
        double long1 = 179.0;
        double long2 = -179.0;
        double lat2 = 0.0;

        // Test calculate
        double testVal = MathUtils.calculateDistance(lat1, long1, lat2, long2);
        double expectedValue = 222.0;

        // Make sure we are right within 1% of the expected value
        assertEquals(testVal, expectedValue, expectedValue / 100);
    }
}
