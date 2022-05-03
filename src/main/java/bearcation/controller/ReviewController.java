package bearcation.controller;

import bearcation.model.dto.LocationDTO;
import bearcation.model.dto.ReviewDTO;
import bearcation.model.dto.UserDTO;
import bearcation.model.entities.Review;
import bearcation.model.requests.CreateLocationRequest;
import bearcation.model.requests.CreateReviewRequest;
import bearcation.service.LocationService;
import bearcation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @PostMapping("/createReview")
    public ReviewDTO createReview(@RequestBody CreateReviewRequest createReviewRequest) {
        return reviewService.createReview(createReviewRequest);
    }
    @GetMapping("/search/location/{id}")
    public List<ReviewDTO> findReviewsByLocation(@PathVariable Long id){
        return reviewService.findReviewsByLocation(id);
    }

    @GetMapping("/search/user/{id}")
    public List<ReviewDTO> findReviewsByReviewer(@PathVariable Long id){
        return reviewService.findReviewsByReviewer(id);
    }

//
//
//    @GetMapping("/reviews")
//    public List<Review> getReviewsByUserId() {
//        return reviewService.getReviews();
//    }
}

//    @Autowired
//    private ReviewService reviewService;
//
//    @GetMapping("/reviews")
//    public List<Review> getReviews() {
//        return reviewService.getReviews();
//    }
//
//    @PostMapping("/addReview")
//    public Review saveReview(@RequestBody Review review){
//        return reviewService.createReview(review);
//    }
