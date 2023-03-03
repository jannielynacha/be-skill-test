package com.crescendo.service;

import com.crescendo.model.Review;

import java.util.List;

public interface IReviewService {
    List<Review> findAllByBusinessId(int businessId);
    Review save(Review review, int businessId);
}
