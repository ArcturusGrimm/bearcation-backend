package bearcation.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private Long id;
    private Double rating;
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Review(Double rating, String description, User user, Location location) {
        super();
        this.rating = rating;
        this.description = description;
        this.reviewer = user;
        this.location = location;
    }

}
