package bearcation.model.dto;

import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("Review DTO Tests")
public class ReviewDTOTests {

    @Test
    @DisplayName("Test Review DTO constructor")
    public void testReviewDTOConstruct() {
        User u = new User("timmy@gmail.com", "password", "timmy", "lastnameofmine");
        Set<String> s = new HashSet<String>();
        s.add("act1");
        s.add("act2");
        Location l = new Location("location cool", "poggers", s);
        Review rev = new Review(4.0, "this is a cool spot", u, l);

        // Test for equal values
        assertEquals(rev.getRating(), 4.0);
        assertEquals(rev.getDescription(), "this is a cool spot");

        // Test equal reviewer
        assertEquals(rev.getReviewer().getEmail(), "timmy@gmail.com");
        assertEquals(rev.getReviewer().getFirstName(), "timmy");
        assertEquals(rev.getReviewer().getLastName(), "lastnameofmine");
        assertEquals(rev.getReviewer().getPassword(), "password");

        // Test equal location
        assertEquals(rev.getLocation().getActivities(), s);
        assertEquals(rev.getLocation().getDescription(), "poggers");
        assertEquals(rev.getLocation().getName(), "location cool");
    }


    @Test
    @DisplayName("Test Rev DTO translate")
    public void testRevDTO() {
        User u = new User("timmy@gmail.com", "password", "timmy", "lastnameofmine");
        Set<String> s = new HashSet<String>();
        s.add("act1");
        s.add("act2");
        Location l = new Location("location cool", "poggers", s);
        Review rev = new Review(4.0, "this is a cool spot", u, l);
        ReviewDTO rdto = new ReviewDTO(rev);
        Review rev2 = rdto.toReview();

        // Test for equal values
        assertEquals(rev.getRating(), rev2.getRating());
        assertEquals(rev.getDescription(), rev2.getDescription());

        // Test equal reviewer
        assertEquals(rev.getReviewer().getEmail(), rev2.getReviewer().getEmail());
        assertEquals(rev.getReviewer().getFirstName(), rev2.getReviewer().getFirstName());
        assertEquals(rev.getReviewer().getLastName(), rev2.getReviewer().getLastName());
        assertEquals(rev.getReviewer().getPassword(), rev2.getReviewer().getPassword());

        // Test equal location
        assertTrue(rev.getLocation().getActivities().containsAll(rev2.getLocation().getActivities()));
        assertEquals(rev.getLocation().getDescription(), rev2.getLocation().getDescription());
        assertEquals(rev.getLocation().getName(), rev2.getLocation().getName());
    }

    @Test
    @DisplayName("Null user and location")
    public void testNullReviewDTO() {
        ReviewDTO rdto = new ReviewDTO(new Review(4.0, "this is a cool spot", null, null));
        Review rev2 = rdto.toReview();

        assertEquals(rev2.getReviewer(), null);
        assertEquals(rev2.getLocation(), null);
    }

}
