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
@EqualsAndHashCode(exclude = { "owner", "reviews" })
@ToString(exclude = { "owner", "reviews" })
public class LocationDTO {
    private Long id;
    private String name;
    private String address;
    private String description;
    private Double price;
    private Double latitude;
    private Double longitude;
    // private String nationalParkId;
    private UserDTO owner;
    private Set<ReviewDTO> reviews;

    private Set<String> activities;

    public LocationDTO(Location location) {
        if (location == null) {
            throw new RuntimeException("Location must not be null in LocationDTO constructor");
        }
        id = location.getId();
        name = location.getName();
        address = location.getAddress();
        description = location.getDescription();
        price = location.getPrice();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        activities = location.getActivities();
        owner = null;
        reviews = null;
        if (location.getReviews() != null) {
            reviews = location.getReviews().stream().map(r ->
                    new ReviewDTO(
                            r.getId(),
                            r.getRating(),
                            r.getDescription(),
                            null,
                            null
                    )).collect(Collectors.toSet());
        }

    }
    public Location toLocation(){
        Set<Review> reviews = this.reviews != null ? this.reviews.stream().map(ReviewDTO::toReview).collect(Collectors.toSet()) : null;
        User owner = this.owner != null ? this.owner.toUser() : null;
        return new Location(id, owner, name, address, description, price, latitude, longitude, reviews, activities);
    }
}
