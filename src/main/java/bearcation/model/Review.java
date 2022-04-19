package bearcation.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private long id;
    private @NonNull Double rating;
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private @NonNull User reviewer;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private @NonNull Location location;

    public Review(Double rating, String description, User user, Location location) {
        super();
        this.rating = rating;
        this.description = description;
        this.reviewer = user;
        this.location = location;
    }
}
