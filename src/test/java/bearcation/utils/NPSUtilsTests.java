package bearcation.utils;

import bearcation.model.requests.NationalPark;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("NPS Utils Tests")
public class NPSUtilsTests {

    @Test
    @DisplayName("Test NPS Data")
    public void testNPSData() {
        List<NationalPark> l = new NPSUtils().getNationalParks();
        assertTrue(!l.isEmpty());

        // Arbitrary Size check, more than 20
        // Essentially checks for more than a few
        assertTrue(l.size() > 20);
    }
}
