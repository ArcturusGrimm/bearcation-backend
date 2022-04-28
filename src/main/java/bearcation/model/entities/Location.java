package bearcation.model.entities;

import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "owner", "reviews" })
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    private String name;
    private String address;
    @Column(length = 1000)
    private String description;
    private Double price;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private Set<Review> reviews;

    @ElementCollection
    private Set<String> activities;

    public Location(String name, String address, String description, Double price, Double latitude, Double longitude) {
        // FIXME: owner had self-assignment, (I put it to null temporarily)
        this.owner = null;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String name, String description, Set<String> activities) {
        this.name = name;
        this.description = description;
        this.activities = activities;
    }
}