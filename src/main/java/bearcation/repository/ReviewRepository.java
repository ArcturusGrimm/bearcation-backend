package bearcation.repository;

import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

//    List<Review> findAllByUserId(Iterable<Long> longs);
//        List<Review> findAllByUser_id(Long id);
//        findReviewByRating;
    Optional<List<Review>> findReviewsByReviewer(User u);
    Optional<List<Review>> findReviewsByLocation(Location l);


}