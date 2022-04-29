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
@DisplayName("User DTO Tests")
public class UserDTOTests {

    @Test
    @DisplayName("Test User DTO constructor")
    public void testUserDTOConstructor() {
        User u = new User("timmy@gmail.com", "password", "timmy", "mfoutchkeerr");
        UserDTO udto = new UserDTO(u);
        assertEquals(udto.getEmail(), u.getEmail());
        assertEquals(udto.getPassword(), u.getPassword());
        assertEquals(udto.getFirstName(), u.getFirstName());
        assertEquals(udto.getLastName(), u.getLastName());
    }

    @Test
    @DisplayName("User DTO Translation Test")
    public void testUserDTOTranslate() {
        User u = new User("timmy@gmail.com", "password", "timmy", "mfoutchkeerr");
        Review r1 = new Review(4.5, "aefeon", u, null);
        Review r2 = new Review(4.1, "wefkjbgew", u, null);
        Review r3 = new Review(5.0, "sefewegooivon", u, null);
        Review r4 = new Review(2.0, "fekj", u, null);
        Set<String> s1 = new HashSet<String>();
        s1.add("act 1.1");
        s1.add("act 1.2");
        s1.add("act 1.3");
        Set<String> s2 = new HashSet<String>();
        s2.add("act 2.1");
        s2.add("act 2.2");
        Location l1 = new Location("loc test 1", "test location awlkdn", s1);
        Location l2 = new Location("loc test 2", "test location eflkasnj", s2);
        l1.setOwner(u);
        l2.setOwner(u);
        UserDTO udto = new UserDTO(u);
        User u2 = udto.toUser();

        assertEquals(u.getEmail(), u2.getEmail());
        assertEquals(u.getPassword(), u2.getPassword());
        assertEquals(u.getFirstName(), u2.getFirstName());
        assertEquals(u.getLastName(), u2.getLastName());
        assertTrue(u.getPostedReviews().containsAll(u2.getPostedReviews()));
        assertTrue(u.getOwnedLocations().containsAll(u2.getOwnedLocations()));
    }
}
