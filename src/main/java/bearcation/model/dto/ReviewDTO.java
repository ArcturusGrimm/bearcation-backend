package bearcation.model.dto;

import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = { "reviewer", "location" })
@ToString(exclude = { "reviewer", "location" })
public class ReviewDTO {
    private Long id;
    private Double rating;
    private String description;
    private UserDTO reviewer;
    private LocationDTO location;

    public ReviewDTO(Review review) {
        if (review == null) {
            throw new RuntimeException("Review must not be null in ReviewDTO constructor");
        }
        id = review.getId();
        rating = review.getRating();
        description = review.getDescription();
        reviewer = null;
        if(review.getReviewer() != null){
            User r = review.getReviewer();
            reviewer = new UserDTO(
                    r.getId(),
                    r.getEmail(),
                    r.getPassword(),
                    r.getFirstName(),
                    r.getLastName(),
                    null,
                    null
            );
        }
        location = null;
        if(review.getLocation() != null){
            Location l = review.getLocation();
            location = new LocationDTO(
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
            );
        }
    }

    public Review toReview(){
        User reviewer = this.reviewer != null ? this.reviewer.toUser() : null;
        Location location = this.location != null ? this.location.toLocation() : null;
        return new Review(id, rating, description, reviewer, location);
    }
}
