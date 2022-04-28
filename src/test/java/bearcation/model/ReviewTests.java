package bearcation.model;

import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import bearcation.model.requests.CreateReviewRequest;
import bearcation.repository.LocationRepository;
import bearcation.repository.ReviewRepository;
import bearcation.repository.UserRepository;
import bearcation.service.LocationService;
import bearcation.service.ReviewService;
import bearcation.service.UserService;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Nested
@DisplayName("Review Tests")
public class ReviewTests {
    User u = new User();
    UserRepository repoUser = mock(UserRepository.class);
    UserService servUser = new UserService(repoUser);
    Location l = new Location();
    LocationRepository repoLoc = mock(LocationRepository.class);
    LocationService servLoc = new LocationService(repoUser, repoLoc);
    Review rev = null;
    ReviewRepository repository = mock(ReviewRepository.class);
    ReviewService service = new ReviewService(repository, repoUser, repoLoc);

    @Before
    public void createReview(){
        rev = new Review();
        rev.setRating(5.0);
        rev.setDescription("cool place, very cool");
        rev.setReviewer(u);
        rev.setLocation(l);
    }


    @Test
    @DisplayName("Review Test Constructed")
    public void testGoodRevConstructor() {
        assertEquals(rev.getRating(), 5.0);
        assertEquals(rev.getDescription(), "cool place, very cool");
        assertEquals(rev.getReviewer(), u);
        assertEquals(rev.getLocation(), l);
    }
}
