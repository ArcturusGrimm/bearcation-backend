package bearcation.service;

import bearcation.model.dto.ReviewDTO;
import bearcation.model.dto.UserDTO;
import bearcation.model.entities.Location;
import bearcation.model.entities.Review;
import bearcation.model.entities.User;
import bearcation.model.requests.CreateAccountRequest;
import bearcation.model.requests.CreateReviewRequest;
import bearcation.repository.LocationRepository;
import bearcation.repository.ReviewRepository;
import bearcation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, LocationRepository locationRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }
    public ReviewDTO createReview(CreateReviewRequest createReviewRequest) {
        Location park = locationRepository.findLocationByName(createReviewRequest.getLocationName()).orElse(null);
        return new ReviewDTO(reviewRepository.save(new Review(createReviewRequest.getRating(), createReviewRequest.getDescription(), null, park)));
    }

}