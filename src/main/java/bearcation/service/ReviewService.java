package bearcation.service;

import bearcation.model.Review;
import bearcation.model.User;
import bearcation.repository.ReviewRepository;
import bearcation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        return this.reviewRepository.findAll();
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

}
