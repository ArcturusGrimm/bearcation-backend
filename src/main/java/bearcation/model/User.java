package bearcation.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Location> ownedLocations;

    @OneToMany(mappedBy="reviewer", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> postedReviews;

    public User( String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}