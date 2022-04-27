package bearcation.model.dto;

import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "ownedLocations", "postedReviews" })
@ToString(exclude = { "ownedLocations", "postedReviews" })
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<LocationDTO> ownedLocations;
    private Set<ReviewDTO> postedReviews;

    public UserDTO(User user) {
        if (user == null) {
            throw new RuntimeException("User must not be null in UserDTO constructor");
        }
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();
        ownedLocations = null;
        if (user.getOwnedLocations() != null) {
            ownedLocations = user.getOwnedLocations().stream().map(l ->
                    new LocationDTO(
                            l.getId(),
                            l.getName(),
                            l.getAddress(),
                            l.getDescription(),
                            l.getPrice(),
                            l.getLatitude(),
                            l.getLongitude(),
                            null,
                            null,
                            l.getActivities()
                    )).collect(Collectors.toSet());
        }
        postedReviews = null;
        if (user.getPostedReviews() != null) {
            postedReviews = user.getPostedReviews().stream().map(r ->
                    new ReviewDTO(
                            r.getId(),
                            r.getRating(),
                            r.getDescription(),
                            null,
                            null
                    )).collect(Collectors.toSet());
        }
    }

    public User toUser() {
        Set<Location> ownedLocations = this.ownedLocations != null ? this.ownedLocations.stream().map(LocationDTO::toLocation).collect(Collectors.toSet()) : null;
        Set<Review> postedReviews = this.postedReviews != null ? this.postedReviews.stream().map(ReviewDTO::toReview).collect(Collectors.toSet()) : null;
        return new User(id, email, password, firstName, lastName, ownedLocations, postedReviews);
    }
}
