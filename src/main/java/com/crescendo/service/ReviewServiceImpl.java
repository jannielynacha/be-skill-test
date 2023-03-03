package com.crescendo.service;

import com.crescendo.exception.BusinessNotFoundException;
import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {
    private final ReviewRepository reviewRepository;
    private final BusinessRepository businessRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, BusinessRepository businessRepository) {
        this.reviewRepository = reviewRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Review> findAllByBusinessId(int businessId) {
        return reviewRepository.findByBusinessId(businessId);
    }

    @Override
    public Review save(Review review, int businessId) {
        Optional<Business> businessOptional = businessRepository.findById(businessId);
        Review newReview = new Review();
        Business business = null;

        if(businessOptional.isPresent()) {
            business = businessOptional.get();
            review.setBusiness(business);

            return reviewRepository.save(review);
        }
        else {
            throw new BusinessNotFoundException(businessId);
        }
    }
}
