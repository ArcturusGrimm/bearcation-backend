package bearcation.repository;

import bearcation.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewerId(long user_id);
    List<Review> findByLocationId(long location_id);

}