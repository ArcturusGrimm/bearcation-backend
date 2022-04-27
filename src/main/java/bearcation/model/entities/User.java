package bearcation.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "ownedLocations", "postedReviews" })
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    private Set<Location> ownedLocations;

    @OneToMany(mappedBy="reviewer", cascade=CascadeType.ALL)
    private Set<Review> postedReviews;

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}