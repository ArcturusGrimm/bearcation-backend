package bearcation.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private Set<Review> ownedLocations;

    private String name;
    private String address;

    @Column(length = 1000)
    private String description;
    private Double price;
    private Double longitude;
    private Double latitude;

    @ElementCollection
    private List<String> activities;



}
