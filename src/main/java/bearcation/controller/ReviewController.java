package bearcation.controller;

import bearcation.model.Location;
import bearcation.model.User;
import bearcation.service.ReviewService;
import bearcation.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @PostMapping("/addReview")
    public Review saveReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }

}
