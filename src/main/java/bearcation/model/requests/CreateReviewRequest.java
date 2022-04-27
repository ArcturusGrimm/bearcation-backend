package bearcation.model.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class CreateReviewRequest {
    private Long ownerId;
    private String locationName;
    private Double rating;
    private String description;
}