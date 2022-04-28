package bearcation.model.dto;


import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("Location DTO Tests")
public class LocationDTOTests {

    @Test
    @DisplayName("Location DTO test good constructor {no reviews}")
    public void testLocationDTOConstructor() {
        Set<String> s = new HashSet<String>();
        s.add("act1");
        s.add("act2");
        Location l = new Location("location test", "epic gamers unite", s);
        LocationDTO ldto = new LocationDTO(l);

        // Test for equality
        assertEquals(ldto.getName(), l.getName());
        assertEquals(ldto.getDescription(), l.getDescription());
        assertTrue(ldto.getActivities().containsAll(l.getActivities()));
    }

    @Test
    @DisplayName("Test LocationDTO toLocation translation {no reviews}")
    public void testLocationDTOTranslation() {
        Set<String> s = new HashSet<String>();
        s.add("act1");
        s.add("act2");
        Location l = new Location("location test", "epic gamers unite", s);
        LocationDTO ldto = new LocationDTO(l);
        Location l2 = ldto.toLocation();

        // Test for equality
        assertEquals(l.getName(), l2.getName());
        assertEquals(l.getDescription(), l2.getDescription());
        assertTrue(l.getActivities().containsAll(l2.getActivities()));
    }

    @Test
    @DisplayName("Test LocationDTO toLocation translation {with reviews}")
    public void testLocationDTOTranslationReviews() {
        Set<String> s = new HashSet<String>();
        s.add("act1");
        s.add("act2");
        Location l = new Location("location test", "epic gamers unite", s);
        Review r1 = new Review(4.5, "aefeon", null, l);
        Review r2 = new Review(4.1, "wefkjbgew", null, l);
        Review r3 = new Review(5.0, "sefewegooivon", null, l);
        Review r4 = new Review(2.0, "fekj", null, l);

        LocationDTO ldto = new LocationDTO(l);
        Location l2 = ldto.toLocation();

        // Test for equality
        assertEquals(l.getName(), l2.getName());
        assertEquals(l.getDescription(), l2.getDescription());
        assertTrue(l.getActivities().containsAll(l2.getActivities()));

        // Test for Review population within LocationDTO constructor
        assertTrue(l.getReviews().containsAll(l2.getReviews()));
    }
}
