package com.crescendo.controller.rest;

import com.crescendo.model.Review;
import com.crescendo.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final IReviewService reviewService;

    @Autowired
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // get all reviews
    @GetMapping("/api/businesses/{id}/reviews")
    public List<Review> reviewList(@PathVariable int id) {
        return reviewService.findAllByBusinessId(id);
    }

    // get a new review for a business
    @PostMapping("/api/businesses/{id}/reviews")
    public Review add(@RequestBody Review review, @PathVariable int id) {
        return reviewService.save(review, id);
    }
}
